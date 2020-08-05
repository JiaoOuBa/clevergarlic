package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther ck
 * @Date 2020/7/31 9:44
 * @Desc
 */

@Data
public class LeasePrice {

    @ApiModelProperty("主键id")
    private String lpyId;

    @ApiModelProperty("租金参数id")
    private String leaseId;

    @ApiModelProperty("租金单价")
    private BigDecimal leaseUnitPrice;

    @ApiModelProperty("年份")
    private String dateYear;
}
