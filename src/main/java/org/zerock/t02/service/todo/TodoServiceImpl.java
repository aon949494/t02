package org.zerock.t02.service.todo;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.t02.domain.QTbl_todolist;
import org.zerock.t02.domain.Tbl_todolist;
import org.zerock.t02.dto.TodoDTO;
import org.zerock.t02.repository.TodoRepository;
import org.zerock.t02.repository.TodoStringRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;



@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository repository;
    private final TodoStringRepository todoStringRepository;
    private final ModelMapper modelMapper;
    @Override
    public Long regi(TodoDTO dto){
        log.info("DTO-------------------");
        log.info(dto);
        Tbl_todolist todolist = modelMapper.map(dto, Tbl_todolist.class);
        Long bno = repository.save(todolist).getBno();
        repository.alter();
        repository.set();
        repository.updat();
        return bno;
    }
    @Override
    public List<Tbl_todolist> list(){
        List<Tbl_todolist> result = repository.findAll();
        log.info(result);
        return result;
    }
    @Override
    public TodoDTO read(Long bno){
        Optional<Tbl_todolist> result = repository.findById(bno);
        return result.isPresent()? entityToDto(result.get()):null;
    }
    @Override
    public void modify(TodoDTO todoDTO){
        Optional<Tbl_todolist> result = repository.findById(todoDTO.getBno());
        log.info(result);
        if(result.isPresent()){
            Tbl_todolist entity = result.get();
            entity.change(todoDTO.getTitle(),todoDTO.getContent(),todoDTO.getDueDate(),todoDTO.isFinished());
            repository.save(entity);
        }
    }
    @Override
    public void delete(Long bno){
        repository.deleteById(bno);
        repository.alter();
        repository.set();
        repository.updat();
    }
    /*private BooleanBuilder getSearch(String testID, TodoDTO todoDTO){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QTbl_todolist qTblTodolist = QTbl_todolist.tbl_todolist;
        String memberID = todoDTO.getMemberID();
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(memberID.contains(testID)){
            log.info("00");
            conditionBuilder.or(qTblTodolist.memberID.contains(testID));
        }
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;


    }*/
}
