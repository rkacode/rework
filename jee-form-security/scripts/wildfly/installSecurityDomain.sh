#!/bin/bash

. datasource.properties

$JBOSS_HOME/bin/jboss-cli.sh --connect --controller=$host:$port<<EOF
batch
/subsystem=security/security-domain=jaas-form-jdbc-domain/:add(cache-type=default)
/subsystem=security/security-domain=jaas-form-jdbc-domain/authentication=classic:add(login-modules=[{"code"=>"Database", "flag"=>"required", "module-options"=>[("dsJndiName"=>"$jndiName"),("principalsQuery"=>"SELECT password FROM users WHERE username = ?"), ("rolesQuery"=>"SELECT role, 'Roles' FROM roles WHERE username = ?"), ("hashAlgorithm"=>"SHA-256"), ("hashEncoding"=>"base64")]}])
run-batch
exit
EOF




