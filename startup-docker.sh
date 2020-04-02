#!/bin/sh

java -Dcom.sun.management.jmxremote -Xmx128m -XX:+IdleTuningGcOnIdle -Xtune:virtualized $JAVA_OPTS \
  -jar /opt/app/app.jar
