package com.scarlatti

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.ExitCodeGenerator
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
@Slf4j
class App implements CommandLineRunner {

    @Autowired ConfigurableApplicationContext ctx

    static void main(String[] args) {
        SpringApplication.run(App.class, args)
    }

    @Override
    void run(String... args) throws Exception {
        SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            int getExitCode() {
                log.info 'retrieving exit code.'
                return -45
            }
        })
    }
}