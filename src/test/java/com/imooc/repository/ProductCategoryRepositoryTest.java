package com.imooc.repository;

import com.imooc.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {


    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productcategory = repository.findOne(1);
        System.out.println(productcategory.toString());
    }

    @Test
    @Transactional
    public void addTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",3);

        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list=Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}