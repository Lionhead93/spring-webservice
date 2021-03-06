package com.seong.webservice.entity.posts;

import com.seong.webservice.SpringTestSupport;
import com.seong.webservice.repo.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostsRepositoryTest extends SpringTestSupport {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveFind() {
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("seong@wou.com")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
    }

    @Test
    public void baseTimeEntity() {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("abc@abc.com")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
    }

    @Test
    @Transactional
    void findAllDesc() {
        postsRepository.findAllDesc();
    }
}