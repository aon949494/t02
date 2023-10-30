package org.zerock.t02.service.member;

import org.zerock.t02.domain.Tbl_member;
import org.zerock.t02.dto.MemberDTO;

public interface MemberService {
    String join(MemberDTO dto);
    boolean login(String memberID, String memberPW);
    default Tbl_member dtoToEntity(MemberDTO dto){
        Tbl_member entity = Tbl_member.builder()
                .memberID(dto.getMemberID())
                .memberPW(dto.getMemberPW())
                .memberName(dto.getMemberName())
                .build();
        return entity;
    }
    default MemberDTO entityToDto(Tbl_member entity){
        MemberDTO dto = MemberDTO.builder()
                .memberID(entity.getMemberID())
                .memberPW(entity.getMemberPW())
                .memberName(entity.getMemberName())
                .build();
        return dto;
    }
}
