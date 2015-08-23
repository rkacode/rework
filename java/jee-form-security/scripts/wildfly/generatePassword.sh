#!/bin/sh

password=$1
digest=$2

: ${digest:="SHA-256"}

classpath="$JBOSS_HOME/modules/system/layers/base/org/picketbox/main/picketbox-4.0.21.Final.jar"

"$JAVA_HOME/bin/java" -cp "$classpath" org.jboss.security.Base64Encoder "$password" "$digest"


