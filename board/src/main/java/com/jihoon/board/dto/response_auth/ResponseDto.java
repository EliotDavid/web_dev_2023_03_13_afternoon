package com.jihoon.board.dto.response_auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "set") // 이 staticName은 뭘 의미하는거지?
public class ResponseDto<D> {

    private boolean result;
    private String message;
    private D data; // 이건 왜 D지? 이유 : 제네릭으로 나중에 값을 받아와서 정리한다고 하고 일단 제네릭으로 받아올거다라고 해서 매게타입이라고 이해하라고함
    
    public static <D> ResponseDto<D> setSuccess(String message, D data){// 두번째 인자 : 반환해줄 데이터를 넣어줌
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message){
        return ResponseDto.set(false, message, null); 
    }
}
