#!/bin/bash

# user input and variables that are used often
COMAND=$1
USERNAME=$2
PASSSWORD=$3
INSTANCES=$(docker container ls -a -f name=jrvs-psql | wc -l)

# start docker if it is not already running
sudo systemctl status docker > /dev/null || sudo systemctl start docker


# evaluating given arguments
case $COMAND in
  "create")
      # check if it is the correct number of inputs
      if [ "$#" -ne 3 ];
      then
        echo "Invalid number of arguments"
        echo "Arguments: [db_username][db_password]"
        exit 1
      fi

      # Check if the container is already created
      if [ $INSTANCES -eq 2 ];
      then
        echo "jrvs-psql container already exists"
        exit 1
      fi

      # create volume with given username and password
      docker volume create pgdata
      docker run --name jrvs-psql -e POSTGRES_PASSWORD="$PASSWORD" -e POSTGRES_USER="$USERNAMEE" -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres
      exit $?
     ;;

  "start")
      # check if the container exists
      if [ $INSTANCES -ne 2 ];
      then
          echo "jrvs-psql container does not exists"
          exit 1
      fi

      # start container
      docker container start jrvs-psql
      exit $?
      ;;

  "stop")
      # check if the container exists
      if [ $INSTANCES -ne 2 ];
      then
          echo "jrvs-psql container does not exists"
          exit 1
      fi

      # stop container
      docker container stop jrvs-psql
      exit $?
      ;;

  *)
      # invalid arguments. print out usage
      echo "Invalid arguments (start|stop|crete)"
      echo "Usage: ./psql_docker.sh start|stop|create [db_username][db_password] "
      exit 1
      ;;
esac