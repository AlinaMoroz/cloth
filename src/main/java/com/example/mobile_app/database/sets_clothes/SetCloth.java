package com.example.mobile_app.database.sets_clothes;

import com.example.mobile_app.database.clothes.Cloth;

import com.example.mobile_app.database.general.BaseEntity;
import com.example.mobile_app.database.sets.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "sets_clothes")
public class SetCloth implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Set set;

    @ManyToOne
    private Cloth cloth;

    public void setSet(Set set){
        this.set = set;
        this.set.getSetClothes().add(this);
    }

    public void setCloth(Cloth cloth){
        this.cloth = cloth;
        this.cloth.getSetClothes().add(this);

    }



}
