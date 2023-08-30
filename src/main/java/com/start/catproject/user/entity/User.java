package com.start.catproject.user.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cart.entity.Cart;
import com.start.catproject.cat.entity.Cat;
import com.start.catproject.constants.Authority;
import com.start.catproject.constants.LoginType;
import com.start.catproject.constants.UserStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Setter
    private String email;

    @Column(nullable = false, unique = true)
    @Setter
    private String nickName;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private LoginType loginType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private UserStatus userStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private Authority authority;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cat> cats = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cart> carts = new LinkedHashSet<>();

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public void addCart(Cart cart) {
        this.carts.add(cart);
    }
}
