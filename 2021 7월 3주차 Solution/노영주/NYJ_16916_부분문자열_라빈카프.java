package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//라빈카프
public class NYJ_16916_부분문자열_라빈카프 {
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String substring = br.readLine();
		ans = 0;
		labinKarp(origin, substring);
		System.out.println(ans);
	}

	static int makeHash(String string, int len) {
		int hash = 0;
		int power = 1;

		for (int i = len - 1; i >= 0; i--) {

			hash += string.charAt(i) * power;
			power *= 2;
		}

		return hash;
	}

	static void labinKarp(String origin, String sub) {
		int originSize = origin.length();
		int subSize = sub.length();

		if (subSize > originSize)
			return;

		int originHash = makeHash(origin, subSize);
		int subHash = makeHash(sub, subSize);
		int power = 1 << (subSize - 1);

		for (int i = 1; i <= originSize - subSize; i++) {
			int preRemove = origin.charAt(i-1)*power;
			int posAppend = origin.charAt(i-1+subSize);
			originHash= 2*(originHash-preRemove)+posAppend;
			
			if (originHash == subHash) {
				// 해시 충돌을 위한 로직
				if (sub.equals(origin.substring(i, i + subSize))) {
					ans = 1;
					break;
				}
			}
		}
	}
}
