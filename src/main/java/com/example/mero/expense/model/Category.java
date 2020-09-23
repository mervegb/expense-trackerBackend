package com.example.mero.expense.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;



@Entity
@NoArgsConstructor
@Data  //to get getters and setters from lombok
@Table(name = "category")
@Getter @Setter
public class Category {

    @Id
    private Long id;

    @NonNull
    private String name;


}
