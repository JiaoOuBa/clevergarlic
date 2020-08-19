package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 地区rep
 * @Auther ck
 * @Date 2020/8/18 17:14
 * @Desc
 */
public interface RegionRepository extends JpaRepository<Region, Integer> {

    Region findByAreaName(String name);
}
