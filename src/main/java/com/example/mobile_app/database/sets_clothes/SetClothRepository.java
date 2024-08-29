package com.example.mobile_app.database.sets_clothes;

import com.example.mobile_app.database.clothes.Cloth;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SetClothRepository extends JpaRepository<SetCloth, Long> {


//@Query("SELECT sc.cloth FROM SetCloth sc WHERE sc.set.id = :setId")

    List<Cloth> findAllClothBySetId(Long setId);
}
