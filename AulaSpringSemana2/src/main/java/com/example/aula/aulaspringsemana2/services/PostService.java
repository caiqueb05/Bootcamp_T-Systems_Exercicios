package com.example.aula.aulaspringsemana2.services;

import com.example.aula.aulaspringsemana2.models.PostModel;
import com.example.aula.aulaspringsemana2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

//    public List<PostModel> getPostByViewsGreatherThan(Integer views) {
//        return postRepository.findByViewsGreaterThan(views);
//    }
//
//    public List<PostModel> getPostByViewsLessThan(Integer views) {
//        return postRepository.findByViewsLessThan(views);
//    }
//
//    public List<PostModel> getAllPosts() {
//        return postRepository.findAll();
//    }

    public List<PostModel> getPosts(Specification<PostModel> spec) {
        return postRepository.findAll(spec);
    }

    public List<PostModel> getPosts(Specification<PostModel> spec, int start, int end) {
        return postRepository.findAll(spec);
    }

//    public List<PostModel> getPosts(Specification<PostModel> spec, int start, int limit) {
//        return postRepository.findAll(spec);
//    }
}
