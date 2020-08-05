package com.dzp.clevergarlic.dto.admin.businessDTO;

import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/13 16:36
 * @Desc
 */
@Data
public class EditBusinessRequest {

    @ApiModelProperty("计划ID")
    @NotEmpty(message = "planId不能为空")
    private String planId;

    @ApiModelProperty("招商参数集合")
    private List<BusinessForm> businessForms;

    @ApiModelProperty("创建人")
    private Long adminId;
    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("关联数据版本")
    private String linkedDataVersion;
    @ApiModelProperty("数据来源（1.设置，2.api）")
    private Integer dataSource;

}
