package org.zerock.t02.service.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.t02.domain.Tbl_member;
import org.zerock.t02.dto.MemberDTO;
import org.zerock.t02.repository.Repository;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final Repository repository;
    @Override
    public String join(MemberDTO dto){
        log.info("DTO------------");
        log.info(dto);
        Tbl_member entity = dtoToEntity(dto);
        log.info(entity);
        repository.save(entity);
        return entity.getMemberID();
    }
    @Override
    public boolean login(String memberID, String memberPW){
        log.info("impl: "+memberID);
        log.info("impl: "+memberPW);
        Optional<Tbl_member> result = repository.findById(memberID);
        //Tbl_member member = result.orElseThrow();
        if(!result.isEmpty()&&memberPW.equals(result.orElseThrow().getMemberPW())){
            log.info("로그인성공");
            return true;
        }
        else{
            log.info("로그인실패");
            return false;
        }
    }
}
