package org.zerock.t02.service.todo;

import org.zerock.t02.domain.Tbl_todolist;
import org.zerock.t02.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    Long regi(TodoDTO dto);
    List<Tbl_todolist> list();
    TodoDTO read(Long bno);
    void modify(TodoDTO todoDTO);
    void delete(Long bno);



    default Tbl_todolist dtoToEntity(TodoDTO todoDTO){
        Tbl_todolist entity = Tbl_todolist.builder()
                .bno(todoDTO.getBno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .memberID(todoDTO.getMemberID())
                .dueDate(todoDTO.getDueDate())
                .finished(todoDTO.isFinished())
                .build();
        return entity;
    }
    default TodoDTO entityToDto(Tbl_todolist entity){
        TodoDTO todoDTO = TodoDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .memberID(entity.getMemberID())
                .dueDate(entity.getDueDate())
                .finished(entity.isFinished())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return todoDTO;
    }

}
