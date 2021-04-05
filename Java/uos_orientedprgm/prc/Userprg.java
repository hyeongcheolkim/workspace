import java.util.*;

public class Userprg {

    public static void main(String[] args) {
        final int users_SIZE = 5;
        Scanner sc = new Scanner(System.in);
        User[] users = new User[users_SIZE];
        while (true) {
            int select;
            String userid;
            String password;
            System.out.println("===========MENU==========");
            System.out.println("1.Register new user");
            System.out.println("2.Login");
            System.out.println("3.User list");
            System.out.println("4.exit");
            System.out.println("=========================");
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
            case 1:
                if (User.count == users_SIZE) {
                    System.out.println("더이상 유저를 등록할 수 없습니다.");
                    break;
                }
                while (true) {
                    boolean flagid = true;
                    System.out.print("아이디를 입력하세요:");
                    userid = sc.nextLine();
                    for (int i = 0; i < User.count; i++)
                        if (users[i].getuserid().equals(userid))
                        {
                            System.out.println("중복된 아이디입니다. 다시입력하세요");
                            flagid = false;
                        }
                    if(flagid)
                        break;
                    else
                        continue;
                }
                System.out.print("비밀번호를 입력하세요:");
                password = sc.nextLine();
                users[User.count] = new User(userid, password);
                break;
            case 2:
                boolean flag = false;
                System.out.print("아이디를 입력하세요:");
                userid = sc.nextLine();
                System.out.print("비밀번호를 입력하세요:");
                password = sc.nextLine();
                for (int i = 0; i < User.count; i++)
                    if (users[i].getuserid().equals(userid) && users[i].getpassword().equals(password)) {
                        flag = true;
                        break;
                    }
                if (flag)
                    System.out.println("로그인되었습니다.");
                else
                    System.out.println("user정보가 일치하지 않습니다.");
                break;
            case 3:
                System.out.println(">>=======userlist======<<");
                for (int i = 0; i < User.count; i++)
                    System.out.println((i + 1) + ". " + users[i].getuserid());
                System.out.println(">>=========end=========<<");
                break;
            case 4:
                System.out.print("종료합니다.");
                sc.close();
                System.exit(0);
            default:
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }
}

class User {
    private String userid, password;
    static int count = 0;

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
        count++;
    }

    public String getuserid() {
        return this.userid;
    }

    public String getpassword() {
        return this.password;
    }
}
