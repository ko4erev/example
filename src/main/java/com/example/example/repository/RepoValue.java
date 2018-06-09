package com.example.example.repository;

import com.example.example.model.TableForExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RepoValue extends JpaRepository<TableForExample, Long> {
    @Query(value = "select value from ad.example\n",nativeQuery = true)
    List<String> returnStrings();
}
