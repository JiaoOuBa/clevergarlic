package com.dzp.clevergarlic.listener;

import com.dzp.clevergarlic.dao.UnitParamRepository;
import com.dzp.clevergarlic.entity.UnitParam;
import com.dzp.clevergarlic.listener.event.IntegratedParamEvent;
import com.dzp.clevergarlic.util.LogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数拆份入库监听
 * @Auther ck
 * @Date 2020/8/21 13:34
 * @Desc
 */
@Component
public class IntegratedParamListener implements ApplicationListener<IntegratedParamEvent> {

    @Autowired
    UnitParamRepository unitParamRepository;

    @Async
    @Override
    public void onApplicationEvent(IntegratedParamEvent event) {

        try {
            List<UnitParam> list = new ArrayList<>();
            event.getIntegratedList().forEach(res -> {
                UnitParam u = new UnitParam();
                BeanUtils.copyProperties(res, u);
                list.add(u);
            });
            unitParamRepository.saveAll(list);
        } catch (Exception e) {
            LogUtil.error("单元维度参数写入失败======>", "操作人："+event.getAdminId()+"计划id："+event.getPlanId()+",楼宇id："+event.getBuildingId()+"错误信息："+e.getStackTrace()[0].toString());
        }
    }
}
