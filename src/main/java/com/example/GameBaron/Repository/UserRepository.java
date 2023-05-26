package com.example.GameBaron.Repository;

import com.example.GameBaron.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.UserName = ?1")
    Optional<User> findUserByUsername(String userName);
}
