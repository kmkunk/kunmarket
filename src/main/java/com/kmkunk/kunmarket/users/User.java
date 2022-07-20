package com.kmkunk.kunmarket.users;

import com.kmkunk.kunmarket.common.entity.Address;
import com.kmkunk.kunmarket.common.entity.BaseTimeEntity;
import com.kmkunk.kunmarket.common.entity.Gender;
import com.kmkunk.kunmarket.reviews.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender; //남자, 여자

    private String birthdate;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public User(String email, String password, String name, Gender gender, String birthdate, Address address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
    }
}
