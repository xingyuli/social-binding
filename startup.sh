#!/bin/sh

PRG="$0"
ENV="$1"

cd `dirname $PRG` > /dev/null
APP_HOME=`pwd -P`

ENV=${ENV:=local}

./gradlew clean build && \
  nohup java -jar -Dmicronaut.environments=$ENV build/libs/social-binding-*-all.jar &
