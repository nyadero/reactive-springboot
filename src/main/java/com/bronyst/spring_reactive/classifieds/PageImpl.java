package com.bronyst.spring_reactive.classifieds;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageImpl<T> {
    private final List<T> content;
    private final Pageable pageable;
    private final long totalElements;
    private final int totalPages;

    public PageImpl(List<T> content, Pageable pageable, long totalElements, int totalPages) {
        this.content = content;
        this.pageable = pageable;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
