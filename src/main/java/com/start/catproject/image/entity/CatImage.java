package com.start.catproject.image.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cat.entity.Cat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Table(name = "cat_image")
@Entity
public class CatImage extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String url;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Long size;


    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Cat cat;

    public void addCat(Cat cat){
        this.cat=cat;
        cat.addCatImage(this);
    }


}
