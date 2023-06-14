package com.onito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onito.app.module.Movies;
@Repository
public interface HomeRepository extends JpaRepository<Movies, String> {

}
