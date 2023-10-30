package org.zerock.t02.service.group;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.t02.domain.Tbl_group;
import org.zerock.t02.dto.GroupDTO;
import org.zerock.t02.repository.GroupRepository;
@Service
@Log4j2
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public Long regi(GroupDTO groupDTO){
        log.info("dto========");
        log.info(groupDTO);
        Tbl_group group = modelMapper.map(groupDTO, Tbl_group.class);
        Long bno = repository.save(group).getBno();
        return bno;
    }
}
