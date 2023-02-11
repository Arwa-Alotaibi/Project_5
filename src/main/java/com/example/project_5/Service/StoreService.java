package com.example.project_5.Service;


import com.example.project_5.Exception.ApiException;
import com.example.project_5.Model.Book;
import com.example.project_5.Model.Store;
import com.example.project_5.Repository.BookRepository;
import com.example.project_5.Repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private StoreRepository storeRepository;
    private BookRepository bookRepository;

    public StoreService(StoreRepository storeRepository,BookRepository bookRepository){
        this.storeRepository=storeRepository;
        this.bookRepository=bookRepository;
    }
    public List<Store> GetAll(){
       return storeRepository.findAll();
    }

    public void AddStore(Store store){
        storeRepository.save(store);
    }

    public void UpdateStore(Integer id,Store store){
        Store Old_Store= storeRepository.findStoreById(id);
        if(Old_Store==null){
            throw new ApiException("store id not found !!");
        }
        Old_Store.setName(store.getName());
        storeRepository.save(Old_Store);
    }
    public void  DeleteStore(Integer id){
        Store delete_store= storeRepository.findStoreById(id);
        if(delete_store==null){
            throw new ApiException("store id not found !!");
        }
        storeRepository.delete(delete_store);
    }


    // take storeid and return all the books
    public List<Book>ReturnAllBook(Integer id){
        Store store = storeRepository.findStoreById(id);
        if(store==null ){
            throw new ApiException(" store id not found");
        }
        return store.getBooks() ;

    }
}
