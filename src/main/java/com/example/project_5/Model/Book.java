package com.example.project_5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    // - name - bookCount - genre (Add all required validation)
    @NotEmpty(message = "the name is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String name;

    @NotNull(message = "book cound required")
    @Column(columnDefinition = "int not null")
    private int bookCount;

    @NotEmpty(message = "the genre is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String genre;


    @ManyToOne
    @JoinColumn(name="store_id",referencedColumnName = "id")
    @JsonIgnore
    private Store store;





}
