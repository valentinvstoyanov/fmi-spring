package com.valentinvstoyanov.bloggerrestapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private LocalDateTime publishedAt = LocalDateTime.now();
    @NonNull
    private String title;
    private User author;
    @NonNull
    private String content;
    private List<String> tags;
    private String image;
    @NonNull
    private Status status = Status.ACTIVE;

    enum Status {ACTIVE, INACTIVE}
}
