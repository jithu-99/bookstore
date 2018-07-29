/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.exceptions;

/**
 *
 * This is Exception class for not able to find the book
 *
 * @author Jithendra Chikkanna
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException() {
    }

    /**
     *
     * @param message Error message
     */
    public BookNotFoundException(String message) {
        super(message);
    }

    /**
     *
     * @param message Error message
     * @param cause cause for the exception
     */
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param cause cause for the exception
     */
    public BookNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
