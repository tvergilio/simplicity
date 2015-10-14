package com.simplicityitself.training.mocks

import groovy.json.JsonSlurper

/**
 * Created by pledbrook on 12/10/15.
 */
class BookArchiver {
    static final String BOOKS_URL = "http://www.example.org/books.json"

    final RestClient restClient
    final BookDao dao

    BookArchiver(RestClient client, BookDao dao) {
        this.restClient = client
        this.dao = dao
    }

    List<Book> archiveBooks() {
        def bookList = []
        def jsonString = restClient.getContent(BOOKS_URL)
        def jsonData = new JsonSlurper().parseText(jsonString)
        jsonData.books.each { book ->
            bookList << dao.persist(new Book(book.title, book.author))
        }
        return bookList
        // TODO: Complete the rest of this implementation. See the test case to
        // learn what structure the JSON has and what format the dates take.
        // Note that Book is an immutable class, so you can only use the tuple
        // constructor Book(String, String, Date), not the Groovy Beans one.

        //There's no Date.
    }
}
