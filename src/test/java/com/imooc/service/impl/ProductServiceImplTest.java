package com.imooc.service.impl;

import com.imooc.dataObject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123456");
        Assert.assertEquals("123456",one.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> all = productService.findUpAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findAll() {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> page = productService.findAll(request);
        System.out.println(page.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo("123457","皮皮虾",new BigDecimal(6.6),10,"很好吃的吓","www.baidu.com",0,9);

        productService.save(productInfo);
    }

    @Test
    @Transactional
    public void decreaseStock() {
        List<CartDTO> cartDTOList=new ArrayList<>();
        CartDTO cartDTO=new CartDTO();
        cartDTO.setProductId("fae");
        cartDTO.setProductQuantity(33);
        cartDTOList.add(cartDTO);
        productService.decreaseStock(cartDTOList);
    }
}