package aqa_exam.db;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.OffsetDateTime;
import java.util.Date;

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
    @Column
    OffsetDateTime createdAt;
    @Column
    OffsetDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }
}
