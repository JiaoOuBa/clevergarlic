package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.SaaSDTO.CreateRequest;
import com.dzp.clevergarlic.result.ResultVo;

/**
 * @Auther ck
 * @Date 2020/8/18 11:25
 * @Desc
 */
public interface SaaSService {

    ResultVo createCompany(CreateRequest createRequest);
}
