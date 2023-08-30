package com.start.catproject.category.entity;

import com.start.catproject.audit.BaseEntity;
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
@Table(name = "main_Category")
public class MainCategory extends BaseEntity {

    @Column(nullable = false, unique = false)
    private String mainName;

    @ToString.Exclude
    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL, orphanRemoval = true )
    @Setter
    private Set<DetailCategory> detailCategories;

    public void addDetailCategory(DetailCategory detailCategory){
        this.detailCategories.add(detailCategory);
    }


}
