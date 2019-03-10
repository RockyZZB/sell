package com.imooc.enums;

import lombok.Getter;

/**
 * Creat by ZZZB
 * 2019-02-03 10:47
 */
@Getter
public enum  ResultEnum {

    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EIXT(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIST(12,"商品不存在"),
    ORDERDETAIL_NOT_EXIST(13,"商品详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"取消订单失败"),
    ORDER_DETAIL_FAIL(16,"取消的订单中无商品"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    ORDER_PAY_UPDATE_ERRRO(18,"订单支付完成更新失败"),
    CREATE_EMPTY(19,"购物车为空")
    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;

    }


}
