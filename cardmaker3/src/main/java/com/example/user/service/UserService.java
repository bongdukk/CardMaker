package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.entity.UserEntity;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        //1. dto -> entity 변환
        //2. repository의 save 메서드 호출
        UserEntity userEntity = UserEntity.toUserEntity(userDto);
        userRepository.save(userEntity);
        //repository 의 save 메서드 호출 ( 조건 . entity 객체를 넘겨줘야 함)
    }

    /* 회원가입 시, 유효성 체크 *//*
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
*/

    // 사용자 인증을 위한 메서드
    public boolean authenticateUser(String userId, String password) {
        // 아이디로 사용자 정보 조회
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(userId);

        // 사용자 정보가 존재하고, 비밀번호가 일치하면 로그인 성공
        return optionalUserEntity.map(userEntity -> userEntity.getPassword().equals(password)).orElse(false);
    }
}
