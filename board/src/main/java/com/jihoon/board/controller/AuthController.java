package com.jihoon.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.common.constant.ApiPattern;
import com.jihoon.board.dto.request_auth.SignInDto;
import com.jihoon.board.dto.request_auth.SignUpDto;
import com.jihoon.board.dto.response_auth.ResponseDto;
import com.jihoon.board.dto.response_auth.SignInResponseDto;
import com.jihoon.board.dto.response_auth.SignUpResponseDto;
import com.jihoon.board.service.AuthService;

@RestController
@RequestMapping(ApiPattern.AUTH)
public class AuthController { // 작성자 컨트롤러
    
    @Autowired private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @PostMapping(SIGN_UP) // 회원가입하는건 crud 중에 c에 속함
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto requestBody){ // ResponseEntity : 실패할 경우에는 상태값으로 반환해준다고함
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
        
    }

    @PostMapping(SIGN_IN) // 로그인 시에는 데이터를 숨기기 위해서 post를 씀
    public ResponseDto<SignInResponseDto> signIn(@Valid @RequestBody SignInDto requestBody){
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
