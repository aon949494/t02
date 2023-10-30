package org.zerock.t02.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tbl_group {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 50, nullable = false)
    private String groupName;
    @Column(length = 50, nullable = false)
    private String groupPW;
    @Column(length = 50)
    private String MemberID;

}
