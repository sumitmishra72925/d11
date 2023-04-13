package com.project.d11.jpa;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.PostgresUUIDType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@TypeDef(
        name = "pg-uuid",
        defaultForType = UUID.class,
        typeClass = PostgresUUIDType.class
)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@MappedSuperclass
public class D11BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    Long id;

    @Column(name = "uuid", unique = true, nullable = false)
    UUID uuid;

    public D11BaseEntity() {
        this.uuid = UUID.randomUUID();
    }

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
