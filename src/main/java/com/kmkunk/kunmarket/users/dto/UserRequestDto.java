package com.kmkunk.kunmarket.users.dto;

import com.kmkunk.kunmarket.common.entity.Address;
import com.kmkunk.kunmarket.common.entity.Gender;
import com.kmkunk.kunmarket.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 양식을 지켜주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
//    @Pattern(regexp = "???", message = ) 처리해야함
    private String password;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 10, message = "이름은 최대 10자까지 입력할 수 있습니다.")
    private String name;

//    @ValidEnum(enumClass = Gender.class) 어떻게 해야할까..
    private Gender gender;

    @NotBlank(message = "생년월일을 입력해주세요.")
//    @Pattern(???) 처리해야함
    private String birthdate;

    @Valid
    private Address address;

    public User toEntity() {
        return User.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .name(this.getName())
                .gender(this.getGender())
                .birthdate(this.getBirthdate())
                .address(this.getAddress())
                .build();
    }
}
