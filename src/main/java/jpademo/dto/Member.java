package jpademo.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@ToString
public class Member {
    @Id
    private String id;

    @Column(name = "NAME")
    private String userName;

    private Integer age;
}
