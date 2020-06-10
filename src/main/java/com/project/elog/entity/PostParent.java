package com.project.elog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PostParent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToMany
    private List<Board> boards = new ArrayList<>();
}
