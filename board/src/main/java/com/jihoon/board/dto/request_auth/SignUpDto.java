package com.jihoon.board.dto.request_auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @AllArgsConstructor : SignUpDto는 이게 필요없다고함 왜지?
public class SignUpDto {
    // 아래에 제약조건을 적어줌(어노테이션으로 걸어줌)

    @NotBlank
    @Email
    @Length(max=45) // 데이터베이스의 User테이블에 email 칼럼의 데이터타입 길이가 45
    private String email;
    
    @NotBlank
    @Length(min=8, max=20)
    private String password;

    @NotBlank
    @Length(max=20) // 데이터베이스의 칼럼에서 데이터 길이는 255이나 그건 임의였고 여기서 따로 임의로 지정할 수 있음 그래서 255까지 필요없고 최소 3자에서 20자정도만 허용하겠다는 내 임의로 이렇게 데이터베이스와 다르게 조정할 수 있음(데이터베이스에서 데이터길이를 크게 잡았다하더라도 백엔드에서 )
    private String nickname;

    @NotBlank
    @Length(min=11, max=13)
    private String telNumber;
    @NotBlank
    private String address;
    private String profile;
}
