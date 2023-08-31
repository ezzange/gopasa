package com.start.catproject.category.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cat.entity.Cat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Entity
@Table(name = "cat_category")
public class CatCategory extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String detailCategoryName;


    @ToString.Exclude
    @OneToMany(mappedBy = "catCategory",cascade = CascadeType.DETACH, orphanRemoval = true)
    @Setter
    private Set<Cat> cats;


    public void addCat(Cat cat) {
        this.cats.add(cat);
    }
}
