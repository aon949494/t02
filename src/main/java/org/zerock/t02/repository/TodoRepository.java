package org.zerock.t02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.zerock.t02.domain.Tbl_member;
import org.zerock.t02.domain.Tbl_todolist;
import org.zerock.t02.dto.TodoDTO;

import java.util.List;

public interface TodoRepository extends JpaRepository<Tbl_todolist, Long>, QuerydslPredicateExecutor<Tbl_todolist> {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
    @Query(value = "select * from Tbl_todolist",nativeQuery = true)
    TodoDTO viewAll();
    @Query(value = "alter table tbl_todolist auto_increment = 1", nativeQuery = true)
    String alter();
    @Query(value = "set @COUNT=0",nativeQuery = true)
    String set();
    @Query(value = "update tbl_todolist set bno=@count::=@count+1",nativeQuery = true)
    String updat();
    @Query(value = "select * from Tbl_todolist  where memberID=:string",nativeQuery = true)
    List<Tbl_todolist> findByMemberID(@Param("string") String letter);
}
