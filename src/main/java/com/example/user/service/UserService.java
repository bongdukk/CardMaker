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

    /* 회원가입 시, 유효성 체크 */
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }


}
