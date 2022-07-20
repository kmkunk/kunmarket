package com.kmkunk.kunmarket.products;

import com.kmkunk.kunmarket.reviews.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();
}
