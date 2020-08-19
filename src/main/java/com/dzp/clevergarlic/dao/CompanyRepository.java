package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 公司rep
 * @Auther ck
 * @Date 2020/8/18 16:11
 * @Desc
 */
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
}
