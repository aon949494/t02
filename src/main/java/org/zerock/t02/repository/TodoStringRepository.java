package org.zerock.t02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.zerock.t02.controller.T02Controller;
import org.zerock.t02.domain.Tbl_todolist;
import org.zerock.t02.dto.TodoDTO;

import java.util.List;

public interface TodoStringRepository extends JpaRepository<Tbl_todolist, String>, QuerydslPredicateExecutor<Tbl_todolist> {
    @Query(value = "select * from Tbl_todolist  where memberID=:string",nativeQuery = true)
    List<Tbl_todolist> findByMemberID(@Param("string") String letter);
}
