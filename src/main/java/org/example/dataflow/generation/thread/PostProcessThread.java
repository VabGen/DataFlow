package org.example.dataflow.generation.thread;

import org.example.dataflow.controller.request.PostRequest;
import org.example.dataflow.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class PostProcessThread implements Runnable {

    private final String[] POST_NAME = {
            "Software Developer",
            "Web Developer",
            "Mobile Developer",
            "Data Scientist",
            "Machine Learning Engineer",
            "System Administrator",
            "Database Administrator",
            "Network Engineer",
            "Security Specialist",
            "Cloud Engineer",
            "DevOps Engineer",
            "UX/UI Designer",
            "IT Project Manager",
            "IT Analyst",
            "Technical Writer"
    };

    private final PostService postService;
    private final Map<String, Integer> postNameToCodeMap = new HashMap<>();

    @Autowired
    public PostProcessThread(@Lazy PostService postService) {
        this.postService = postService;
    }

    @Override
    public void run() {
    }

    private PostRequest generateRandomPostRequest() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        String postName = null;
        int code = 0;
        try {
            if (postNameToCodeMap.size() < POST_NAME.length) {
                do {
                    int index = random.nextInt(POST_NAME.length + 1);
                    postName = POST_NAME[index];
                    code = index;
                } while (postNameToCodeMap.containsKey(postName));

                postNameToCodeMap.put(postName, code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PostRequest()
                .setPostName(postName)
                .setCode(code);
    }

    public void generateAndSavePostRequests(int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int count = POST_NAME.length + 1;

        IntStream.range(0, count).forEach(i -> executor.submit(() -> {
            PostRequest request = generateRandomPostRequest();
            postService.save(request);
        }));

        executor.shutdown();
    }
}
