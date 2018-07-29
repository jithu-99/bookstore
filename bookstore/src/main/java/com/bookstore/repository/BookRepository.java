/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.repository;

import com.bookstore.model.Book;
import java.util.List;
import java.util.Optional;

/**
 *
 * Repository Interface
 *
 * @author Jithendra Chikkanna
 */
public interface BookRepository {

    /**
     * find the book based in book Id
     *
     * @param bookId
     * @return
     */
    Optional<Book> findById(String bookId);

    /**
     * Find all the books
     *
     * @return
     */
    List<Book> findAll();

    /**
     * Create a Book
     *
     * @param book
     */
    void create(Book book);

    /**
     * Update the book
     *
     * @param book
     */
    void update(Book book);

    /**
     * Delete the book
     *
     * @param bookId
     */
    void delete(String bookId);

}
