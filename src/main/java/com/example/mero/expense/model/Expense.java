package com.example.mero.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "expense")
@Getter @Setter
public class Expense {

    @Id
    private Long id;

    private Instant expenseDate;  //for timestamp

    private String description;

    private String location;
   

    @ManyToOne
	private Category category;
	
    
    //if you wanna keep the relationship but dont want to return user information
	@JsonIgnore
	@ManyToOne
	private User user;


}
