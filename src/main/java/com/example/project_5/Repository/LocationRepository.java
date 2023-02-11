package com.example.project_5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_5.Model.Location;
public interface LocationRepository extends JpaRepository<Location,Integer> {
    Location findLocationById(Integer id);
}
