package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dto.admin.demoDTO.DemoListResponse;
import com.dzp.clevergarlic.dto.admin.demoDTO.ListToPageRequest;
import com.dzp.clevergarlic.mapper.admin.DemoMapper;
import com.dzp.clevergarlic.service.admin.DemoService;
import com.dzp.clevergarlic.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther ck
 * @Date 2020/7/1 17:01
 * @Desc
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoMapper demoMapper;


    @Override
    public String getUrlById(String id) {
        return demoMapper.getUrlById(id);
    }

    @Override
    public PageUtil<DemoListResponse> getList(ListToPageRequest request) throws Exception {
        Thread.sleep(5000);
        DemoListResponse demoListResponse = demoMapper.getOne();

        /**
         * 方法一
         */
        PageInfo<DemoListResponse> objectPageInfo = PageHelper.startPage(request.getPage(), request.getPageSize()).doSelectPageInfo(() -> demoMapper.getList());
        return new PageUtil<>(objectPageInfo);

        /**
         * 方法二
         */
        /*PageHelper.startPage(request.getPage(), request.getPageSize());
        List<DemoListResponse> list = demoMapper.getList();
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return pageInfo;*/
    }

}
