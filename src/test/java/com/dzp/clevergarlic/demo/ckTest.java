package com.dzp.clevergarlic.demo;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.BuildingListResponse;
import com.dzp.clevergarlic.dto.common.CommonResponse;
import com.dzp.clevergarlic.redis.admin.LoginCodeKey;
import com.dzp.clevergarlic.service.admin.BudgetPlanService;
import com.dzp.clevergarlic.service.admin.impl.*;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginResponse;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminToken;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.properties.AdminLoginProperties;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.AdminTokenKey;
import com.dzp.clevergarlic.service.shiro.ShiroService;
import com.dzp.clevergarlic.util.*;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    BudgetPlanService budgetPlanService;

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
    public void test5() throws Exception {

        /*String codeNumber = CodeUtil.getCodeNumber(CodeNumberEnum.CODE_YCJH.getPrefix(), CodeNumberEnum.CODE_YCJH.getLength(),"SC");
        System.out.println(codeNumber);*/

//        AESUtil aesUtil = new AESUtil();
//        String psd = "GzTCQjhTZmSimz9FYizwMQ==";
//        String pubKey = "hoYdxx*6A7HWrs4Mb}r9wPTm";
//        String encrypt = aesUtil.Decrypt(psd, pubKey);
//        System.out.println(encrypt);


        List<BuildingListResponse> buildingList = budgetPlanService.getBuildingList();
        buildingList.add(BuildingListResponse.builder().buildingId("1").buildingName("测试楼宇1").typeId(1).buildingType("办公").build());
        HashMap<String, BuildingListResponse> collect = buildingList.stream().collect(HashMap::new, (n, v) -> n.put(v.getBuildingId(), v), HashMap::putAll);
        BuildingListResponse buildingListResponse = collect.get("1");
        System.out.println(1111);

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

    private static final int spLength = 6;

    /**
     * 输入一段字符串，对其进行处理，将其按照6位进行分割，对于切割后不足6位的字符串，在后面补充0，
     * 然后将切分后的字符串按照字典顺序输出。
     */
    /*@Test
    public void test7(String str) {

        int size = str.length()/spLength;
        if (str.length() > 0 && str.length() % spLength != 0) {
            size += 1;
        }
        List<String> list = new ArrayList<>(12);
        for (int index = 0; index < size; index++) {
            String childStr = substring(str, index * spLength, (index + 1) * spLength);
            list.add(childStr);
        }

        String[] strings = list.toArray(new String[0]);
        SortedMap<String, String> treeMap = new TreeMap<String, String>();
        for (String string : strings) {
            treeMap.put(string,string);
        }
        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
    }

    public static String substring(String str, int f, int t) {
        if (f > str.length()) {
            return null;
        }
        if (t > str.length()) {
            String lastStr =  str.substring(f, str.length());
            int zeroSize = spLength - lastStr.length();// 加0位数
            for (int zeroNum = 0; zeroNum < zeroSize; zeroNum++) {
                lastStr = lastStr.concat("0");
            }
            return lastStr;
        } else {
            return str.substring(f, t);
        }
    }

    *//**
     * 有一个数组a[N]顺序存放0~N-1，要求每隔三个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
     * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。

     *//*
    @Test
    public void test8(int[] intArray) {

        final int subSize = 3;
        List<Integer> list = new ArrayList<>();
        Object[] objects = splitAry(intArray, subSize);// 按三位分割后的数组集合
        for (int i = 0;i<objects.length;i++) {
            int[] item = (int[]) objects[i];
            if (objects.length > subSize) {
                if (item.length == subSize) {
                    int[] ints = ArrayUtils.removeElement(item, 3);
                    list.add(ints[0]);
                    list.add(ints[1]);
                } else if (item.length == 2) {
                    list.add(item[0]);
                    list.add(item[1]);
                } else if (item.length == 1) {
                    list.add(item[0]);
                }
                objects[i] = list.toArray();
            } else {
                int last = (int) objects[objects.length -1];
                for (int j = 0; j < intArray.length; j++) {
                    if (intArray[j] == last) {
                        System.out.println("最后一个被删的输的原始下标位置为："+j);
                    }
                }
            }
        }
    }

    private static Object[] splitAry(int[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize: ary.length / subSize + 1;
        List<List<Integer>> subAryList = new ArrayList<List<Integer>>();

        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<Integer> list = new ArrayList<Integer>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }
        Object[] subAry = new Object[subAryList.size()];

        for(int i = 0; i < subAryList.size(); i++){
            List<Integer> subList = subAryList.get(i);
            int[] subAryItem = new int[subList.size()];
            for(int j = 0; j < subList.size(); j++){
                subAryItem[j] = subList.get(j).intValue();
            }
            subAry[i] = subAryItem;
        }

        return subAry;
    }*/

}
