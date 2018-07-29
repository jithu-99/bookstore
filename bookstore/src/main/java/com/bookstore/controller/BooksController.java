/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.exceptions.BookCanNotCreateException;
import com.bookstore.exceptions.BookNotFoundException;
import com.bookstore.model.Book;
import com.bookstore.service.BookServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jithendra Chikkanna
 */
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookServiceImpl bookService;

    /**
     * Create the Book
     *
     * @param requestBody
     */
    @RequestMapping(method = RequestMethod.POST)
    public Book create(@RequestBody final Book requestBody) throws BookCanNotCreateException {

        if (requestBody.getId() == null) {
            throw new BookCanNotCreateException("Book can not be created because Id does not exist or Id value is null");
        }
        bookService.createBook(requestBody);
        return requestBody;
    }

    /**
     * Update the book based on book id
     *
     * @param bookId
     * @param requestBody
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") final String bookId, @RequestBody final Book requestBody) {
        bookService.updateBook(requestBody);
    }

    /**
     * Update the partial book details based on book Id
     *
     * @param bookId
     * @param requestBody
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public void updatePatch(@PathVariable("id") final String bookId, @RequestBody final Map<String, Object> requestBody) {
        bookService.updateBook(bookId, requestBody);
    }

    /**
     *
     * Get the particular book from the list
     *
     * @param bookId
     * @return
     * @throws Throwable
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable("id") final String bookId) throws Throwable {

        return (Book) bookService.getBook(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));

    }

    /**
     * Delete the book based on book Id
     *
     * @param bookId
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")
            final String bookId) {

        bookService.deleteBook(bookId);
    }

    /**
     * Retrieve the list of books
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List get() {
        return bookService.getBooks();

    }
}
