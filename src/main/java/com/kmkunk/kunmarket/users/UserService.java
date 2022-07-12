package com.kmkunk.kunmarket.users;

import com.kmkunk.kunmarket.users.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserRequestDto userRequestDto) {
        //비멀번호 암호화 해야함
        userRepository.save(userRequestDto.toEntity());
    }
}
