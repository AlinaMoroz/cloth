package com.example.mobile_app.database.newslines;

import com.example.mobile_app.database.newslines.NewsLine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsLineRepository extends JpaRepository<NewsLine, Long> {

}
