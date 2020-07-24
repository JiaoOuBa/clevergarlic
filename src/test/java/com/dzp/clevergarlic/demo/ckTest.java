package com.dzp.clevergarlic.demo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.DelLeaseFeeRequest;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.service.DemoService;
import com.dzp.clevergarlic.util.CodeUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/2 16:34
 * @Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ckTest {

    @Autowired
    Sid sid;

    @Autowired
    RedisService redisService;


    @Test
    public void test1() {
        String id = IdUtil.objectId();
        String id2 = IdUtil.objectId();
        String id3 = IdUtil.createSnowflake(1, 1).nextIdStr();
        List<String> strings = Arrays.asList(id, id2, id3);
        System.out.println();
    }

    @Test
    public void test2() {
        // Logger log = LoggerFactory.getLogger(IPUtil.class);
        String s = IdUtil.fastUUID();
        String u = IdUtil.randomUUID();
        System.err.println(s + "---" + u);
    }

    @Test
    public void test3() {
        Method method = ReflectUtil.getMethod(DemoService.class, "getUrlById");
    }

    @Test
    public void test4() {
        DelLeaseFeeRequest delLeaseFeeRequest = new DelLeaseFeeRequest();
        List<String> list = Arrays.asList("12","13","14");
        delLeaseFeeRequest.setIds(list);
        System.out.println(delLeaseFeeRequest.getIds());
    }

    @Test
    public void test5() {
        String codeNumber = CodeUtil.getCodeNumber(CodeNumberEnum.CODE_YCJH.getPrefix(), CodeNumberEnum.CODE_YCJH.getLength(),"SC");
        System.out.println(codeNumber);
    }
}
