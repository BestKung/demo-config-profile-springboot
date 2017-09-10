package com.example.demoprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoProfileApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoProfileApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DemoProfileApplication.class, args);
		Environment env = app.getEnvironment();
		try {
			log.info("\n----------------------------------------------------------\n\t" +
                            "Application '{}' is running! Access URLs:\n\t" +
                            "Local: \t\thttp://127.0.0.1:{}\n\t" +
                            "External: \thttp://{}:{}\n\t" +
							"Profile : {} \n----------------------------------------------------------",
                    env.getProperty("spring.application.name"),
                    env.getProperty("server.port"),
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"),
					env.getActiveProfiles());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
