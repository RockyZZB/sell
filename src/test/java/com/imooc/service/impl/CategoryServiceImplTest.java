package com.imooc.service.impl;

import com.imooc.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;


    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(1);
        System.out.println(one.getCategoryName());

    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        System.out.println(all.toString());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list=Arrays.asList(2,3,4);
        List<ProductCategory> categoryTypeIn = categoryService.findByCategoryTypeIn(list);
        System.out.println(categoryTypeIn);

    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory("男生最爱",7);
        ProductCategory save = categoryService.save(productCategory);
        Assert.assertNotNull(save);

    }
}