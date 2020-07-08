package com.dzp.clevergarlic.aspect;

import com.alibaba.druid.support.logging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志代理
 * @Auther ck
 * @Date 2020/7/1 13:40
 * @Desc
 */
public class LoggerThreadLocal {

    //内部静态类,继承至ThreadLocal
    private static class ThreadLocalList extends ThreadLocal {
        //在调用get()方法的时候返回一个ArrayList对象
        @Override
        public List<Log> initialValue() {
            return new ArrayList<>();
        }

        //将保存在ThreadLocal中的List返回
        public List<Log> getList() {
            return (List<Log>) super.get();
        }
    }

    private ThreadLocalList list = new ThreadLocalList();

    /**
     * 清空记录的日志
     */
    public void clear() {
        list.getList().clear();
    }

    /**
     * 将需要记录的日志内容保存下来
     * @param log log
     */
    public void put(Log log) {
        list.getList().add(log);
    }

    /**
     * 返回需要记录的日志
     * @return logs
     */
    public List<Log> get() {
        return list.getList();
    }
}
