package com.bronyst.spring_reactive.classifieds.entity;

import com.bronyst.spring_reactive.classifieds.enums.ClassifiedCategory;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aot.generate.Generated;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.UUID;

@Data
@Table("classifieds")
@AllArgsConstructor
@NoArgsConstructor
public class Classified {
    @Id
    private Long id;
    private String name;
    private String description;
    private int price;
    private String category;
}
