package aqa_exam.db;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "User")
public class User {
    @Id
    Integer id;
    @Column
    String name;
    @Column
    String email;
    @Column
    String password;
    @Column
    String role = "user";
}
