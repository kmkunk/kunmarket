package com.kmkunk.kunmarket.users;

import com.kmkunk.kunmarket.common.exception.DuplicateException;
import com.kmkunk.kunmarket.users.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserRequestDto userRequestDto) {
        if (duplicateCheckEmail(userRequestDto.getEmail())) {
            userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
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
