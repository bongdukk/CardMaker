package com.example.user.controller;


import com.example.user.dto.UserDto;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/designmates/signup")
    public ResponseEntity<String> saveForm() {
        return ResponseEntity.ok("save");
    }

    @PostMapping("/designmates/signup")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }

    // 로그인 처리 요청
    @PostMapping("/designmates/login")
    public ResponseEntity<String> login(@RequestParam String userId, @RequestParam String password) {
        if (userService.authenticateUser(userId, password)) {
            return ResponseEntity.ok("redirect:/designmates");
        } else {
            return ResponseEntity.ok("/designmates/login");
        }
    }


/*

    @PostMapping("/auth/joinProc")
    public String joinProc(@Valid UserDto userDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            */
/* 회원가입 실패시 입력 데이터 값을 유지 *//*

            model.addAttribute("userDto", userDto);

            */
/* 유효성 통과 못한 필드와 메시지를 핸들링 *//*

            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            */
/* 회원가입 페이지로 다시 리턴 *//*

            return "/user/save";
        }
        userService.save(userDto);
        return "index";
    }
*/



}