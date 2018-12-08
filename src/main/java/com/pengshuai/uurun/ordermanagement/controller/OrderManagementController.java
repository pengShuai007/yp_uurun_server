package com.pengshuai.uurun.ordermanagement.controller;

import com.pengshuai.uurun.common.view.ResultModel;
import com.pengshuai.uurun.ordermanagement.entity.Orders;
import com.pengshuai.uurun.ordermanagement.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by YangPeng on 2018/12/8.
 */
@RequestMapping("/order")
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @RequestMapping("/release")
    public ResultModel insertOrder(Orders order){
        int result = orderManagementService.insertOrder(order);
        return new ResultModel(result);
    }

    @RequestMapping("/update")
    public ResultModel updateOrder(Orders order){
        int result = orderManagementService.updateOrderById(order);
        return new ResultModel(result);
    }

    @RequestMapping("/getOrdersByOrderId")
    public ResultModel getOrdersByOrderId(String orderId){
        Orders result = orderManagementService.getOrdersByOrderId(orderId);
        return new ResultModel(result);
    }

    @RequestMapping("/getOrdersByUser")
    public ResultModel getOrdersByUser(String userKey){
        List<Orders> result = orderManagementService.getOrdersByUser(userKey);
        return new ResultModel(result);
    }
}
