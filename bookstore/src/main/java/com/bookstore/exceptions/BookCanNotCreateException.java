/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.exceptions;

/**
 * This is Exception class for not able to create book
 *
 * @author Jithendra Chikkanna
 */
public class BookCanNotCreateException extends Exception {

    public BookCanNotCreateException() {
    }

    /**
     *
     * @param message Error message string
     */
    public BookCanNotCreateException(String message) {
        super(message);
    }

    /**
     *
     * @param message Error Message
     * @param cause Cause for the exception
     */
    public BookCanNotCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param cause cause for the exception
     */
    public BookCanNotCreateException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BookCanNotCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
