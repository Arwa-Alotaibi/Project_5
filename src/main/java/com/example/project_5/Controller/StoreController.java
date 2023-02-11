package com.example.project_5.Controller;


import com.example.project_5.DTO.LocationDTO;
import com.example.project_5.Model.Book;
import com.example.project_5.Service.LocationService;
import com.example.project_5.Service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project_5.Model.Store;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    private StoreService storeService;

    private LocationService locationService;

    public StoreController(StoreService storeService, LocationService locationService){
        this.storeService=storeService;
        this.locationService=locationService;
    }
    @GetMapping("/all")
    public ResponseEntity GetAll(){
        List<Store> storeList = storeService.GetAll();
        return ResponseEntity.status(200).body(storeList);
    }
    @PostMapping("/add")
    public ResponseEntity AddStore(@Valid @RequestBody Store store){
        storeService.AddStore(store);
        return ResponseEntity.status(200).body("store added :)!");
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity UpdateStore(@PathVariable Integer id ,@Valid @RequestBody Store store){
        storeService.UpdateStore(id, store);
        return ResponseEntity.status(200).body("store updated :)!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteStore(@PathVariable Integer id){
        storeService.DeleteStore(id);
        return ResponseEntity.status(200).body("store deleted :)!");
    }

    @PostMapping("/location/add")
    public ResponseEntity AddLocation(@Valid @RequestBody LocationDTO locationDTO){
        locationService.AddLocation(locationDTO);
        return ResponseEntity.status(200).body("location added :)!");
    }
    @PutMapping("/location/edit")
    public ResponseEntity UpdateLocaion(@Valid @RequestBody LocationDTO locationDTO){
        locationService.UpdateLocation(locationDTO);
        return ResponseEntity.status(200).body("location updated :)!");
    }
    @DeleteMapping("/delete/location/{id}")
    public ResponseEntity DeleteLocation(@PathVariable Integer id){
        locationService.DeleteLocation(id);
        return ResponseEntity.status(200).body("location deleted :)!");
    }


   // Create endpoint that takes storeid and return all the books

    @GetMapping("/books/{id}")
    public ResponseEntity ReturnBooks(@PathVariable Integer id){
        List<Book> book = storeService.ReturnAllBook(id);
        return ResponseEntity.status(200).body(book);

    }
}
