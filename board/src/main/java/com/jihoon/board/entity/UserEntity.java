package com.jihoon.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.jihoon.board.dto.request_auth.SignUpDto;

import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    
    @Id
    private String email;
    
    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String profile;

    public UserEntity(SignUpDto dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.telNumber = dto.getTelNumber();
        this.address = dto.getAddress();
        this.profile = dto.getProfile();
    }


    

}
