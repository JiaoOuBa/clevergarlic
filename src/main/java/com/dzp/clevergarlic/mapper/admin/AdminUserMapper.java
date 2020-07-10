package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.common.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Auther ck
 * @Date 2020/7/9 16:05
 * @Desc
 */

@Repository
public interface AdminUserMapper {

    @Select("select user_id,user_name,password,status from tb_test_user where user_name = #{name} and deleted = 0")
    User getUserByName(@Param("name") String name);
}
