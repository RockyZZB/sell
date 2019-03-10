package com.imooc.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.dataObject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Creat by ZZZB
 * 2019-02-11 19:55
 */
@Slf4j
public class OrderForm2OrderDTOConvert {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList=new ArrayList<>();
       try {
           orderDetailList = gson.fromJson(orderForm.getItems(),
                   new TypeToken<List<OrderDetail>>() {
                   }.getType());
       }catch (Exception e){
           log.error("对象转换错误");
           throw new SellException(ResultEnum.PARAM_ERROR);
       }

        orderDTO.setOrderDetailList(orderDetailList);

       return  orderDTO;
    }


}
