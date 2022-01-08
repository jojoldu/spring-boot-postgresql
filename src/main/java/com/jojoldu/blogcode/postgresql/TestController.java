package com.jojoldu.blogcode.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/test-timeout")
    public String testTimeout() {
        try {
            jdbcTemplate.execute("SELECT pg_sleep(3);");
            log.info("test-timeout!");
        } catch (Exception e) {
            log.error("pg error", e);
        }

        return "test-timeout!";
    }
}
