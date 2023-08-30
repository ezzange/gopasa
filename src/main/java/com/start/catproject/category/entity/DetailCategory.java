package com.start.catproject.category.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cat.entity.Cat;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Entity
@Table(name = "detail_category")
public class DetailCategory extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String detailCategoryName;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private MainCategory mainCategory;

    @ToString.Exclude
    @OneToMany(mappedBy = "detailCategory",cascade = CascadeType.DETACH, orphanRemoval = true)
    @Setter
    private Set<Cat> cats;

    public void addMainCaategory(MainCategory mainCategory){
        this.mainCategory = mainCategory;
        mainCategory.addDetailCategory(this);
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }
}
