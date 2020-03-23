#!/bin/sh

PRG="$0"
ENV="$1"

cd `dirname $PRG` > /dev/null
APP_HOME=`pwd -P`

ENV=${ENV:=local}

./gradlew clean build && \
  cp build/libs/social-binding-*-all.jar build/libs/social-binding.jar && \
  nohup java -jar -Dmicronaut.environments=$ENV build/libs/social-binding.jar &
