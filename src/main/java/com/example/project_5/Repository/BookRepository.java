package com.example.project_5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.project_5.Model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    Book findBooksByName(String name);
    Book findBooksById(Integer id);

  //  Book findBooksByStoresId(Integer id);
   List<Book> findBooksByGenre(String genre);

   // Book findBooksByGenre(String genre);

}
