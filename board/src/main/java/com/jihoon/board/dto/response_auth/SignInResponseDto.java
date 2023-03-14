package com.jihoon.board.dto.response_auth;

import com.jihoon.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    
    private String email;
    private String nickname;
    private String telNumber;
    private String address;
    private String profile;
    private String token; // 비밀번호를 빼고 token을 넣었음
    private int expriedTime;

    public SignInResponseDto(UserEntity userEntity, String token){
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.telNumber = userEntity.getTelNumber();
        this.address = userEntity.getAddress();
        this.profile = userEntity.getProfile();
        this.token = token;
        this.expriedTime = 3600000;
    }

}
