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
 * SaaS-BI
 * @Auther ck
 * @Date 2020/8/18 10:57
 * @Desc
 */
@Data
@Entity
@Table(name = "bigdata_project_company")
public class SaaSEntity extends BaseEntity {

    @Id
    private String id;

    @Column(unique = true)
    private Integer operatorId;
    private Integer userId;
    private String name;
    private String shortName;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String regionName;
    private BigDecimal manageableArea;
    private BigDecimal actualManagementArea;
    private BigDecimal serviceMonthFee;
    private Date expireDate;
    private String introduction;
    private String buildingNumber;
    private Timestamp lastLoginTime;
    private String dataSource;

}
