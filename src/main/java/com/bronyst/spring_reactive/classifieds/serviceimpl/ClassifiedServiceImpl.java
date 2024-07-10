package com.bronyst.spring_reactive.classifieds.serviceimpl;

import com.bronyst.spring_reactive.classifieds.PageImpl;
import com.bronyst.spring_reactive.classifieds.dto.ClassifiedDto;
import com.bronyst.spring_reactive.classifieds.entity.Classified;
import com.bronyst.spring_reactive.classifieds.repository.ClassifiedRepository;
import com.bronyst.spring_reactive.classifieds.service.ClassifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClassifiedServiceImpl implements ClassifiedService {
    @Autowired
    private ClassifiedRepository classifiedRepository;

    public static final int PAGE_SIZE = 20;

    @Override
    public Mono<Classified> addClassified(ClassifiedDto classifiedDto) {
        return null;
    }

    public Mono<PageImpl<Classified>> allClassifieds(int pageNumber) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        int offset = pageNumber * PAGE_SIZE;

        // Fetch total count separately
        Mono<Long> totalElementsMono = classifiedRepository.count();

        // Fetch items for the current page
        Flux<Classified> classifiedsFlux = classifiedRepository.findAll(sort)
                .skip(offset)
                .take(PAGE_SIZE);

        // Combine results and total count into a Page object
        return Flux.zip(classifiedsFlux.collectList(), totalElementsMono)
                .map(tuple -> {
                    List<Classified> classifieds = tuple.getT1();
                    long totalElements = tuple.getT2();
                    int totalPages = (int) Math.ceil((double) totalElements / PAGE_SIZE);
                    return new PageImpl<>(classifieds, (Pageable) Sort.by(Sort.Direction.DESC, "id"), totalElements, totalPages);
                })
                .single(); // Convert Flux to Mono
    }
}
