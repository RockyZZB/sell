package com.imooc.repository;

import com.imooc.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo("123456","皮蛋粥",new BigDecimal(3.5),100,"很好喝的粥","www.baidu.com",0,1);
        repository.save(productInfo);

    }

    @Test
    public void  findbyProductStatus(){
        List<ProductInfo> list=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());
    }

}