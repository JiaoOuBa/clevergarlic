package com.dzp.clevergarlic.util.IdUtil;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Sid {
    private static WorkerIdStrategy workerIdStrategy;
    private static IdWorker idWorker;

    private final SnowflakeIdWorker snowflakeIdWorker;

    static {
        configure(DefaultWorkerIdStrategy.instance);
    }

    public Sid() {
        this.snowflakeIdWorker = new SnowflakeIdWorker(1,1);
    }


    public static synchronized void configure(WorkerIdStrategy custom) {
        if (workerIdStrategy != null) workerIdStrategy.release();
        workerIdStrategy = custom;
        idWorker = new IdWorker(workerIdStrategy.availableWorkerId()) {
            @Override
            public long getEpoch() {
                return Utils.midnightMillis();
            }
        };
    }

    /**
     * 一天最大毫秒86400000，最大占用27比特
     * 27+10+11=48位 最大值281474976710655(15字)，YK0XXHZ827(10字)
     * 6位(YYMMDD)+15位，共21位
     *
     * @return 固定21位数字字符串
     */

    public static String next() {
        long id = idWorker.nextId();
        String yyMMdd = new SimpleDateFormat("yyMMdd").format(new Date());
        return yyMMdd + String.format("%014d", id);
    }

    public String nextShort() {
        /*String id = String.valueOf(Id.next());
        String yyMMdd = new SimpleDateFormat("HH").format(new Date());
        if (redisService.exists(ComSidKey.writePrefix(),yyMMdd)){
            while (true){
                List<String> list = redisService.listGet(ComSidKey.writePrefix(), yyMMdd, 0, -1);
                if (!list.contains(id)){
                    redisService.listSet(ComSidKey.writePrefix(), yyMMdd,id);
                    break;
                }
                id = String.valueOf(Id.next());
            }
        }else {
            redisService.listSet(ComSidKey.writePrefix(), yyMMdd,id);
        }*/
        return String.valueOf(snowflakeIdWorker.nextId());
    }

}
