import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static int N;
	static ArrayList<Alpha> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Alpha>();
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			int length = temp.length();
			int index=0;
			while(length>0) {
				char current = temp.charAt(index++);
				int size = list.size();
				boolean flag=false;
				for(int s=0;s<size;s++) {
					Alpha now = list.get(s);
					if(now.alpha==current) {
						int fix = now.num+(int)Math.pow(10, length-1);
						list.set(s, new Alpha(current,fix));
						flag=true;
					}
				}
				if(!flag)
					list.add(new Alpha(current,(int)Math.pow(10, length-1)));
				length--;
			}
		}
		
		Collections.sort(list, new Comparator<Alpha>() {

			public int compare(Alpha o1, Alpha o2) {
				if(o1.num>o2.num)
					return -1;
				else if(o1.num<o2.num)
					return 1;
				else 
					return 0;
			}
		});
		
		int size = list.size();
		int num=9;
		int ans =0;
		
		for(int s=0;s<size;s++) {
			Alpha current = list.get(s);
			ans+=current.num*(num--);
		}
		
		System.out.println(ans);
		
	}
	static class Alpha{
		char alpha;
		int num;
		public Alpha(char alpha, int num) {
			super();
			this.alpha = alpha;
			this.num = num;
		}
		
	}

}