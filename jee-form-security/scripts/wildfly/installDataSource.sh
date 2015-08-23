#!/bin/bash

. datasource.properties

$JBOSS_HOME/bin/jboss-cli.sh --connect --controller=$host:$port<<EOF
batch
data-source add --jndi-name=$jndiName --name=$datasourceName --connection-url=$url --driver-name=$driverName --user-name=$user --password=$password
run-batch
exit
EOF