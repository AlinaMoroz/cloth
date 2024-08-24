package com.example.mobile_app.database.users;

import com.example.mobile_app.database.clothes.Cloth;
import com.example.mobile_app.database.comments.Comment;
import com.example.mobile_app.database.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ToString(exclude = {"cloths"})
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String avatar;

    private String size;


    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    // поле в cloth
    private List<Cloth> cloths = new ArrayList<>();

//    @Builder.Default
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment>comments = new ArrayList<>();

    public void addCloth(Cloth cloth){
        cloths.add(cloth);
        cloth.setUser(this);
    }
//
//    public void addComments(Comment comment){
//        comments.add(comment);
//        comment.setUser(this);
//    }



}
