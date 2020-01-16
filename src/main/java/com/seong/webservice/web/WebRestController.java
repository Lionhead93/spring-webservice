package com.seong.webservice.web;

import com.seong.webservice.dto.PostsSaveReqDto;
import com.seong.webservice.repo.PostsRepository;
import com.seong.webservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebRestController {


    private final PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveReqDto postsSaveReqDto) {
        postsService.save(postsSaveReqDto);
    }

}
