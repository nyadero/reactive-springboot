package com.bronyst.spring_reactive.posts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Data
@Table("posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private Long id;

    private String description;

    private String postType;

    private String postAudience;

    private List<String> tags;
    private List<String> mentionedUsers;
    private List<String> mentionedBusinesses;

    public Post(long l, String title, String content) {
    }

}
