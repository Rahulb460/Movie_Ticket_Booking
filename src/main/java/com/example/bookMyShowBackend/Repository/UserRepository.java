package com.example.bookMyShowBackend.Repository;

import com.example.bookMyShowBackend.Models.MovieEntity;
import com.example.bookMyShowBackend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

     List<UserEntity> findUserByName(String name);

    UserEntity findByMobile(String mobile);
}
