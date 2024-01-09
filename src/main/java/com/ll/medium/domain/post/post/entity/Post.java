package com.ll.medium.domain.post.post.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
public class Post extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    private String title;

    private String body;

    private boolean isPublished;

    private boolean isPaid;

    @Setter(AccessLevel.PROTECTED)
    private long hit;

    public void increaseHit() {
        hit++;
    }
}