package com.example.dao;

import com.example.model.Book;
import com.example.model.QBook;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class BookDAO {
    private BookRepository repo;

    public List<Book> findByTitleContains(String title){
        var pred = QBook.book.title.containsIgnoreCase(title);
        return StreamSupport.stream(
                        repo.findAll(pred).spliterator(), false).toList();
    }

}
