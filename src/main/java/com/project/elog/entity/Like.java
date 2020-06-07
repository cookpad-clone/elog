package com.project.elog.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Like {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @NotNull
    private User registerUser;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId", referencedColumnName = "id")
    @NotNull
    private Board board;
}
