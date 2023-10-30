package org.zerock.t02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.t02.domain.Tbl_group;

public interface GroupRepository extends JpaRepository<Tbl_group,Long> {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
