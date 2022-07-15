package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.domain.Publisher;
import com.springframework.spring5webapp.repository.AuthorRepository;
import com.springframework.spring5webapp.repository.BookRepository;
import com.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher("Street", "Iasi", "Romania", 1234);
        eric.getBooks().add(book);
        book.getAuthor().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }
}
