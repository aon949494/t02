package org.zerock.t02.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.zerock.t02.domain.Tbl_member;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private Long bno;
    private String title, content,memberID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean finished;
    private LocalDateTime regDate, modDate;
}
