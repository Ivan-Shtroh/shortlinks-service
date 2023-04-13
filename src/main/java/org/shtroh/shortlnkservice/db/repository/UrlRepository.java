package org.shtroh.shortlnkservice.db.repository;

import org.shtroh.shortlnkservice.db.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Integer> {
    Optional<Url> findById(Integer id);
}
