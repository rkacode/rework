CREATE DATABASE jaas_form_jdbc_wildfly;

USE jaas_form_jdbc_wildfly;

CREATE TABLE users(username VARCHAR(255) PRIMARY KEY, password VARCHAR(255));
CREATE TABLE roles(username VARCHAR(255), role VARCHAR(255), FOREIGN KEY (username) REFERENCES users(username));
