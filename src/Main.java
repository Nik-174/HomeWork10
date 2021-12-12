
import java.util.Scanner;

public class Main  {
    public static User[] getUsers() {
        User user1 = new User("ivan", "ivan@rambler.com", "123", 33);
        User user2 = new User("petr", "petr2@yandex.com", "123", 22);
        User user3 = new User("masha", "masha@mail.com", "123", 15);
        return new User[]{user1,user2,user3};
    }

    public static void main(String[] args) throws AccessDeniedException, UserNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUser(login, password);
        validateUser(user);
    }

    public static User getUser(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Вам нет 18 лет. Доступ запрещён.");
        } else {
            System.out.println("Доступ разрешён.");
        }
    }
}




