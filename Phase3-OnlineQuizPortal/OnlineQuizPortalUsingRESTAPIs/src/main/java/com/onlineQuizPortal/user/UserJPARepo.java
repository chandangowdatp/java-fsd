package com.onlineQuizPortal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJPARepo extends JpaRepository<UserObject, Integer> {
    List<UserObject> findByUsername(String Username);
}