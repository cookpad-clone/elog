package com.project.elog.respository.query;

import com.project.elog.entity.QUser;
import com.project.elog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryCustomImpl() {
        super(User.class);
    }

    @Override
    public List<User> getHa() {
        return from(QUser.user)
                // where(Quser.user.email.eq("")
                .fetch();
    }
}
