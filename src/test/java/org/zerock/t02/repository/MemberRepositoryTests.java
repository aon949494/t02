package org.zerock.t02.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.t02.domain.Tbl_member;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private Repository repository;
    @Test
    public void testInsert(){
        Tbl_member member = Tbl_member.builder()
                .memberID("user01")
                .memberPW("1111")
                .memberName("홍길동")
                .build();
        Tbl_member result = repository.save(member);
        log.info("memberID : "+result.getMemberID());
    }
}
