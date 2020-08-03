package com.dzp.clevergarlic.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther ck
 * @Date 2020/8/3 16:13
 * @Desc
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    /*private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);*/

    @Test
    public void test1() {
        log.info("info....");
        log.debug("debug....");
        log.error("error....");
    }
}
