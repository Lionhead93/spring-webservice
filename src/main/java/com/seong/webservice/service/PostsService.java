package com.seong.webservice.service;

import com.seong.webservice.dto.PostsMainResDto;
import com.seong.webservice.dto.PostsSaveReqDto;
import com.seong.webservice.repo.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveReqDto dto) {
        postsRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<PostsMainResDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResDto::new)
                .collect(Collectors.toList());
    }

}
