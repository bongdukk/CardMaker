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
    //생성자 주입
    private final UserService userService;

    //회원가입 페이지 출력 요청
    @GetMapping("/designmates/signup")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/designmates/signup")
    public String save(@ModelAttribute UserDto userDto) {
        System.out.println("UserController.save");
        System.out.println("userDto = " + userDto);
        userService.save(userDto);
        return "index";
    }

    // 로그인 처리 요청
    @PostMapping("/designmates/login")
    public String login(@RequestParam String userId, @RequestParam String password, Model model) {
        // 사용자 인증을 위한 메서드 호출
        if (userService.authenticateUser(userId, password)) {
            return "redirect:/designmates"; // 로그인 성공 시 대시보드 페이지로 리다이렉트합니다.
        } else {
            return "/designmates/login"; // 로그인 페이지로 다시 리다이렉트합니다.
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