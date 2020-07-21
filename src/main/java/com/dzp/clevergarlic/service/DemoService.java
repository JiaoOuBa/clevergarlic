package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.admin.demoDTO.DemoListResponse;
import com.dzp.clevergarlic.dto.admin.demoDTO.ListToPageRequest;
import com.dzp.clevergarlic.util.PageUtil;

/**
 * @Auther ck
 * @Date 2020/7/1 17:01
 * @Desc
 */
public interface DemoService {

    String getUrlById(String id);

    PageUtil<DemoListResponse> getList(ListToPageRequest request) throws Exception;

}
