package com.pengshuai.uurun.ordermanagement.dao;

import com.pengshuai.uurun.ordermanagement.entity.Orders;

import java.util.List;

/**
 * Created by YangPeng on 2018/12/8.
 */
public interface OrderManagementDao {

    /**
     * 新增订单
     * @param order
     * @return
     */
    int insertOrder(Orders order);

    /**
     * 更新订单
     * @param order
     * @return
     */
    int updateOrderById(Orders order);

    /**
     * 获取用户订单
     * @param userKey
     * @return
     */
    List<Orders> getOrdersByUser(String userKey);

    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    Orders getOrdersByOrderId(String orderId);
}
