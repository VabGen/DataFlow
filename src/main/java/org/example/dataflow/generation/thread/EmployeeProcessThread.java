package org.example.dataflow.generation.thread;

import org.example.dataflow.controller.request.EmployeeRequest;
import org.example.dataflow.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class EmployeeProcessThread implements Runnable {

    private final String[] FIRST_NAMES = {"John", "Jane", "Bob", "Alice", "Tom", "Emma"};
    private final String[] MIDDLE_NAMES = {"Smith", "Doe", "Johnson", "Brown", "Taylor", "Miller"};
    private final String[] LAST_NAMES = {"Williams", "Jones", "Davis", "Clark", "Rodriguez", "Martinez"};
    private final String[] ADDRESSES = {"Street 1", "Street 2", "Street 3", "Street 4"};
    private final String[] EMAILS = {"email1@example.com", "email2@example.com", "email3@example.com"};

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeProcessThread(@Lazy EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run() {
//        employeeService.generateAndSaveEmployeeRequests(100, 5);
    }

    private EmployeeRequest generateRandomEmployeeRequest() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String middleName = MIDDLE_NAMES[random.nextInt(MIDDLE_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        String address = ADDRESSES[random.nextInt(ADDRESSES.length)];
        String email = EMAILS[random.nextInt(EMAILS.length)];
        int phone = random.nextInt(100);
        int passport = random.nextInt(100);
        UUID postId = UUID.randomUUID();

        return new EmployeeRequest()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setAddress(address)
                .setEmail(email)
                .setPhone(phone)
                .setPostId(postId)
                .setPassport(passport);
    }

    public void generateAndSaveEmployeeRequests(int count, int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        IntStream.range(0, count).forEach(i -> executor.submit(() -> {
            EmployeeRequest request = generateRandomEmployeeRequest();
            employeeService.save(request);
        }));

        executor.shutdown();
    }
}
