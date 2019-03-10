package com.imooc.dto;

import lombok.Data;

/**
 * Creat by ZZZB
 * 2019-02-03 11:31
 */
@Data
public class CartDTO {

    private  String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
