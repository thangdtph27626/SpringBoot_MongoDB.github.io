package com.thang.joblisting.repository;

import com.thang.joblisting.entity.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);

}
