package com.imooc.dataObject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Creat by ZZZB
 * 2019-02-02 16:40
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态,默认0新订单
    private Integer orderStatus=OrderStatusEnum.NEW.getCode();

    //支付状态,默认0未支付
    private Integer payStatus=PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;


    public OrderMaster() {
    }



}
