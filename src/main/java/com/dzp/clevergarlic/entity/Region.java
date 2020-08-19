package com.dzp.clevergarlic.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther ck
 * @Date 2020/8/18 17:02
 * @Desc
 */

@Data
@Entity
@Table(name = "fc_region")
public class Region {

    @Id
    private Integer id;

    @Column
    private String areaName;
    private Integer parentId;
    private String shortName;
}
