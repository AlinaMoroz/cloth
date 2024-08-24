package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.general.BaseEntity;
import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Set implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private NewsLine newsLine;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "set")
    private List<SetCloth> setClothes = new ArrayList<>();


}
