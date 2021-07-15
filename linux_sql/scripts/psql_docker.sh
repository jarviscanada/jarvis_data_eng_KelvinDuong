#!/bin/bash

# user input and variable use often
COMAND=$1
USERNAME=$2
PASSSWORD=$3
INSTANCES=$(docker container ls -a -f name=jrvs-psql | wc -l)

# start docker if is not already running
sudo systemctl status docker
RUNNING=$?
if [ "$RUNNING" != 0 ];
then
  sudo systemctl start docker
fi

# evaluating arguments
case $COMAND in
  "create")
      # check if correct number of inputs
      if [ "$#" -ne 3 ];
      then
        echo "Invalid number of arguments"
        echo "Arguments: [db_username][db_password]"
        exit 1
      fi

      # Check if container is already created
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
      if [ $INSTANCES -ne 2 ];
      then
          echo "jrvs-psql container does not exists"
          exit 1
      fi

      # Start container
      docker container start jrvs-psql
      exit $?
      ;;

  "stop")
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

exit 0