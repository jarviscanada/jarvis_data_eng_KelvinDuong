#!/bin/bash

if [ $# -ne 5 ];
then
    echo "Error: Invalid number of arguments"
    echo "Arguments: host port db_name username password"
    exit 1
fi

host=$1
port=$2
db_name=$3
username=$4
# set environment variable so you don't have to type in the password
export PGPASSWORD=$5

# variables used to find the linux resource usage data below
memory_usage=$(df -BM /)
cpu_usage=$(echo "$memory_usage" | awk '{print $5}' | sed -n 2p | egrep -o "([0-9]|[1-9][0-9]|100)")
hostname=$(hostname -f)

# linux resource usage data
timestamp=$(echo  $(vmstat -t) | egrep -o "[0-9]{4}-(1[1-2]|0[0-9])-([0-2][0-9]|3[0-1])\s([0-1][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])")
memory_free=$(echo "$(vmstat --unit M)" | awk '{print $4}' | sed -n 3p)
cpu_idle=$(echo "$((100-$cpu_usage))")
cpu_kernel=$(echo "$(vmstat -t)" | awk '{print $14}' | sed -n 3p)
disk_io=$(echo "$(vmstat -d)" | awk '{print $10}' | sed -n 3p)
disk_available=$(echo "$memory_usage" | awk '{print $4}'| sed -n 2p | sed 's/.$//')

# columns timestamp,host_id,memory_free,cpu_idle,cpu_kernel,disk_io,disk_available
# insert data into host usage table
statement="INSERT INTO host_usage (timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
           VALUES ('$timestamp', (SELECT id FROM host_info WHERE hostname='$hostname'), $memory_free, $cpu_idle, $cpu_kernel, $disk_io, $disk_available)"

psql -h "$host" -p "$port" -U "$username" -d "$db_name" -c "$statement"

exit $?