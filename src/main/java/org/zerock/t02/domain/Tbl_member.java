package org.zerock.t02.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tbl_member {
    @Id
    @Column(name="memberID")
    private String memberID;
    @Column(length = 50, nullable = false)
    private String memberPW;
    @Column(length = 50, nullable = false)
    private String memberName;



    public void change(String memberPW){
        this.memberPW=memberPW;
    }
}
