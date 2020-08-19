package com.dzp.clevergarlic.dto.admin.SaaSDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther ck
 * @Date 2020/8/18 11:04
 * @Desc
 */
@Data
public class CreateRequest {

    @ApiModelProperty("主键id")
    @JsonIgnore
    private String companyId;

    @ApiModelProperty("公司名称")
    @NotEmpty(message = "公司名称必填")
    private String name;

    @ApiModelProperty("公司英文名称")
    @NotEmpty(message = "公司英文名称必填")
    private String enName;

    @ApiModelProperty("saas租户id")
    @JsonIgnore
    private Long userId;

    @ApiModelProperty("saas租户名称")
    @NotEmpty(message = "saas租户名称必填")
    private String userName;

    @ApiModelProperty("saas租户英文名称")
    @NotEmpty(message = "saas租户英文名称必填")
    private String UserEnName;

    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("省份id")
    @JsonIgnore
    private Integer provinceId;
    @ApiModelProperty("城市id")
    @JsonIgnore
    private Integer cityId;
    @ApiModelProperty("区域id")
    @JsonIgnore
    private Integer areaId;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("服务月费")
    private BigDecimal serviceFee;

    @ApiModelProperty("服务到期日")
    private Date serviceEndDate;

    @ApiModelProperty("租户联系人")
    private String leaseContact;

    @ApiModelProperty("租户联系邮箱")
    private String leaseContactEmail;

    @ApiModelProperty("租户联系电话")
    private String leaseContactPhone;

    @ApiModelProperty("工商信息代码")
    @NotEmpty(message = "工商信息代码必填")
    private String businessCode;

    @ApiModelProperty("管理员id")
    @JsonIgnore
    private Long adminId;

    @ApiModelProperty("关联BI数据id")
    private String relationId;

}
