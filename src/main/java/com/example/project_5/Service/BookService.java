package com.example.project_5.Service;

import com.example.project_5.Exception.ApiException;
import com.example.project_5.Model.Book;
import com.example.project_5.Model.Store;
import com.example.project_5.Repository.BookRepository;
import com.example.project_5.Repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    private StoreRepository storeRepository;

    public BookService( BookRepository bookRepository,StoreRepository storeRepository){
        this.bookRepository=bookRepository;
        this.storeRepository=storeRepository;
    }
    public List<Book> GetAll(){
        return bookRepository.findAll();
    }

    public void AddBook(Book book){
        bookRepository.save(book);
    }
    public void UpdateBook(Integer id ,Book book){
        Book old_book = bookRepository.findBookById(id);
        if(old_book==null){
            throw new ApiException("book id not found");
        }
        old_book.setName(book.getName());
        old_book.setBookCount(book.getBookCount());
        old_book.setGenre(book.getGenre());
        bookRepository.save(old_book);
    }

    public void Delete_book(Integer id){
        Book delete_book =bookRepository.findBookById(id);
        if(delete_book==null){
            throw new ApiException("book id not found");
        }
        bookRepository.delete(delete_book);
    }
    public void AssignBookToStore(Integer book_id , Integer store_id){
        Book book = bookRepository.findBookById(book_id);
        Store store = storeRepository.findStoreById(store_id);
        if(book==null || store==null){
            throw new ApiException("book id not found or store id not found");
        }
        book.setStore(store);
        bookRepository.save(book);
    }


    //takes bookId and return number of books available
    public int ReturnBookAvailable(Integer id){
        Book book =bookRepository.findBookById(id);
        if(book==null){
           throw new ApiException("book id not found");
      }
        else if(book.getBookCount()==0){
            throw new ApiException("There are no books available :(.");
        }
        return  book.getBookCount();
    }



    //book name and return all book information
    public Book ReturnBookInformation(String name){
        Book book =bookRepository.findBooksByName(name);
        if(book==null){
            throw new ApiException("book name not found");
        }
        return book;
    }

    // return all books under a specific genre
    public List<Book> ReturnBySpecificGenre (String genre){
       List <Book> book = bookRepository.findBooksByGenre(genre);
        if(book==null){
            throw new ApiException("genre not found");
        }

        return book;

    }
}
