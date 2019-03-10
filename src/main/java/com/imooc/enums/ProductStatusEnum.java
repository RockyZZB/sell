package com.imooc.enums;


import lombok.Getter;

/**
 * 商品状态
 */

@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
            ;

    private Integer code;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }

    private String message;



}
