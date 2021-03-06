package com.seong.webservice.web;

import com.seong.webservice.dto.PostsSaveReqDto;
import com.seong.webservice.repo.PostsRepository;
import com.seong.webservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class WebRestController {


    private final PostsService postsService;
    private final Environment environment;

    @GetMapping("/profile")
    public String hello() {
        return Arrays.stream(environment.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveReqDto postsSaveReqDto) {
        postsService.save(postsSaveReqDto);
    }

}
