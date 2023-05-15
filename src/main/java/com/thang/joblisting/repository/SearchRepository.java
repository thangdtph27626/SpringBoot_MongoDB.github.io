package com.telusko.joblisting.repository;

import com.telusko.joblisting.entity.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);

}
