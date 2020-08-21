package com.dzp.clevergarlic.entity;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeasePrice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/8/21 14:51
 * @Desc
 */

@Data
@Entity
@Table(name = "fc_unit_param")
public class UnitParam {

    @Id
    private String upId;

    @Column
    @ApiModelProperty("计划id")
    private String planId;
    @ApiModelProperty("所属集团ID")
    private Integer projectCompanyId;
    @ApiModelProperty("所属组织ID")
    private Integer projectOrganizeId;
    @ApiModelProperty("楼宇ID")
    private String buildingId;
    @ApiModelProperty("楼层")
    private Integer floorCode;
    @ApiModelProperty("单元")
    private String unit;
    /*租金相关参数*/
    @ApiModelProperty("租金月份（yyyy-MM）")
    private Date dateMonth;
    @ApiModelProperty("计租方式")
    private String leaseWay;
    /*招商相关参数*/
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
    @ApiModelProperty("新合同租金(月)")
    private String newContractFee;
    @ApiModelProperty("续约合同租金(月)")
    private String renewContractFee;

    @OneToMany(fetch=FetchType.EAGER)
    private List<UnitParamPrice> priceList;
}
