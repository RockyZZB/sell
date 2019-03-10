package com.imooc.enums;

import lombok.Getter;

/**
 * Creat by ZZZB
 * 2019-02-02 16:45
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),

    FINISH(1,"完成"),

    CANCLE(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message){

        this.code=code;
        this.message=message;

    }

}
