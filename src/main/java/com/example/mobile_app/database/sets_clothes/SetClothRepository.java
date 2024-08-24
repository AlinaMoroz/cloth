package com.example.mobile_app.database.sets_clothes;

import com.example.mobile_app.database.sets_clothes.SetCloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SetClothRepository extends JpaRepository<SetCloth, Long> {

//    List<SetCloth> findAllByUserId(Long id);
}
