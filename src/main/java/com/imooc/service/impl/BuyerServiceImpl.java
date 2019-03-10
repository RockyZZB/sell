package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Creat by ZZZB
 * 2019-02-13 17:13
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
       OrderDTO orderDTO=checkOrderOwner(openid,orderId);
       return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            throw  new SellException(33,"订单不存在");
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return  null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("订单主人错误");
            throw  new SellException(99,"订单主人错误");
        }
        return orderDTO;
    }
}
