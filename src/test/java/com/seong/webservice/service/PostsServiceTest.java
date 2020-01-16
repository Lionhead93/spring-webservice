package com.seong.webservice.service;

import com.seong.webservice.dto.PostsMainResDto;
import com.seong.webservice.dto.PostsSaveReqDto;
import com.seong.webservice.entity.posts.Posts;
import com.seong.webservice.repo.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    void afterAll() {
        postsRepository.deleteAll();
    }

    @Test
    void save() {
        PostsSaveReqDto dto = PostsSaveReqDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();
        System.out.println(dto);

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        System.out.println(posts);
    }

    @Test
    void findAllDesc() {
        List<PostsMainResDto> allDesc = postsService.findAllDesc();
        System.out.println(allDesc);
    }
}