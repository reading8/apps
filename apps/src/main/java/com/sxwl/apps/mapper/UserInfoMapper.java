package com.sxwl.apps.mapper;

import com.sxwl.apps.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfo {
    @Select("SELECT * FROM userinfo  openid=#{openid}")
    public User findUserInfo(@Param("openid") String  openid);
}
