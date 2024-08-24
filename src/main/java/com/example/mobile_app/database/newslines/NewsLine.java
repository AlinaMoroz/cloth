package com.example.mobile_app.database.newslines;

import com.example.mobile_app.database.comments.Comment;
import com.example.mobile_app.database.general.BaseEntity;
import com.example.mobile_app.database.sets.Set;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "news_lines")
public class NewsLine implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_date")
    private LocalDateTime postDate;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "dislike_count")
    private Integer dislikeCount;

//    @Builder.Default
//    @OneToMany(mappedBy = "newsLine")
//    List<Comment> comments = new ArrayList<>();
//
//    @Builder.Default
//    @OneToMany(mappedBy = "newsLine")
//    List<Set> sets = new ArrayList<>();
//
//    public void addComment(Comment comment){
//        comments.add(comment);
//        comment.setNewsLine(this);
//    }
//
//    public void addSet(Set set){
//        sets.add(set);
//        set.setNewsLine(this);
//    }


}
