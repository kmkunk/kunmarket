package com.kmkunk.kunmarket.users;

import com.kmkunk.kunmarket.common.exception.DuplicateException;
import com.kmkunk.kunmarket.users.dto.UserRequestDto;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserRequestDto userRequestDto) {
        //중복확인 및 밸리데이션 해야함
        //비멀번호 암호화 해야함
        if (duplicateCheckEmail(userRequestDto.getEmail())) {
            userRepository.save(userRequestDto.toEntity());
        }
    }

    public boolean duplicateCheckEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateException("이미 등록된 이메일입니다.");
        }
        return true;
    }
}
