package com.telusko.joblisting.repository;

import com.telusko.joblisting.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>
{

}
