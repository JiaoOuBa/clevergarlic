package com.dzp.clevergarlic.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc Redis基础配置
 * @Auther JiaoOuBa
 * @Date 2020/7/14 15:04
 */
@Configuration
public class RedisCacheConfig {

    private final int DEFAULT_SECONDS = 10000; // 默认存活时间 s

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = this.getObjectJackson2JsonRedisSerializer();

        redisTemplate.setEnableTransactionSupport(true);

        // value序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // key序列化方式
        redisTemplate.setKeySerializer(redisSerializer);
        // value hashmap序列化
        redisTemplate.setHashValueSerializer(redisSerializer);
        // key hashmap序列化
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager redisCacheManagerConfig(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(this.defaultConfig(DEFAULT_SECONDS))
                .withInitialCacheConfigurations(this.initCacheConfigMap())
                .transactionAware()
                .build();

        return redisCacheManager;
    }


    private RedisCacheConfiguration defaultConfig(int seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = this.getObjectJackson2JsonRedisSerializer();

        RedisSerializationContext.SerializationPair<String> keySerializationPair =
                RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
        RedisSerializationContext.SerializationPair<Object> valueSerializationPair =
                RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);

        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeKeysWith(keySerializationPair)
                        .serializeValuesWith(valueSerializationPair)
                        .entryTtl(Duration.ofSeconds(seconds));
        return redisCacheConfiguration;
    }


    private Jackson2JsonRedisSerializer<Object> getObjectJackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }

    private Map<String, RedisCacheConfiguration> initCacheConfigMap() {
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("user",this.defaultConfig(40000));
        return configMap;
    }
}
