package com.example.project_5.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LocationDTO {


    @NotNull(message = "storeid should be not null")
    private Integer store_id;

    @NotEmpty(message = "the area is required!!")
    private String area;

    @NotEmpty(message = "the street is required!!")
    private String street;
}
