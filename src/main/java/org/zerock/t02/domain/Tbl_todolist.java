package org.zerock.t02.domain;

import lombok.*;
import org.apache.catalina.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tbl_todolist extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 200)
    private String content;
    @Column(name = "memberID")
    private String memberID;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @Column(nullable = false)
    private boolean finished;

    public void change(String title, String content, LocalDate dueDate, boolean finished){
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.finished=finished;
    }
}
