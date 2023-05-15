package com.thang.joblisting.controller;

import com.thang.joblisting.repository.PostRepository;
import com.thang.joblisting.entity.Post;
import com.thang.joblisting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController
{

    @Autowired
    private PostService postService;


    @GetMapping("/allPosts")
    public List<Post> getAllPosts()
    {
        return postService.getAllPosts();
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return postService.addPost(post);
    }

}
