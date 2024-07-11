package org.example.dataflow.dao.mapper;

import org.example.dataflow.controller.request.PostRequest;
import org.example.dataflow.dao.entity.Post;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dao.model.filter.PostFilter;
import org.example.dataflow.dto.PostDto;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto entityToDto(Post source) {
        if (source == null) {
            return null;
        }

        return new PostDto()
                .setPostName(source.getPostName())
                .setCode(source.getCode());
    }

    public static Post requestToEntity(Post target, PostRequest request) {
        return target.setPostName(request.getPostName())
                .setCode(request.getCode());
    }

    public static Post requestToEntity(PostRequest request) {
        if (request == null) {
            return null;
        }

        return requestToEntity(new Post(), request);
    }

    public static List<PostDto> listEntityToDtoList(List<Post> source) {
        if (source == null) {
            return null;
        }

        return source.stream().map(PostMapper::entityToDto).collect(Collectors.toList());
    }

    public static PostDto entityToDto(Post post, PostFilter.Include... includes) {
        PostDto dto = entityToDto(post);
        for (PostFilter.Include type : includes) {
            switch (type) {
                case EMPLOYEE -> dto.setEmployees(EmployeeMapper.listEntityToDtoList(post.getEmployees()));
            }
        }

        return dto;
    }
}
