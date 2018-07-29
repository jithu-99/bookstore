/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.repository;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * This class implemented by BookRepository. All the CRUD operations are implemented in this class
 *
 * @author Jithendra Chikkanna
 */
@Component
public class BookRepositoryImpl
        implements BookRepository {

    /**
     * books variable is acting as DB/persistent
     */
    private static final Map<String, Book> books = new HashMap<String, Book>();

    /**
     * Population of books data
     */
    static {

        Author author1 = new Author("1", "Stephen King", "20-05-1956", "20-08-2014", "London");
        Author author2 = new Author("2", "Colin Dexter", "22-02-1957", "29-09-2015", "Reading");
        Author author3 = new Author("3", "J K Rowling", "12-02-1957", "", "Cardiff");
        List<Author> authorList1 = new ArrayList<>();

        authorList1.add(author1);

        authorList1.add(author2);

        List<Author> authorList2 = new ArrayList<>();

        authorList2.add(author3);

        books.put(
                "1", new Book("1", "Victory", "KK Publisher", "1976", "£ 10.00", authorList1));
        books.put(
                "2", new Book("2", "Harry potter", "TK Publisher", "1983", "£ 100.00", authorList2));
    }

    @Override
    public Optional findById(String bookId) {
        Book book = books.get(bookId);

        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> findAll() {

        return new ArrayList<>(books.values());
    }

    @Override
    public void create(Book book) {
        books.put(book.getId(), book);

    }

    @Override
    public void update(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public void delete(String bookId) {
        books.remove(bookId);
    }
}
