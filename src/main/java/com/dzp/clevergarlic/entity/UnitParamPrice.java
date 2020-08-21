package com.dzp.clevergarlic.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Auther ck
 * @Date 2020/8/21 14:56
 * @Desc
 */

@Data
@Entity
@Table(name = "fc_unit_param_price")
public class UnitParamPrice {

    @Id
    private String uppId;

    @Column
    private String upId;
    private BigDecimal leaseUnitPrice;
    private String dateYear;

}
