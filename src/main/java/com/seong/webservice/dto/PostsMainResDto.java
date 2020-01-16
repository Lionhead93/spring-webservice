package com.seong.webservice.dto;

import com.seong.webservice.entity.posts.Posts;
import lombok.Getter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;

@Getter
public class PostsMainResDto {

    private Long id;
    private String title;
    private String author;
    private String modDate;

    public PostsMainResDto(Posts entity) {

        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modDate = entity.getModDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }


}
