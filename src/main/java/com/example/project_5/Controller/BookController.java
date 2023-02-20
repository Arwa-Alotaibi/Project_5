package com.example.project_5.Controller;

import com.example.project_5.Model.Book;
import com.example.project_5.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private BookService bookService;
    public BookController( BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/all")
    public ResponseEntity GetAll(){
       List<Book> bookList= bookService.GetAll();
        return ResponseEntity.status(200).body(bookList);
    }

    @PostMapping("/add")
    public ResponseEntity AddBook(@Valid @RequestBody Book book){
        bookService.AddBook(book);
        return ResponseEntity.status(200).body("book added");
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity UpdateBook(@PathVariable Integer id ,@Valid @RequestBody Book book){
        bookService.UpdateBook(id, book);
        return ResponseEntity.status(200).body("book updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteBook(@PathVariable Integer id){
        bookService.Delete_book(id);
        return ResponseEntity.status(200).body("book deleted");
    }
    @PutMapping("/book/{book_id}/store/{store_id}")
    public ResponseEntity Assign(@PathVariable Integer book_id, @PathVariable Integer store_id){
        bookService.AssignBookToStore(book_id, store_id);
        return ResponseEntity.status(200).body("assign ");
    }
    //Create endpoint that takes bookId and return number of books available
    @GetMapping("/books/available/{id}")
    public ResponseEntity ReturBookAvailable(@PathVariable Integer id){
        return ResponseEntity.status(200).body(bookService.ReturnBookAvailable(id));
    }
    //Create endpoint that takes a book name and return all book information
    @GetMapping("/information/{name}")
    public ResponseEntity ReturnBookInformation(@PathVariable String name){
        Book book = bookService.ReturnBookInformation(name);
        return ResponseEntity.status(200).body(book);
    }
    //Create endpoint that return all books under a specific genre
    @GetMapping("/books/{genre}")
    public ResponseEntity RenturnBooksUnderGenre(@PathVariable String genre){
        List<Book> bookList = bookService.ReturnBySpecificGenre(genre);
        return ResponseEntity.status(200).body(bookList);

    }






}
