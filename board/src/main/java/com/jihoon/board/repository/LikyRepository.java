package com.jihoon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jihoon.board.entity.LikyEntity;
import com.jihoon.board.entity.primarykey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPk>{ // likey의 Pk는 LikeyPk이므로 LikyPk로 지정해줌
    
}
