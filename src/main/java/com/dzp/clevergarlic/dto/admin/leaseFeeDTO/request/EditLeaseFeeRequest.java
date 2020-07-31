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

    @ApiModelProperty("操作类型（1.提交，2.保存为草稿）")
    private Integer operation;
    @ApiModelProperty("计划ID")
    private String planId;
    @ApiModelProperty("租金ID（新增不传，修改传）")
    private String leaseFeeId;

    @ApiModelProperty("租金参数集合")
    private List<LeaseFeeForm> leaseFeeForms;

    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("创建人id")
    private Long adminId;
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
