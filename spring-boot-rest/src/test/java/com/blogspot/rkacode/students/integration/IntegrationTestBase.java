package com.blogspot.rkacode.students.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.web.client.RestTemplate;

public abstract class IntegrationTestBase {

    @Autowired
    protected EmbeddedWebApplicationContext server;

    @Value("${local.server.port}")
    protected int port;

    protected String getHostAddress() {
	return "http://localhost";
    }

}
