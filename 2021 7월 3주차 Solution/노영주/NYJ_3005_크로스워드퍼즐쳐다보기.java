package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class NYJ_3005_크로스워드퍼즐쳐다보기 {
	static int R, C;
	static char[][] puzzle;
	static ArrayList<String> word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		puzzle = new char[R][C];

		for (int r = 0; r < R; r++) {
			puzzle[r] = br.readLine().toCharArray();
		}

		word = new ArrayList<String>();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (puzzle[r][c] != '#') {
					if (r == 0) {
						verticalWatching(r, c);
					}
					if(c==0) {
						horizonWatching(r, c);
					}
					if (r >= 1) {
						if (puzzle[r - 1][c] == '#') {
							verticalWatching(r, c);
						}
					}
					if (c >= 1) {
						if (puzzle[r][c - 1] == '#') {
							horizonWatching(r, c);
						}
					}
				}
			}
		}
		Collections.sort(word);
		System.out.println(word.get(0));

	}

	static void verticalWatching(int r, int c) {
		// 세로
		int verticalR = r + 1;
		String verticalString = String.valueOf(puzzle[r][c]);
		while (verticalR < R) {
			if (puzzle[verticalR][c] != '#') {
				verticalString = verticalString + puzzle[verticalR][c];
				verticalR += 1;
			} else {
				break;
			}
		}
		if (verticalString.length() >= 2) {
			word.add(verticalString);
		}
//		System.out.println("verticalString: "+verticalString);
	}

	static void horizonWatching(int r, int c) {
		// 가로
		int horizonC = c+ 1;
		String horizonString = String.valueOf(puzzle[r][c]);
		while (horizonC < C) {
			if (puzzle[r][horizonC] != '#') {
				horizonString = horizonString + puzzle[r][horizonC];
				horizonC+= 1;
			} else {
				break;
			}
		}
		if (horizonString.length() >= 2) {
			word.add(horizonString);
		}
//		System.out.println("horizonString: "+horizonString);

	}
}
