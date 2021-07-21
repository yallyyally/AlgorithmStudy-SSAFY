import java.util.*;
import java.io.*;

public class 백준_3005_크로스워드퍼즐쳐다보기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String tmp = sc.next();
			for(int j=0;j<C;j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		ArrayList<String> word = new ArrayList<>();
		for(int i=0;i<R;i++) {
			String tmp = "";
			for(int j=0;j<C;j++) {
				if(map[i][j] == '#') {
					if(tmp.length() >= 2)
						word.add(tmp);
					tmp = "";
				}
				else
					tmp += map[i][j];
			}
			
			if(tmp.length() >= 2)
				word.add(tmp);
		}
		
		for(int j=0;j<C;j++) {
			String tmp = "";
			for(int i=0;i<R;i++) {
				if(map[i][j] == '#') {
					if(tmp.length() >= 2)
						word.add(tmp);
					tmp = "";
				}
				else
					tmp += map[i][j];
			}
			
			if(tmp.length() >= 2)
				word.add(tmp);
		}
		
		Collections.sort(word);
		System.out.println(word.get(0));
	}

}
