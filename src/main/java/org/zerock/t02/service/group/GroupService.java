package org.zerock.t02.service.group;

import org.zerock.t02.domain.Tbl_group;
import org.zerock.t02.dto.GroupDTO;

public interface GroupService {
    Long regi(GroupDTO groupDTO);
    default Tbl_group dtoToEntity(GroupDTO groupDTO){
        Tbl_group entity = Tbl_group.builder()
                .bno(groupDTO.getBno())
                .groupName(groupDTO.getGroupName())
                .groupPW(groupDTO.getGroupPW())
                .MemberID(groupDTO.getMemberID())
                .build();
        return entity;
    }
    default GroupDTO entityToDto(Tbl_group entity){
        GroupDTO groupDTO = GroupDTO.builder()
                .bno(entity.getBno())
                .groupName(entity.getGroupName())
                .groupPW(entity.getGroupPW())
                .memberID(entity.getMemberID())
                .build();
        return groupDTO;
    }
}
