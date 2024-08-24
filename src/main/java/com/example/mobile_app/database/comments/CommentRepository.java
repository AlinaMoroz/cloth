package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLine;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface CommentRepository extends JpaRepository<Comment, Long> {


//    @Query("select c from Comment c " +
//    "join fetch c.user u where c.newsLine.id = :newsLine")

//    @Query("select c from Comment c " +
//    "join fetch c.user u where c.newsLine = :newsLine")
//    List<Comment> findAllByNewsLine(@Param("newsLine") NewsLine newsLine);

    List<Comment> findAllByNewsLineId(Long newsLineId);


}
