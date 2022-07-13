package com.kmkunk.kunmarket.products.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoryResponseDto {

    private Long productCategoryId;
    private String name;
    private Long parentProductCategoryId;
    private List<ProductCategoryResponseDto> childProductCategories;

    public ProductCategoryResponseDto(Long productCategoryId, String name, Long parentProductCategoryId) {
        this.productCategoryId = productCategoryId;
        this.name = name;
        this.parentProductCategoryId = parentProductCategoryId;
    }
}
