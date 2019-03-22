package com.pengshuai.uurun.hello.service.impl;

import com.pengshuai.uurun.hello.dao.HelloDao;
import com.pengshuai.uurun.hello.entity.HelloEntity;
import com.pengshuai.uurun.hello.entity.Orders;
import com.pengshuai.uurun.hello.entity.Person;
import com.pengshuai.uurun.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YangPeng on 2018/11/28.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public List<HelloEntity> queryHello() {
        return helloDao.queryHello();
    }

    @Override
    public HelloEntity queryHelloById(int id) {
        return helloDao.queryHelloById(id);
    }

//    @Transactional(rollbackFor = Exception.class) 默认捕获runtimeException才回滚事物，可通过rollbackFor来设置
    @Transactional
    @Override
    public boolean insertHello(HelloEntity hello) {
        boolean result = false;
        if (hello != null) {
//            hello.setUsername("杨鹏");
            try {
                int insert = helloDao.insertHello(hello);
                if (insert <= 0) {
                    throw new RuntimeException("新增失败");
                }else{
                    result = true;
                }
            } catch (Exception e) {
                throw new RuntimeException("新增失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("新增时传入实体为空!");
        }
        return result;
    }

    @Override
    public boolean updateHello(HelloEntity hello) {
        boolean result = false;
        if(hello != null){
            int update = helloDao.updateHello(hello);
            if(update <= 0){
                throw new RuntimeException("修改失败!");
            }else{
                result = true;
            }
        }else{
            throw new RuntimeException("修改时传入实体为空!");
        }
        return result;
    }

    @Override
    public boolean deleteHello(int id) {
        boolean result = false;
        int delete = helloDao.deleteHello(id);
        if(delete > 0){
            result = true;
        }
        return result;
    }

    /**
     * 一对多测试
     * @return
     */
    @Override
    public List<Person> selectPersons() {
        List<Person> personList = helloDao.selectPersons();
        return personList;
    }

    /**
     * 多对一测试
     * @return
     */
    @Override
    public List<Orders> selectOrders() {
        List<Orders> ordersList = helloDao.selectOrders();
        return ordersList;
    }
}
