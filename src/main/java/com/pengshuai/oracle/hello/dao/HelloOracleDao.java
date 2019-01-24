package com.pengshuai.oracle.hello.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by YangPeng on 2019/1/23.
 */
public interface HelloOracleDao {
    List<Map> listHello();

    int updateHello(@Param("id") int id,@Param("userName") String userName);
}
