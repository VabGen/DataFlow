package org.example.dataflow.dao.services;

import org.example.dataflow.dao.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostServiceDao {

    List<Post> findAll();

    Optional<Post> findById(UUID id);

    Post save(Post post);

    Post edit(Post post);

    void delete(UUID id);
}
