package org.example.dataflow.controller;

import jakarta.validation.Valid;
import org.example.dataflow.controller.request.PostRequest;
import org.example.dataflow.dto.PostDto;
import org.example.dataflow.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getCollection() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PostDto> post(@RequestBody PostRequest request) {
        PostDto postDto = postService.save(request);
        return ResponseEntity.ok(postDto);
    }

    @PutMapping
    public ResponseEntity<PostDto> put(@RequestBody PostRequest request) {
        PostDto postDto = postService.edit(request);
        return ResponseEntity.ok(postDto);
    }

    @PostMapping(value = "/generate")
    public ResponseEntity<?> post() {
        postService.generateAndSavePostRequests(5);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<PostDto> deleteList(@PathVariable("id") UUID postId) {
        postService.delete(postId);
        return ResponseEntity.noContent().build();
    }
}
