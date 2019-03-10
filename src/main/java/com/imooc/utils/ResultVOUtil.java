package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Creat by ZZZB
 * 2019-02-02 12:54
 */


public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }


    public static ResultVO success(){
        return  success(null);
    }

    public static ResultVO erro(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}

