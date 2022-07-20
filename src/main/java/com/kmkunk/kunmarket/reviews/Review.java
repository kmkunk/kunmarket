package com.kmkunk.kunmarket.reviews;

import com.kmkunk.kunmarket.common.entity.BaseTimeEntity;
import com.kmkunk.kunmarket.products.Product;
import com.kmkunk.kunmarket.users.User;

import javax.persistence.*;

@Entity
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String title;
    private String content;
    private double rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    //연관관계 편의 메서드 추가해야됨
}
