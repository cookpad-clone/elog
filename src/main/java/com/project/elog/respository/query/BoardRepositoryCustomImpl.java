package com.project.elog.respository.query;

import com.project.elog.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom{

    public BoardRepositoryCustomImpl() {
        super(Board.class);
    }
}
