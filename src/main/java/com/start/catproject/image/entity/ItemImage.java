package com.start.catproject.image.entity;

import com.start.catproject.audit.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Table(name = "itemImages")
@Entity
public class ItemImage extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String url;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private Long size;

}
