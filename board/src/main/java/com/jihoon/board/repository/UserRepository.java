package com.jihoon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jihoon.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> { // 첫번째 인자 : 어떤 녀석의 레파지토리인지 들어가는 자리, 두번째 인자 : 첫 번째 인자의 PK
    
    public boolean existsByEmail(String email);

    public boolean existsByTelNumber(String telNumber);

    public UserEntity findByEmail(String email);

    


}
