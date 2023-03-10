package com.example.project_5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_5.Model.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

    Store findStoreById(Integer id);
}
