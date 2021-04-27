import java.util.*;

public class EX4_3 {
    public static void main(String[] args) {
        int cnt = 0;
        boolean[] check;
        Scanner sc = new Scanner(System.in);
        StringBuilder problem = new StringBuilder();
        System.out.print("출제할 단어를 적으세요:");
        String word = sc.nextLine();
        check = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++)
            problem.append('_');
        System.out.println(word.length() + "글자 입니다");
        while (cnt != word.length()) {
            System.out.println("현재의 상태:" + problem.toString());
            boolean flag = false;
            char input;
            input = sc.nextLine().charAt(0);
            for (int i = 0; i < word.length(); i++)
                if (word.charAt(i) == input && !check[i]) {
                    System.out.println("맞췄습니다!");
                    problem.setCharAt(i, input);
                    cnt++;
                    check[i] = true;
                    flag = true;
                }
            if (!flag)
                System.out.println("틀렸습니다..");
        }
        System.out.println("현재의 상태:" + problem.toString());
        System.out.println("정답입니다!!");
        sc.close();
    }
}
