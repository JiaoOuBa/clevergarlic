package com.dzp.clevergarlic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.dzp.clevergarlic.mapper")
@ComponentScan(basePackages = {"com"})
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ClevergarlicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClevergarlicApplication.class, args);
    }

}
