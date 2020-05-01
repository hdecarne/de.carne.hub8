#!/bin/bash -x

curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | bash -s -- --skip-rc && . ~/.jabba/jabba.sh
jabba ls-remote
jabba install $BUILD_JDK
./gradlew -v

fluxbox >/dev/null 2>&1 &
sleep 20 # give programs some time to start
