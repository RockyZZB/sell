package com.imooc.VO;

import lombok.Data;

import java.util.List;

/**
 * Creat by ZZZB
 * 2019-02-02 11:01
 */
@Data
public class ResultVO<T> {

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //返回内容
    private T data;

}
