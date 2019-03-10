package com.imooc.service.impl;

import com.imooc.dataObject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Creat by ZZZB
 * 2019-02-03 11:54
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final  String buyerOpenid="110110";

    private final  String order_id="1549875581689623570";


    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerAddress("xxx");
        orderDTO.setBuyerName("aaa");
        orderDTO.setBuyerOpenid(buyerOpenid);
        orderDTO.setBuyerPhone("123456789");
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("fae");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);


        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);


        log.info("创建订单 result={}",result);



    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(order_id);
        log.info("查询订单 result={}",orderDTO);
        Assert.assertEquals(order_id,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenid, request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancle() {
    }

    @Test
    public void finish() {
        OrderDTO orderDTO=orderService.findOne(order_id);
//      System.out.println(orderDTO);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),result.getOrderStatus());


    }

    @Test
    public void pay() {
        OrderDTO orderDTO=orderService.findOne(order_id);
        OrderDTO result = orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());


    }
}