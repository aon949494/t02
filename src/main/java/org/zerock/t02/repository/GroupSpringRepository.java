package org.zerock.t02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.zerock.t02.domain.Tbl_group;
import org.zerock.t02.domain.Tbl_todolist;

import java.util.List;

public interface GroupSpringRepository extends JpaRepository<Tbl_group,String>, QuerydslPredicateExecutor<Tbl_group> {
    @Query(value = "select * from Tbl_group  where memberID=:string",nativeQuery = true)
    List<Tbl_group> findByMemberID(@Param("string") String letter);
}
