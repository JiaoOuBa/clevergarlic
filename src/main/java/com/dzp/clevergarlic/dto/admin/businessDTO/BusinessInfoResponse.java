package com.dzp.clevergarlic.dto.admin.businessDTO;

import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/21 17:25
 * @Desc
 */
@Data
public class BusinessInfoResponse {

    @ApiModelProperty("计划ID")
    private String planId;

    @ApiModelProperty("招商参数集合")
    private List<BusinessForm> businessForms;

    @ApiModelProperty("创建人")
    private Long adminId;
    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("关联数据版本")
    private String linkedDataVersion;

}
