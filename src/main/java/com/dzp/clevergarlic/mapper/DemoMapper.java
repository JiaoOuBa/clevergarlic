package com.dzp.clevergarlic.mapper;

import com.dzp.clevergarlic.dto.admin.demodto.DemoListResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/1 18:04
 * @Desc
 */
@Repository
public interface DemoMapper {


    @Select("select url from tb_contract_property where contract_id = #{id}")
    String getUrlById(@Param("id") String id);

    @Select("select building_collection_id,building_id,staff_id,create_time from tb_rel_building_collection_building order by create_time desc ")
    List<DemoListResponse> getList();

    @Select("select building_collection_id,building_id,staff_id,create_time from tb_rel_building_collection_building where staff_id = 5 limit 1")
    DemoListResponse getOne();

}
