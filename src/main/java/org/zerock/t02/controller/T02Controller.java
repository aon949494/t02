package org.zerock.t02.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.t02.dto.GroupDTO;
import org.zerock.t02.dto.MemberDTO;
import org.zerock.t02.dto.TodoDTO;
import org.zerock.t02.repository.GroupSpringRepository;
import org.zerock.t02.repository.Repository;
import org.zerock.t02.repository.TodoRepository;
import org.zerock.t02.repository.TodoStringRepository;
import org.zerock.t02.service.group.GroupService;
import org.zerock.t02.service.member.MemberService;

import org.zerock.t02.service.todo.TodoService;
import org.zerock.t02.service.todo.TodoServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test02")
@RequiredArgsConstructor
@Log4j2
public class T02Controller {
    private final MemberService memberService;
    private final TodoService todoService;
    private final GroupService groupService;
    private final TodoStringRepository todoStringRepository;
    private final TodoRepository todoRepository;
    private final Repository repository;
    private final GroupSpringRepository groupSpringRepository;
    private String testID;
    @GetMapping("/")
    public String index(){return "redirect:/test02/testlogin";}
    @GetMapping("/main")
    public void main(Model model){
        log.info(testID);
        model.addAttribute("memberID",testID);
        log.info(groupSpringRepository.findByMemberID(testID));
        model.addAttribute("groupList",groupSpringRepository.findByMemberID(testID));
    }
    @GetMapping("/memberInfo")
    public void memberInfo(String memberID, Model model){
        log.info(repository.findByMemberID(memberID));


        model.addAttribute("memberID",memberID);
        model.addAttribute("member",repository.findByMemberID(memberID));
    }
    @GetMapping("/testlogin")
    public void login(){
        log.info("login");
    }
    @PostMapping("/testlogin")
    public String login(String memberID, String memberPW, RedirectAttributes redirectAttributes){
        log.info(memberPW);
        boolean idck = memberService.login(memberID, memberPW);
        if(idck==false){
            redirectAttributes.addFlashAttribute("idck",idck);
            return "redirect:/test02/testlogin";
        }
        else{
            redirectAttributes.addFlashAttribute("mem",memberID);
            this.testID = memberID;
            return "redirect:/test02/main";
        }

    }
    @GetMapping("/regi")
    public void regi(Model model){

        log.info("regi");
        model.addAttribute("memberID",testID);
    }
    @PostMapping("/regi")
    public String regiPost(TodoDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto...."+dto);
        Long bno = todoService.regi(dto);
        redirectAttributes.addFlashAttribute("bno", bno);
        return "redirect:/test02/list";
    }
    @GetMapping("/list")
    public void list(Model model) {
        log.info(todoStringRepository.findByMemberID(testID));
        model.addAttribute("todoList",todoRepository.findByMemberID(testID));
        //log.info(todoService.memList(testID));
        //model.addAttribute("todoList",todoSearch.search(testID));
        //model.addAttribute("todoList",todoService.list());
    }
    @GetMapping("/read")
    public void read(long bno, Model model){
        log.info(bno);
        TodoDTO todoDTO = todoService.read(bno);
        model.addAttribute("todoDTO",todoDTO);
    }
    @GetMapping("/modify")
    public void modify(long bno,Model model){
        TodoDTO todoDTO = todoService.read(bno);
        model.addAttribute("todoDTO",todoDTO);
        log.info("modify");
    }
    @PostMapping("/modify")
    public String modifyPost(TodoDTO dto, RedirectAttributes redirectAttributes){
        log.info("modidto: "+dto);
        todoService.modify(dto);
        redirectAttributes.addFlashAttribute("bno",dto.getBno());
        return "redirect:/test02/list";
    }
    @PostMapping("/remove")
    public String remove(long bno, RedirectAttributes redirectAttributes){
        log.info("bno.."+bno);
        todoService.delete(bno);
        redirectAttributes.addFlashAttribute("bno",bno);
        return "redirect:/test02/list";
    }
    @GetMapping("/testjoin")
    public void join(){log.info("join...get");}
    @PostMapping("/testjoin")
    public String joinPost(MemberDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto...."+dto);
        String memberID = memberService.join(dto);
        redirectAttributes.addFlashAttribute("msg", memberID);
        return "redirect:/test02/testlogin";
    }
    @GetMapping("/groupRegi")
    public void groupRegi(String memberID, Model model){

        log.info("group register....");
        model.addAttribute("memberID",memberID);
    }
    @PostMapping("/groupRegi")
    public String groupRegi(GroupDTO groupDTO, RedirectAttributes redirectAttributes){
        log.info("gdto...."+groupDTO);
        Long bno = groupService.regi(groupDTO);
        redirectAttributes.addFlashAttribute("bno", bno);
        return "redirect:/test02/main";
    }
}
