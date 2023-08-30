package com.start.catproject.cat.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.catItem.Entity.CatItem;
import com.start.catproject.category.entity.DetailCategory;
import com.start.catproject.image.entity.CatImage;
import com.start.catproject.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Table(name = "cats")
public class Cat extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String loveSnack;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String etc;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "cat", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<CatItem> catItems = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "cat", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<CatImage> catImages = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private DetailCategory detailCategory;


    public void addUser(User user) {
        this.user = user;
        user.addCat(this);
    }

    public void addCatItem(CatItem catItem){
        this.catItems.add(catItem);
    }

    public void addCatImage(CatImage catImage){
        this.catImages.add(catImage);
    }

    public void addDetailCategory(DetailCategory detailCategory){
        this.detailCategory = detailCategory;
        detailCategory.addCat(this);
    }

}
