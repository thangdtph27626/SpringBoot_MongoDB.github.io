package com.thang.joblisting.service.impl;

import com.thang.joblisting.entity.Post;
import com.thang.joblisting.repository.PostRepository;
import com.thang.joblisting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public List<Post> getAllPosts() {
        return  repo.findAll();
    }

    @Override
    public Post addPost(Post post) {
        return repo.save(post);
    }
}
