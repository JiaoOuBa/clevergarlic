package com.dzp.clevergarlic.util;

import com.dzp.clevergarlic.enums.CommonEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 返回信息语言化工具类
 * @Auther ck
 * @Date 2020/8/7 10:40
 * @Desc
 */
public class LanguageUtil {

    private final static String LANG_EN = "EN.properties";
    private final static String LANG_CN = "CN.properties";


    /**
     * 获取返回msg
     * @param type 中英文版本
     * @param codes 返回信息的key集合
     * @return
     * @throws IOException
     */
    public static List<String> getMsg(String type, List<String> codes){

        if (CollectionUtils.isNotEmpty(codes)) {
            List<String> msgList = new ArrayList<>(12);
            try {
                for (String code : codes) {
                    if (type == null || code == null) {
                        return null;
                    }
                    String propertiesType = CommonEnum.LANGUAGE_CN.getMessage().equals(type) ? LANG_CN : LANG_EN;
                    ClassPathResource pathResource = new ClassPathResource(propertiesType);
                    Properties properties = PropertiesLoaderUtils.loadProperties(pathResource);
                    msgList.add(properties.getProperty(code));
                }
                return msgList;

            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

}
