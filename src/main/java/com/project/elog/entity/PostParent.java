package com.project.elog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 포스트(Board) 엔티티들의 상위 개념인 시리즈 entity
// 예시) { board1, board2, board3 }-> postParent1
@Entity
public class PostParent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
