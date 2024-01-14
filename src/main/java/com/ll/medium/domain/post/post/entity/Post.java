package com.ll.medium.domain.post.post.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.post.postLike.entity.PostLike;
import com.ll.medium.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
public class Post extends BaseEntity {
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<PostLike> likes = new ArrayList<>();

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

    public void like(Member member) {
        if (hasLike(member)) {
            return;
        }

        likes.add(PostLike.builder()
                .post(this)
                .member(member)
                .build());
    }

    public boolean hasLike(Member member) {
        return likes.stream()
                .anyMatch(postLike -> postLike.getMember().equals(member));
    }

    public void cancelLike(Member member) {
        likes.removeIf(postLike -> postLike.getMember().equals(member));
    }
}