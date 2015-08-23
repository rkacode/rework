#!/bin/bash

. datasource.properties

$JBOSS_HOME/bin/jboss-cli.sh --connect --controller=$host:$port<<EOF
batch
module add --name=$driverName --resources=$jdbcDriverPath --dependencies=javax.api,javax.transaction.api
/subsystem=datasources/jdbc-driver=$driverName:add(driver-name="$driverName",driver-module-name="$moduleName",driver-class-name="$driverClass")
run-batch
exit
EOF