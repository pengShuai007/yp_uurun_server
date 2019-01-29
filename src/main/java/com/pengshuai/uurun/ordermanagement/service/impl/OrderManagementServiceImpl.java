package com.pengshuai.uurun.ordermanagement.service.impl;

import com.pengshuai.uurun.common.constants.Constants;
import com.pengshuai.uurun.common.service.SysParameterService;
import com.pengshuai.uurun.ordermanagement.dao.OrderManagementDao;
import com.pengshuai.uurun.ordermanagement.entity.Orders;
import com.pengshuai.uurun.ordermanagement.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by YangPeng on 2018/12/8.
 */
@Service
public class OrderManagementServiceImpl implements OrderManagementService {

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private OrderManagementDao orderManagementDao;

    @Override
    public int insertOrder(Orders order) {
        calculateAmount(order);
        int result = orderManagementDao.insertOrder(order);
        return result;
    }

    @Override
    public int updateOrderById(Orders order) {
        calculateAmount(order);
        int result = orderManagementDao.updateOrderById(order);
        return result;
    }

    @Override
    public List<Orders> getOrdersByUser(String userKey) {
        List<Orders> ordersList = orderManagementDao.getOrdersByUser(userKey);
        return ordersList;
    }

    @Override
    public Orders getOrdersByOrderId(String orderId) {
        Orders orders = orderManagementDao.getOrdersByOrderId(orderId);
        return orders;
    }

    /**
     * 根据商品金额、佣金计算订单总金额、平台服务费等
     * @return
     */
    private Orders calculateAmount(Orders orders){
        String amount = orders.getAmount(); //商品金额
        String commission = orders.getCommission(); //订单佣金
        if(amount != null && commission != null){
            String proportion = sysParameterService.getParameterValueByName(Constants.COMMON.SERVICE_COST_PROPORTION.getValue());
//            String proportion = "0.0853"; 测试数据
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            //四舍五入选择RoundingMode.DOWN
            nf.setRoundingMode(RoundingMode.DOWN);
            Double cost = Double.parseDouble(amount) + Double.parseDouble(commission);
            orders.setOrder_cost(Double.toString(cost));
            Double serviceCharge = Double.parseDouble(commission) * Double.parseDouble(proportion);
            orders.setService_charge(nf.format(serviceCharge));
        }
        return orders;
    }

    public static void main(String[] args){
        OrderManagementServiceImpl o = new OrderManagementServiceImpl();
        Orders orders = new Orders();
        orders.setAmount("10");
        orders.setCommission("5");
        o.calculateAmount(orders);
        System.out.print(orders);
    }
}
