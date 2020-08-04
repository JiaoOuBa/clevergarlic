#!/usr/bin/env bash

NAME='pavilion-base'
VERSION='0.0.1'
APPLICATION_NAME="${NAME}-${VERSION}-SNAPSHOT"

CURRENT_PATH=`pwd`
PID=""

if [ -f ${CURRENT_PATH}/logs/${NAME}.pid ]
then
    PID=`cat ${CURRENT_PATH}/logs/${NAME}.pid`
fi

if [[ "${PID}" = "" ]]
then
    echo "no pid file"
else
    echo "kill "${PID}
    kill -9 ${PID}

    rm -rf `pwd`/logs/${NAME}.pid
fi