package com.project.d11.jpa.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.jpa.D11BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserEntity extends D11BaseEntity {
    @JsonProperty("user_name")
    String userName;

    @JsonProperty("email")
    String email;

    @JsonProperty("auth_token")
    String authToken;


}
