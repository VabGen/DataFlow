import java.util.function.Function;

public class DataApplication {

    public static void main(String[] args) {
        UserBuilder userBuilder = User::new;
        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
    }
}

interface UserBuilder {
    User create(String name);
}

class User {

    private String name;

    User(String n) {
        this.name = n;
    }

    String getName() {
        return name;
    }
}

