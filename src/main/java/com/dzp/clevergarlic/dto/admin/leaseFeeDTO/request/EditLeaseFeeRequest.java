package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/13 11:47
 * @Desc
 */

@Data
public class EditLeaseFeeRequest {

    @ApiModelProperty("计划ID")
    private String planId;

    @ApiModelProperty("租金参数集合")
    private List<LeaseFeeForm> leaseFeeForms;

    @ApiModelProperty("审核人")
    private Long reviewAdminId;
    @ApiModelProperty("审核时间")
    private Timestamp reviewTime;
    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("关联数据版本")
    private String linkedDataVersion;
    @ApiModelProperty("数据来源（1.设置，2.api）")
    private Integer dataSource;

}
