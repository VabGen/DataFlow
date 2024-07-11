package org.example.dataflow.services.impl;

import org.example.dataflow.controller.request.PostRequest;
import org.example.dataflow.dao.entity.Post;
import org.example.dataflow.dao.mapper.PostMapper;
import org.example.dataflow.dao.services.PostServiceDao;
import org.example.dataflow.dto.PostDto;
import org.example.dataflow.generation.thread.PostProcessThread;
import org.example.dataflow.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostServiceDao dao;
    private final PostProcessThread consumer;

    @Autowired
    public PostServiceImpl(PostServiceDao dao, PostProcessThread consumer) {
        this.dao = dao;
        this.consumer = consumer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDto> findAll() {
        List<Post> post = dao.findAll();
        return PostMapper.listEntityToDtoList(post);
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto findById(UUID id) {
        Post post = dao.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return PostMapper.entityToDto(post);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PostDto save(PostRequest request) {
        Post post = PostMapper.requestToEntity(request);
        return PostMapper.entityToDto(dao.save(post));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PostDto edit(PostRequest request) {
        Post post = PostMapper.requestToEntity(request);
        return PostMapper.entityToDto(dao.edit(post));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        dao.delete(id);
    }

    @Override
    public void generateAndSavePostRequests(int threadCount) {
        consumer.generateAndSavePostRequests(threadCount);
    }
}
