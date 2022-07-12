package com.kmkunk.kunmarket.users;

import com.kmkunk.kunmarket.common.entity.Address;
import com.kmkunk.kunmarket.common.entity.BaseTimeEntity;
import com.kmkunk.kunmarket.common.entity.Gender;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender; //남자, 여자

    private String birthdate;

    @Embedded
    private Address address;
}
