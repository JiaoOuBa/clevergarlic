#!/usr/bin/env bash

NAME='clevergarlic'
VERSION='0.0.1'
APPLICATION_NAME="${NAME}-${VERSION}-SNAPSHOT"
CURRENT_PATH=`pwd`
PID=""

if [[ ! -f ${CURRENT_PATH}/target/${APPLICATION_NAME}.jar ]]
then
    echo "${APPLICATION_NAME}.jar 不存在"
    exit 1
fi

active='dev'
port=''

while getopts ":a:p:" opt
do
    case ${opt} in
        a)
        echo "运行环境：$OPTARG"
        active=$OPTARG
        ;;
        p)
        echo "端口：$OPTARG"
        port=$OPTARG
        ;;
        ?)
        echo "未知参数"
        exit 1;;
    esac
done


if [[ -f ${CURRENT_PATH}/logs/${NAME}.pid ]]
then
    PID=`cat ${CURRENT_PATH}/logs/${NAME}.pid`
fi

if [[ "${PID}" = "" ]]
then
    echo "start "${APPLICATION_NAME}
else
    echo "kill -9 "${APPLICATION_NAME}
    kill -9 ${PID}
    echo "restart "${APPLICATION_NAME}
fi

if [[ -d `pwd`/logs ]]
then
    # rm -rf `pwd`/logs
    echo ""
else
    mkdir logs
fi

echo "运行参数:"
#if [[ x$1 != x ]]
#then
#java -jar ${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=prod --server.port=$1 > `pwd`/logs/${NAME}${VERSION}.log &
#else
#java -jar ${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=prod > `pwd`/logs/${NAME}${VERSION}.log &
#fi
if [[ x"${port}" = x ]]
then
  echo "java -jar target/${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=${active}"
  java -jar target/${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=${active} > `pwd`/logs/${NAME}-${VERSION}.log &
else
  echo "java -jar target/${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=${active} --server.port=${port}"
  java -jar target/${APPLICATION_NAME}.jar -Duser.timezone=GMT+08 --spring.profiles.active=${active} --server.port=${port} > `pwd`/logs/${NAME}-${VERSION}.log &
fi

echo $! > `pwd`/logs/${NAME}.pid