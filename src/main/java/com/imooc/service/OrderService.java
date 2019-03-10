package com.imooc.service;

import com.imooc.dataObject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Creat by ZZZB
 * 2019-02-02 20:19
 */

@Service
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);



    //查询单个
    OrderDTO findOne(String orderId);


    //查询列表
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);


    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO pay(OrderDTO orderDTO);



}
