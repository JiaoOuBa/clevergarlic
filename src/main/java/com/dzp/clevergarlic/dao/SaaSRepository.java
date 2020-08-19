package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.SaaSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * saas公司数据访问
 * @Auther ck
 * @Date 2020/8/18 14:10
 * @Desc
 */
public interface SaaSRepository extends JpaRepository<SaaSEntity, String> {

    List<SaaSEntity> findAll();
}
