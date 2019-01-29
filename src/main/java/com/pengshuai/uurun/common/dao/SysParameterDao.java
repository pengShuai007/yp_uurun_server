package com.pengshuai.uurun.common.dao;

/**
 * Created by YangPeng on 2018/12/8.
 */
public interface SysParameterDao {

    /**
     * 根据参数名获取参数值
     * @param paraName
     * @return
     */
    String getParameterValueByName(String paraName);
}
