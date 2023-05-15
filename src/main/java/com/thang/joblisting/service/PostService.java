package com.thang.joblisting.service;

import com.thang.joblisting.entity.Post;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post addPost(@RequestBody Post post);

}
