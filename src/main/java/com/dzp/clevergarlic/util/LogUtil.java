package com.dzp.clevergarlic.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 日志记录工具类
 * @Auther ck
 * @Date 2020/7/1 13:38
 * @Desc
 */
@Slf4j
@Component
public class LogUtil {

    private static final String LOG_INFO = "info";
    private static final String LOG_ERROR = "error";


    /**
     * 记录成功日志
     *
     * @param title
     * @param slog
     */
    public static void info(String title, String slog) {
        log.info(title, slog);
    }

    /**
     * 记录失败日志
     */
    public static void error(String title, String slog) {
        log.error(title, slog);
    }
}
