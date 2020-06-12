package com.project.elog.entity;

import com.project.elog.common.PostType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (length = 500, nullable = false)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
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

    @Builder
    public Board(String title, String content, PostType postType,
                 long cntVisitor, long cntAccuVisitor, PostParent postParent,
                 User registerUser, List<Tag> tags){
        this.title = title;
        this.content = content;
        this.postType = postType;
        this.cntVisitor = cntVisitor;
        this.cntAccuVisitor = cntAccuVisitor;
        this.postParent = postParent;
        this.registerUser = registerUser;
        this.tags = tags;
    }

}
