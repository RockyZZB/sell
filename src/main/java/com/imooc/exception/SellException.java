package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Creat by ZZZB
 * 2019-02-03 10:46
 */
public class SellException extends RuntimeException {

    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }


    public SellException(Integer code,String msg){
        super(msg);
        this.code=code;
    }

}
