package com.start.catproject.comment.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.inquiry.entity.Inquiry;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private String content;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Inquiry inquiry;

    public void addInquiry(Inquiry inquiry){
        this.inquiry = inquiry;
        inquiry.addComment(this);
    }


}
