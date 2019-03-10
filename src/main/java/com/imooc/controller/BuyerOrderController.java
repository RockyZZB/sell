package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.convert.OrderForm2OrderDTOConvert;
import com.imooc.dataObject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creat by ZZZB
 * 2019-02-11 19:20
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;


    //创建订单
    @RequestMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("表单参数不对");
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO=new OrderDTO();
        orderDTO=OrderForm2OrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("购物车不能为空");
            throw  new SellException(ResultEnum.CREATE_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String,String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }


    //订单列表
    @RequestMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid")String openid,
                                         @RequestParam(value = "page",defaultValue = "0")Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")Integer size){

        if (StringUtils.isEmpty(openid)){
            log.error("查询订单列表,openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());

    }


    //订单详情
    @RequestMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid")String openid,
                                     @RequestParam("orderId")String orderId){

        //TODO不安全的做法,需要改进
        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);

    }


    //取消订单
    @RequestMapping("cancel")
    public ResultVO cancel(@RequestParam("openid")String openid,
                           @RequestParam("orderId")String orderId){

        OrderDTO orderDTO = buyerService.cancelOrder(openid,orderId);


        return ResultVOUtil.success(orderDTO);
    }



}
