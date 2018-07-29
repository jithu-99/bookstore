/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jithendra Chikkanna
 */
@Service
public class BookServiceImpl implements BookService {

    /**
     * Book repository contains all the books(Theory)
     */
    @Autowired
    private final BookRepository bookRepository;

    /**
     * Object Mapper instance
     */
    @Autowired
    private ObjectMapper objectMapper;

    public BookServiceImpl(BookRepositoryImpl bookRepositoryImpl) {

        this.bookRepository = bookRepositoryImpl;
    }

    /**
     * create book service
     *
     * @param book
     */
    @Override
    public void createBook(Book book) {
        bookRepository.create(book);
    }

    /**
     * Update book service
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        bookRepository.update(book);
    }

    @Override
    public Boolean updateBook(String bookId, Map<String, Object> patchObjects) {

        Optional optional = bookRepository.findById(bookId);

        if (!optional.isPresent()) {
            return Boolean.FALSE;
        }
        Book book = (Book) optional.get();
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        Book bookToBePatched = objectMapper.convertValue(patchObjects, Book.class);

        if (bookToBePatched.getAuthor() != null) {
            book.setAuthor(bookToBePatched.getAuthor());
        }

        if (bookToBePatched.getId() != null) {
            book.setId(bookToBePatched.getId());
        }

        if (bookToBePatched.getPrice() != null) {
            book.setPrice(bookToBePatched.getPrice());
        }

        if (bookToBePatched.getPublisher() != null) {
            book.setPublisher(bookToBePatched.getPublisher());
        }

        if (bookToBePatched.getTitle() != null) {
            book.setTitle(bookToBePatched.getTitle());
        }
        if (bookToBePatched.getYear() != null) {
            book.setYear(bookToBePatched.getYear());
        }
        bookRepository.update(book);
        return Boolean.TRUE;

    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.delete(bookId);
    }

    @Override
    public Optional getBook(String bookId) {
        return bookRepository.findById(bookId);

    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

}
