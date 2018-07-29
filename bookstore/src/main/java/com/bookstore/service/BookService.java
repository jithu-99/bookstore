/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.model.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service interface for the exposed methods
 *
 * @author Jithendra Chikkanna
 */
public interface BookService {

    /**
     * Create the bood in DB
     *
     * @param book
     */
    public void createBook(Book book);

    /**
     * Update the book in DB
     *
     * @param book
     */
    public void updateBook(Book book);

    /**
     * Update patch items of the book id
     *
     * @param bookId
     * @param patchItems
     * @return
     */
    public Boolean updateBook(String bookId, Map<String, Object> patchItems);

    /**
     * Delete the book
     *
     * @param bookId
     */
    public void deleteBook(String bookId);

    /**
     * Retrive one book
     *
     * @param bookId
     * @return
     */
    public Optional getBook(String bookId);

    /**
     * Retreive all the books
     *
     * @return
     */
    public List<Book> getBooks();

}
