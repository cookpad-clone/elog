package com.project.elog.entity;

import com.project.elog.common.PostType;
import com.sun.istack.NotNull;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    @Column
    private String content;

    @Enumerated(EnumType.ORDINAL)
    private PostType postType;

    //방문자 개수
    private long cntVisitor;

    //누적 방문자 개수
    private long cntAccuVisitor;

    //게시글 시리즈 부모 PK
    @ManyToOne
    private PostParent postParent = new PostParent();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @NotNull
    private User registerUser;

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
