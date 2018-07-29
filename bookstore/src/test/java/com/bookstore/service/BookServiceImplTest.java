/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author JC
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private BookService instance;

    @Mock
    private ObjectMapper objectMapper;

    public BookServiceImplTest() {
    }

    @Before
    public void startUp() {
        instance = new BookServiceImpl(new BookRepositoryImpl());
        objectMapper = new ObjectMapper();

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createBook method, of class BookServiceImpl.
     */
    @Test
    public void testCreateBook() {
        System.out.println("createBook");
        Book book = new Book();
        book.setId("test");
        instance.createBook(book);
        List<Book> listBooks = instance.getBooks();
        Assert.assertThat(listBooks, CoreMatchers.hasItems(book));
    }

    /**
     * Test of updateBook method, of class BookServiceImpl.
     */
    @Test
    public void testUpdateBook_Book() {
        System.out.println("updateBook");
        Book book = new Book();
        book.setId("500");
        book.setTitle("Post");
        instance.createBook(book);
        //List<Book> listBooks = instance.getBooks();
        book.setTitle("Post_update");
        instance.updateBook(book);

        Book updatedBook = (Book) instance.getBook("500").get();

        Assert.assertEquals(updatedBook.getTitle(), "Post_update");
    }

    /**
     * Test of updateBook method, of class BookServiceImpl.
     */
    @Test
    public void testUpdateBook_String_Map() {
        System.out.println("updateBook");

        Book book = new Book();
        book.setId("500");
        book.setTitle("Post");
        instance.createBook(book);

        Map<String, Object> patchObjects = new HashMap<>();
        patchObjects.put("title", "patch");
        Boolean result = instance.updateBook("500", patchObjects);
        Book updatedBook = (Book) instance.getBook("500").get();

        Assert.assertEquals(updatedBook.getTitle(), "patch");
    }

    /**
     * Test of deleteBook method, of class BookServiceImpl.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        Book book = new Book();
        book.setId("500");
        book.setTitle("Post");
        instance.createBook(book);

        List<Book> listBooks = instance.getBooks();
        instance.deleteBook("500");
        List<Book> afterDeleteListBooks = instance.getBooks();
        Assert.assertEquals(listBooks.size() - 1, afterDeleteListBooks.size());

    }

    /**
     * Test of getBook method, of class BookServiceImpl.
     */
    @Test
    public void testGetBook() {
        System.out.println("getBook");
        Book book = new Book();
        book.setId("500");
        book.setTitle("Post");
        instance.createBook(book);
        Book book1 = (Book) instance.getBook("500").get();
        assertEquals(book, book1);

    }

    /**
     * Test of getBooks method, of class BookServiceImpl.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        List<Book> result = instance.getBooks();
        Assert.assertThat(result, not(IsEmptyCollection.empty()));

    }
}
