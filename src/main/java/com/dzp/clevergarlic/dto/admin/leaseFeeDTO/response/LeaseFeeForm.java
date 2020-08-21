package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租金参数集合
 * @Auther ck
 * @Date 2020/7/30 14:56
 * @Desc
 */

@Data
public class LeaseFeeForm {

    @ApiModelProperty("设定方式(1.按单元，2.按楼层，3.按整楼)")
    private Integer installType;
    @ApiModelProperty("设定值")
    private String installValue;

    @ApiModelProperty("状态")
    @JsonIgnore
    private Integer status;
    @ApiModelProperty("创建人id")
    @JsonIgnore
    private Long adminId;
    @JsonIgnore
    private String planId;
    @JsonIgnore
    private String version;

    @ApiModelProperty("所属集团ID")
    private Integer projectCompanyId;
    @ApiModelProperty("所属组织ID")
    private Integer projectOrganizeId;
    @ApiModelProperty("租金ID（新增不传，修改传）")
    private String leaseId;
    @ApiModelProperty("楼宇ID")
    private String buildingId;
    @ApiModelProperty("楼宇名称")
    private String buildingName;
    @ApiModelProperty("楼层")
    private Integer floorCode;
    @ApiModelProperty("单元")
    private String unit;
    @ApiModelProperty("楼层属性")
    private String floorProperty;
    @ApiModelProperty("租金月份（yyyy-MM）")
    private Date dateMonth;
    @ApiModelProperty("计租方式")
    private String leaseWay;


    @ApiModelProperty("租金单价集合")
    private List<LeasePrice> priceList;
}
