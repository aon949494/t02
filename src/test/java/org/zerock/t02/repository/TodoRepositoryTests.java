package org.zerock.t02.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.t02.domain.Tbl_member;
import org.zerock.t02.domain.Tbl_todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
    @Autowired
    private TodoRepository todoRepository;
    @Test
    public void testRegi(){
        Tbl_todolist todolist = Tbl_todolist.builder()
                .title("title...3")
                .content("content...3")
                .memberID("user02")
                .dueDate(LocalDate.parse("2023-10-21"))
                .finished(true)
                .build();
        Tbl_todolist result = todoRepository.save(todolist);
        log.info("BNO: "+result.getBno());
    }
}
