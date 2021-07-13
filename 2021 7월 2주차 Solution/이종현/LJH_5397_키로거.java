import java.io.*;
import java.util.*;

public class boj_5397_키로거 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            String str = br.readLine();

            Stack<Character> left = new Stack<Character>();
            Stack<Character> right = new Stack<Character>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '<') {
                    if (!left.isEmpty())
                        right.push(left.pop());
                } else if (ch == '>') {
                    if (!right.isEmpty())
                        left.push(right.pop());
                } else if (ch == '-') {
                    if (!left.isEmpty())
                        left.pop();
                } else {
                    left.push(ch);
                }
            }

            String result = "";

            for (Character character : left) {
                result += character;
            }

            while (!right.isEmpty()) {
                result += right.pop();
            }
            System.out.println("commit test");
            System.out.println(result);
        }

    }

}
