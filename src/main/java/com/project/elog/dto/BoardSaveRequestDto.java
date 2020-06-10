package com.project.elog.dto;

import com.project.elog.common.PostType;
import com.project.elog.entity.Board;
import com.project.elog.entity.PostParent;
import com.project.elog.entity.Tag;
import com.project.elog.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private PostType postType;
    private long cntVisitor;
    private long cntAccuVisitor;
    private PostParent postParent;
    private User registerUser;
    private List<Tag> tags;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .postType(postType)
                .cntVisitor(cntVisitor)
                .cntAccuVisitor(cntAccuVisitor)
                .postParent(postParent)
                .registerUser(registerUser)
                .tags(tags)
                .build();
    }
}
