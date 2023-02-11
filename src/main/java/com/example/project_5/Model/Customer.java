package com.example.project_5.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    //id - name - phoneNumber - email (Add all required validation)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @NotEmpty(message = "the name is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String name;

    @NotNull(message = "the phone number is required! ")
    @Column(columnDefinition = "int not null")
    private int phoneNumber ;

    @NotEmpty(message = "the email is required")
    @Column(columnDefinition = "varchar(22) not null")
    private String email;

    @ManyToMany(mappedBy = "customers")
    private List<Store> stores;


}
