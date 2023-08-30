package com.start.catproject.inquiry.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.comment.entity.Comment;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Entity
@Table(name = "inquiry")
public class Inquiry extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ToString.Exclude
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.DETACH, orphanRemoval = true)
    @OrderBy("id")
    private Set<Comment> comments =new LinkedHashSet<>();

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

}
