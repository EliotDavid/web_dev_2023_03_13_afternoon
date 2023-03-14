package com.jihoon.board.common.constant;

public interface ApiPattern { // constant는 뭐하는 애지?
                              // 원래 class였는데 interface로 바꿈  
                              // interface는 무조건 구현을 하고 사용을 할 수 있는건데 이 녀석을 구현을 하려고하면 접근제어자가 public이나 default를 써야됨
                              // 그리고 이 interface를 상속받은 애가 상속받은 interface에 접근을 할 수 있어야되기 때문에 접근제어자가 public이나 default가 되어야함
                              // 다른 접근제어자들은 접근불가능
                              // 또 interface는 인스턴스 변수로 생성을 못함  
    public static final String AUTH = "/auth";
    public static final String FILE = "/file";

    
}
