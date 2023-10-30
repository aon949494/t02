package org.zerock.t02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.t02.domain.Tbl_member;


import java.util.List;


public interface Repository extends JpaRepository<Tbl_member, String> {
    @Query(value = "select * from Tbl_member  where memberID=:string",nativeQuery = true)
    List<Tbl_member> findByMemberID(@Param("string") String letter);
    @Query(value = "select now()", nativeQuery = true)
    String getTime();




}
