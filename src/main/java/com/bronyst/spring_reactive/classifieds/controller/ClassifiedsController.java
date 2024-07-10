package com.bronyst.spring_reactive.classifieds.controller;

import com.bronyst.spring_reactive.classifieds.PageImpl;
import com.bronyst.spring_reactive.classifieds.dto.ClassifiedDto;
import com.bronyst.spring_reactive.classifieds.entity.Classified;
import com.bronyst.spring_reactive.classifieds.service.ClassifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/classifieds")
public class ClassifiedsController{
    @Autowired
    private ClassifiedService classifiedService;

//    add classified
    @PostMapping()
    public Mono<Classified> addClassified(
            @RequestBody ClassifiedDto classifiedDto
    ){
        return classifiedService.addClassified(classifiedDto);
    }

    // get classifieds
    @GetMapping()
    public Mono<PageImpl<Classified>>classifieds(
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber
    ){
        return classifiedService.allClassifieds(pageNumber);
    }


}
