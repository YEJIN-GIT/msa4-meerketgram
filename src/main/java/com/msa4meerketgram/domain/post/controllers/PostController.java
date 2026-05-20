package com.msa4meerketgram.domain.post.controllers;

import com.msa4meerketgram.domain.post.requests.PostIndexReq;
import com.msa4meerketgram.domain.post.responses.PostIndexRes;
import com.msa4meerketgram.domain.post.services.PostService;
import com.msa4meerketgram.global.Response.GlobalRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<GlobalRes<PostIndexRes>> index(PostIndexReq postIndexReq) {
        PostIndexRes postIndexRes = postService.index(postIndexReq);

        // return String.format("page: %d, limit: %d", req.page(), req.limit());
        return ResponseEntity.status(200).body(
                GlobalRes.<PostIndexRes>builder()
                        .code("00")
                        .message("정상처리")
                        .data(postIndexRes)
                        .build()
        );
    }
}
