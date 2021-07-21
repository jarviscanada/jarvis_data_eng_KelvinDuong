# Introduction
Developed a cluster monitoring system that records hardware specifications and resource usage of each node/server in the system. The script is used by the Jarvis Linux Cluster Administration (LCA) team to monitor and manage their Linux cluster which is currently running on CentOS 7. The data is collected from the host machine every minute using crontab and is stored on a Relational Database Management System using PostgresSQL. Data collected include CPU mode, memory free, disk io, CPU number, etc. A few SQL queries were written to answer basic business questions. The queries can find the average memory used for each host over a specified time interval and detect server failures. Bash scripts are used to create, stop or start the PSQL Docker instance and to insert into the database. Used git as a version control system and followed the GitFlow workflow ideologies to manage branches and features. 

# Quick Start
- Start a psql instance using `psql_docker.sh`
````bash
    ./scripts/psql_docker.sh create [db_username] [db_password]
````
- Create hardware usage and hardware specifications tables using `ddl.sql`
````bash 
    ./scripts/host_info.sh localhost 5432 host_agent [db_username] [db_password] 
````
- Insert hardware specs data into the DB using host_info.sh
````bash 
    ./scripts/host_info.sh localhost 5432 host_agent [db_username] [db_password] 
```` 
- Insert hardware usage data into the DB using host_usage.sh
- Crontab setup

# Implemenation
Discuss how you implement the project.
## Architecture
Draw a cluster diagram with three Linux hosts, a DB, and agents (use draw.io website). Image must be saved to the `assets` directory.

## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh
- host_info.sh
- host_usage.sh
- crontab
- queries.sql (describe what business problem you are trying to resolve)

## Database Modeling
Describe the schema of each table using markdown table syntax (do not put any sql code)
- `host_info`
- `host_usage`

# Test
How did you test your bash scripts and SQL queries? What was the result?

# Deployment
How did you deploy your app? (e.g. Github for SCM and docker for PSQL)

# Improvements
Write at least three things you want to improve 
e.g. 
- handle hardware update 
- blah
- blah
