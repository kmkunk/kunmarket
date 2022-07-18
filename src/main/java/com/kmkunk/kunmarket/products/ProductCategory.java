package com.kmkunk.kunmarket.products;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;
    private String name;
    private Long parentProductCategoryId;

    @Builder
    public ProductCategory(String name, Long parentProductCategoryId) {
        this.name = name;
        this.parentProductCategoryId = parentProductCategoryId;
    }
}
