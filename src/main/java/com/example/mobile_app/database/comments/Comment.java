package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.general.BaseEntity;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "comments")
public class Comment implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    private String text;

    @Column(name = "date_post")
    private LocalDateTime datePost;

    @ManyToOne(fetch = FetchType.LAZY)
    private NewsLine newsLine;

}
