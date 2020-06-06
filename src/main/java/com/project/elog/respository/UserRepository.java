package com.project.elog.respository;

import com.project.elog.entity.User;
import com.project.elog.respository.query.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
