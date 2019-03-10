package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Creat by ZZZB
 * 2019-02-13 17:11
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);


    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
