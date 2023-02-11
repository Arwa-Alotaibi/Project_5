package com.example.project_5.Service;


import com.example.project_5.DTO.LocationDTO;
import com.example.project_5.Exception.ApiException;
import com.example.project_5.Model.Location;
import com.example.project_5.Model.Store;
import com.example.project_5.Repository.LocationRepository;
import com.example.project_5.Repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private StoreRepository storeRepository;
    private LocationRepository locationRepository;

    public LocationService( StoreRepository storeRepository,LocationRepository locationRepository){
        this.storeRepository=storeRepository;
        this.locationRepository=locationRepository;
    }
    public void AddLocation(LocationDTO locationDTO){
        Store store = storeRepository.findStoreById(locationDTO.getStore_id());
        if(store==null){
            throw  new ApiException("store id not found!!");
        }
        Location location =new Location(null,locationDTO.getArea(),locationDTO.getStreet(),store);
        locationRepository.save(location);
    }

    public void UpdateLocation(LocationDTO locationDTO){
        Location location =locationRepository.findLocationById(locationDTO.getStore_id());
        if(location==null){
            throw new ApiException(" id not found!!");
        }
        location.setArea(locationDTO.getArea());
        location.setStreet(locationDTO.getStreet());
        locationRepository.save(location);
    }
    public void DeleteLocation(Integer id){
        Location delete_locaton= locationRepository.findLocationById(id);
        if(delete_locaton==null){
            throw new ApiException(" location id not found!!");
        }
        locationRepository.delete(delete_locaton);
    }
}
