package com.example.user.controller;


import com.example.user.dto.UserDto;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {
    //생성자 주입
    private final UserService userService;

    //회원가입 페이지 출력 요청
    @GetMapping("/user/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/user/save")
    public String save(@ModelAttribute UserDto userDto) {
        System.out.println("UserController.save");
        System.out.println("userDto = " + userDto);
        userService.save(userDto);
        return "index";
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