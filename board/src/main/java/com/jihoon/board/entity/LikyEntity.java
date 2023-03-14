package com.jihoon.board.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jihoon.board.entity.primarykey.LikyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")
public class LikyEntity {
    
    @Id
    @Embedded
    private LikyPk likeyPk;

    private String userProfileurl;
    private String userNickName;


}
