package com.anhvurz90.soap.server.soapserver;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapServerApplication implements CommandLineRunner {

    @Value("${service.port}")
    private String servicePort;
    
    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        Endpoint.publish("http://localhost:" + servicePort
                + "/service/hello-world", new HelloWorldServiceImpl());
        
    }
}
