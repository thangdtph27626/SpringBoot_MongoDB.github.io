package com.telusko.joblisting.controller;

import com.telusko.joblisting.repository.PostRepository;
import com.telusko.joblisting.entity.Post;
import com.telusko.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController
{

    @Autowired
    PostRepository repo;


    @GetMapping("/allPosts")
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

}
