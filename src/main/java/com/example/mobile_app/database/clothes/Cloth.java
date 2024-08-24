package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.general.BaseEntity;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "clothes")
public class Cloth  implements BaseEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private User user;


    @Column(name = "link_photo")
    private String linkPhoto;

    @Enumerated(EnumType.STRING)
    private Season season;


    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder.Default
    @OneToMany(mappedBy = "cloth")
    private List<SetCloth> setClothes = new ArrayList<>();





}
