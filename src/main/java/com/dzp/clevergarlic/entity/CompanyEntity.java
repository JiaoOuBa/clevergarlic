package com.dzp.clevergarlic.entity;

import com.dzp.clevergarlic.entity.shiro.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther ck
 * @Date 2020/8/18 16:07
 * @Desc
 */
@Data
@Entity
@Table(name = "fc_saas_company")
public class CompanyEntity extends BaseEntity {

    @Id
    private String companyId;

    @Column(unique = true)
    private String name;
    private String enName;
    private Long userId;
    private String userName;
    private String userEnName;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String address;

    private BigDecimal serviceFee;
    private Date serviceEndDate;
    private Integer isEnable;
    private String leaseContact;
    private String leaseContactEmail;
    private String leaseContactPhone;
    private String relationId;
    private String businessCode;
    private Long adminId;
}
