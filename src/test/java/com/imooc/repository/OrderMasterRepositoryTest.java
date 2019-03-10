package com.imooc.repository;

import com.imooc.dataObject.OrderMaster;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Creat by ZZZB
 * 2019-02-02 18:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("666", pageRequest);

        System.out.println(result.getTotalElements());
    }

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setBuyerName("zz");
        orderMaster.setOrderAmount(new BigDecimal(66));
        orderMaster.setBuyerOpenid("666");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerPhone("123456789");
        orderMaster.setOrderId("123456");

        repository.save(orderMaster);
    }
}