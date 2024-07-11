package org.example.dataflow.services;

import org.example.dataflow.controller.request.PostRequest;
import org.example.dataflow.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(UUID id);

    PostDto save(PostRequest request);

    PostDto edit(PostRequest request);

    void delete(UUID id);

    void generateAndSavePostRequests(int threadCount);
}
