package aqa_exam.db;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;
    @Column
    String name;
    @Column
    String email;
    @Column
    String password;
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
