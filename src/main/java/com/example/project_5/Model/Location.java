package com.example.project_5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    //area - street (Add all required validation)

    @NotEmpty(message = "the area is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String area;

    @NotEmpty(message = "the street is required!!")
    @Column(columnDefinition = "varchar(22) not null")
    private String street;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;



}
