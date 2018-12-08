package com.pengshuai.uurun.common.service;

import com.pengshuai.uurun.common.dao.SysParameterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YangPeng on 2018/12/8.
 */
@Service
public class SysParameterService {

    @Autowired
    private SysParameterDao sysParameterDao;

    public String getParameterValueByName(String paraName){
        String result = sysParameterDao.getParameterValueByName(paraName);
        return result;
    }
}
