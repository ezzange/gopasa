package com.start.catproject.catItem.Entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cart.entity.Cart;
import com.start.catproject.cat.entity.Cat;
import com.start.catproject.constants.Authority;
import com.start.catproject.image.entity.CatImage;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "cat_items")
public class CatItem extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String info;

    @Column(nullable = false)
    private boolean waterMark;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ToString.Exclude
    @OneToMany(mappedBy = "catItem", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cart> carts = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Cat cat;

    @ToString.Exclude
    @OneToOne
    @Setter
    private CatImage catImage;

    public void addCart(Cart cart){
        this.carts.add(cart);
    }

    public void addCat(Cat cat){
        this.cat =cat;
        cat.addCatItem(this);
    }
}
