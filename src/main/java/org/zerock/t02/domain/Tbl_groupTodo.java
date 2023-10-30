package org.zerock.t02.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tbl_groupTodo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 200)
    private String content;
    @Column
    private String memberID;
    @Column
    private String groupName;
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
