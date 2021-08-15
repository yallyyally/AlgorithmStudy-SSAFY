import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	static int N;
	static long res;
	static long[] arr;
	
//	문자를 스캔하면서 각 알파벳에 곱해야 할 수를 넣어준다
	public static void countAlphabet(char[] input) {
		long num = 1;
		for(int i = input.length - 1; i>=0; i--) {
			arr[(int)input[i] - 65] += num;
			num *= 10;
		}
	}
	
//	트리맵 쓰고 정렬하려고 했는데 너무 어려워서 실패쓰
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new long[26]; //각 글자(index)에 무엇을 곱해야 하는지(value) 저장

		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			countAlphabet(br.readLine().toCharArray());
		}
		Arrays.sort(arr);
		
//		가장 많이 나타난 알파벳 부터 순차적으로 9부터 부여.
		int idx = 25;
		int num = 9;
		while(idx != -1 && arr[idx] != 0) {
			res += arr[idx--] * num--;
		}
		
		System.out.println(res);
	}
}