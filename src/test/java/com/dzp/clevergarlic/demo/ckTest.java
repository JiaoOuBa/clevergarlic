package com.dzp.clevergarlic.demo;

import com.dzp.clevergarlic.service.admin.impl.*;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginResponse;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminToken;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.properties.AdminLoginProperties;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.AdminTokenKey;
import com.dzp.clevergarlic.service.admin.DemoService;
import com.dzp.clevergarlic.service.shiro.ShiroService;
import com.dzp.clevergarlic.util.AESUtil;
import com.dzp.clevergarlic.util.CodeUtil;
import com.dzp.clevergarlic.util.CommonUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import com.dzp.clevergarlic.util.LongIdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.*;

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

    @Autowired
    AdminLoginProperties adminLoginProperties;

    @Autowired
    AESUtil aesUtil;

    @Autowired
    ShiroService shiroService;

    @Value("${fc.aes.key}")
    private String AES_KEY;


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
        ResponseEntity lisi = shiroService.login("lisi", "12345");
        HttpStatus statusCode = lisi.getStatusCode();
    }

    /*@Test
    public void test4() {
        DelLeaseFeeRequest delLeaseFeeRequest = new DelLeaseFeeRequest();
        List<String> list = Arrays.asList("12","13","14");
        delLeaseFeeRequest.setIds(list);
        System.out.println(delLeaseFeeRequest.getIds());
    }*/

    @Test
    public void test5() {
        String codeNumber = CodeUtil.getCodeNumber(CodeNumberEnum.CODE_YCJH.getPrefix(), CodeNumberEnum.CODE_YCJH.getLength(),"SC");
        System.out.println(codeNumber);
    }

    @Test
    public void test6() throws Exception{
        Long adminId = 10000006L;
        AdminTokenKey atk = AdminTokenKey.getByToken;
        String token = AdminTokenService.createToken(adminId, "鸿德弟弟");

        AdminLoginResponse response = new AdminLoginResponse();
        response.setId(adminId);
        response.setUserName("鸿德弟弟");

        AdminToken adminToken = new AdminToken();
        adminToken.setAdminLoginResponse(response);
        adminToken.setAdminToken(token);
        adminToken.setInsertTime(CommonUtil.getDateTimeNow());
        redisService.set(atk, adminId + "", adminToken);
        String res = redisService.get(atk, adminId + "");
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject obj = (JSONObject) jsonObject.get("adminLoginResponse");
        AdminLoginResponse login = JSONObject.toJavaObject(obj, AdminLoginResponse.class);

    }

    @Test
    public void test7() {
        /*long uuid1 = LongIdUtil.uuId();
        System.out.println(uuid1);
        System.out.println("--------------------");
        long uuid2 = LongIdUtil.uuId();
        System.out.println(uuid2);

        ArrayList<Integer> objects = new ArrayList<>();
        objects.sort();*/

    }
}
