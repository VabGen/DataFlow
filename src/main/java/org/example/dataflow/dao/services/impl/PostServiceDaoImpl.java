package org.example.dataflow.dao.services.impl;

import org.example.dataflow.dao.entity.Post;
import org.example.dataflow.dao.repository.PostRepository;
import org.example.dataflow.dao.services.PostServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceDaoImpl implements PostServiceDao {

    private final PostRepository repository;

    @Autowired
    public PostServiceDaoImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Post> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Post edit(Post post) {
        return repository.save(post);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
