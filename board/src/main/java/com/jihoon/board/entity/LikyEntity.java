package com.jihoon.board.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.jihoon.board.entity.primarykey.LikeyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")
public class LikyEntity {
    
    @Embedded
    private LikeyPk likeyPk;

    private String userProfileurl;
    private String userNickName;


}
