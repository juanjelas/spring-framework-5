package jjsev.springframework.spring5webapp.bootstrap;

import jjsev.springframework.spring5webapp.model.Author;
import jjsev.springframework.spring5webapp.model.Book;
import jjsev.springframework.spring5webapp.model.Publisher;
import jjsev.springframework.spring5webapp.repositories.AuthorRepository;
import jjsev.springframework.spring5webapp.repositories.BookRepository;
import jjsev.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher everest = new Publisher("Everes", "Madrid");
        Author alberto = new Author("Alberto", "Garcia");
        Book ddd = new Book("Domain Driven Design", "1234", everest);
        alberto.getBooks().add(ddd);
        ddd.getAuthors().add(alberto);

        publisherRepository.save(everest);
        authorRepository.save(alberto);
        bookRepository.save(ddd);

        Publisher anaya = new Publisher("Anaya", "Barcelona");
        Author carlos = new Author("Carlos", "Garcia");
        Book ca = new Book("Clean Architecture", "1234", anaya);
        carlos.getBooks().add(ca);
        ca.getAuthors().add(carlos);

        publisherRepository.save(anaya);
        authorRepository.save(carlos);
        bookRepository.save(ca);
    }
}
