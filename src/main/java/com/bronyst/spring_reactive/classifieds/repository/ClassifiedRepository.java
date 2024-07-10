package com.bronyst.spring_reactive.classifieds.repository;

import com.bronyst.spring_reactive.classifieds.entity.Classified;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClassifiedRepository extends ReactiveSortingRepository<Classified, String> {

    Mono<Long> count();
}
