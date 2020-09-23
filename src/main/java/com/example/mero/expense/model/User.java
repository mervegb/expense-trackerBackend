package com.example.mero.expense.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor  //in order to make JPA happy
@Entity
@Data
@Getter @Setter
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String name;

    private String email;


}
