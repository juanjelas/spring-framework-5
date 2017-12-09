package jjsev.springframework.spring5webapp.repositories;

import jjsev.springframework.spring5webapp.model.Author;
import jjsev.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
