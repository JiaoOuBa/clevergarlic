package com.dzp.clevergarlic.dto.admin.businessDTO.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Auther ck
 * @Date 2020/8/3 13:22
 * @Desc
 */

@Data
public class BusinessForm {

    @ApiModelProperty("设定方式(1.按单元，2.按楼层，3.按整楼)")
    private Integer installType;
    @ApiModelProperty("设定值")
    private String installValue;

    @JsonIgnore
    private String planId;
    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private Long adminId;
    @JsonIgnore
    private String version;

    @ApiModelProperty("招商ID（新增不传）")
    private String businessId;
    @ApiModelProperty("所属集团ID")
    private Integer projectCompanyId;
    @ApiModelProperty("所属组织ID")
    private Integer projectOrganizeId;
    @ApiModelProperty("楼宇ID")
    private Integer buildingId;
    @ApiModelProperty("楼宇名称")
    private String buildingName;
    @ApiModelProperty("楼层")
    private Integer floorCode;
    @ApiModelProperty("单元")
    private Integer unit;
    @ApiModelProperty("楼层属性")
    private String floorProperty;
    @ApiModelProperty("空置期")
    private String emptyDate;
    @ApiModelProperty("起租前装修期")
    private String beforeDecorateDate;
    @ApiModelProperty("免租期")
    private String freeDate;
    @ApiModelProperty("届满后装修期")
    private String afterDecorateDate;
    @ApiModelProperty("合同开始时间")
    private Date contractStartTime;
    @ApiModelProperty("合同结束时间")
    private Date contractEndTime;
    @ApiModelProperty("合同周期（租期）")
    private String contractDate;
    @ApiModelProperty("续约概率")
    private String renewPercent;

    /*@ApiModelProperty("结佣方式")
    private String commissionWay;
    @ApiModelProperty("佣金（月）")
    private BigDecimal monthCommission;
    @ApiModelProperty("佣金（金额）")
    private BigDecimal commission;*/

    @ApiModelProperty("新合同租金(月)")
    private String newContractFee;
    @ApiModelProperty("续约合同租金(月)")
    private String renewContractFee;
}
