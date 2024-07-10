package com.bronyst.spring_reactive.classifieds.service;

import com.bronyst.spring_reactive.classifieds.PageImpl;
import com.bronyst.spring_reactive.classifieds.dto.ClassifiedDto;
import com.bronyst.spring_reactive.classifieds.entity.Classified;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

public interface ClassifiedService {
    Mono<Classified> addClassified(ClassifiedDto classifiedDto);

    Mono<PageImpl<Classified>> allClassifieds(int pageNumber);
}
