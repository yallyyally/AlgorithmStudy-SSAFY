import java.util.Scanner;

public class 백준_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=0;t<TC;t++) {
			int cnt = sc.nextInt();
			int[][] map = new int[cnt+2][2];
			int[][] arr = new int[cnt+2][cnt+2];
			
			for(int i=0;i<cnt+2;i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			for(int i=0;i<cnt+2;i++) {
				for(int j=0;j<cnt+2;j++) {
					if(Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]) <= 1000)
						arr[i][j] = 1;
				}
			}

			for(int k=0;k<cnt+2;k++)
				for(int i=0;i<cnt+2;i++)
					for(int j=0;j<cnt+2;j++)
						if(arr[i][k] == 1 && arr[k][j] == 1)
							arr[i][j] = 1;
			
			if(arr[0][cnt+1] == 1)
				System.out.println("happy");
			else
				System.out.println("sad");
	
		}
	}

}
