package com.kmkunk.kunmarket.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Getter
@Setter
public class Address {
    @Column(length = 10)
    @NotBlank(message = "도시명을 입력해주세요.")
    private String city;

    @Column(length = 20)
    @NotBlank(message = "거리명을 입력해주세요.")
    private String street;

    @Column(length = 10)
    @NotBlank(message = "우편번호를 입력해주세요.")
    private String zipcode;

    public String fullAddress() {
        return getCity() + " " + getStreet() + " " + getZipcode();
    }
}
