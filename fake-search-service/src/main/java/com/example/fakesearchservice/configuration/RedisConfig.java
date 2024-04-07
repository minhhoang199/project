//package com.example.fakesearchservice.configuration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfig {
//    @Value("${spring.redis.host}")
//    private String redisClusterUrl;
//    @Value("${spring.redis.port}")
//    private int redisClusterPort;
//
//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
//                .build();
//        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(redisClusterUrl, redisClusterPort);
//        return new LettuceConnectionFactory(serverConfig, clientConfig);
//    }
//
//    @Bean
//    @Primary
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        // tạo ra một RedisTemplate
//        // Với Key là Object
//        // Value là Object
//        // RedisTemplate giúp chúng ta thao tác với Redis
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setEnableTransactionSupport(true);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return template;
//    }
//}
