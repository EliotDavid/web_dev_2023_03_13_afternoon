package com.jihoon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihoon.board.common.constant.ResponseMessage;
import com.jihoon.board.dto.request_auth.SignInDto;
import com.jihoon.board.dto.request_auth.SignUpDto;
import com.jihoon.board.dto.response_auth.ResponseDto;
import com.jihoon.board.dto.response_auth.SignInResponseDto;
import com.jihoon.board.dto.response_auth.SignUpResponseDto;
import com.jihoon.board.entity.UserEntity;
import com.jihoon.board.provider.TokenProvider;
import com.jihoon.board.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired private TokenProvider tokenProvider;
    @Autowired private UserRepository userRepository; 

    private PasswordEncoder passswordEncoder = new BCryptPasswordEncoder(); // Encoder : 암호화해주는 녀석

    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto){

        SignUpResponseDto data = null;

        String email = dto.getEmail();
        String telNumber = dto.getTelNumber();
        String password = dto.getPassword();

        try{
            boolean hasEmail = userRepository.existsByEmail(email);
            if(hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFailed(ResponseMessage.EXIST_TELNUMBER);

            String encodedPassword = passswordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(null, data);
    }



    public ResponseDto<SignInResponseDto> signIn(SignInDto dto){
        
        SignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        UserEntity userEntity = null; // 객체 선언 상태가 아니라 객체를 만들긴 만들었는데 필드값이 초기화 되어있는 상태가 아니라 필드값들이 null값 되어있는 상태임

        try {
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passswordEncoder.matches(password, userEntity.getPassword());
            if(!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }


        // 위에는 데이터베이스 에러에 대한 try catch문
        // 토큰 생성하는 과정에서 예외가 발생할 수 있어서 try/ catch를 따로 만듬 
        try {
            String token = tokenProvider.create(email);

            data = new SignInResponseDto(userEntity, token);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.DATABASE_SUCCESS, data);
    }
    
}
