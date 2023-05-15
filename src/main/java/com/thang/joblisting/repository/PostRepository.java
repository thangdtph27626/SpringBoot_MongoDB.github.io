package com.thang.joblisting.repository;

import com.thang.joblisting.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>
{

}
