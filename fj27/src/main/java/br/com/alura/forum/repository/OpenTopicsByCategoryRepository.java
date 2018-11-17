package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.OpenTopicsByCategory;

public interface OpenTopicsByCategoryRepository extends Repository<OpenTopicsByCategory, Long> {

	void saveAll(Iterable<OpenTopicsByCategory> topics);

	@Query("select t from OpenTopicsByCategory t " +
            "where year(t.date) = year(current_date) " +
            "and month(t.date) = month(current_date)")
    List<OpenTopicsByCategory> findAllByCurrentMonth();
}
