package com.project.elog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Slf4j
@Profile(value = {"local"})
@Configuration
public class EmbeddedRedisConfig {

    private RedisServer redisServer;
    private final RedisProperties redisProperties;

    public EmbeddedRedisConfig(RedisProperties redisProperties) throws IOException {
        this.redisProperties = redisProperties;
        redisServer();
    }

    private void redisServer() throws IOException {
        redisServer = new RedisServer(redisProperties.getPort());
        redisServer.start();
        log.info("Embedded Redis Start, port: {}", redisProperties.getPort());
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}
