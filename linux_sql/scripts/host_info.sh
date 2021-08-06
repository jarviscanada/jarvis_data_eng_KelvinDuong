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

lscpu_out=`lscpu`

# linux resource usage data
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out"  | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out"  | egrep "^Model:" | awk '{print $2}' | xargs)
cpu_mhz=$(echo "$lscpu_out"  | egrep "(CPU)\s(MHz)" | awk '{print $3}' | xargs)
L2_cache=$(echo "$lscpu_out"  | egrep "(L2)\s(cache)" | awk '{print $3}' | xargs | sed 's/.$//')
total_mem=$(cat /proc/meminfo | egrep "MemTotal:" | awk '{print $2}' | xargs)
timestamp=$(echo  $(vmstat -t) | egrep -o "[0-9]{4}-(1[1-2]|0[0-9])-([0-2][0-9]|3[0-1])\s([0-1][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])")

# insert hardware data into host_info table
statement="INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, timestamp)
           VALUES ('$hostname', $cpu_number, '$cpu_architecture', $cpu_model, $cpu_mhz, $L2_cache, $total_mem, '$timestamp')"

psql -h "$host" -p "$port" -U "$username" -d "$db_name" -c "$statement"

exit $?