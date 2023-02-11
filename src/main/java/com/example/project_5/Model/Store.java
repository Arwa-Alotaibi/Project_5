package com.example.project_5.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    //id - name (Add all required validation)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "the name is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String name;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "store")
    private List<Book> books;

    @ManyToMany
    @JsonIgnore
    private List<Customer> customers;



}
