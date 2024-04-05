package com.itwill.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain04 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("java", "sql", "html", "css", "javascript",
                "servlet", "jsp", "spring");
        
        // 1. names에서 5글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        // -> [JAVASCRIPT, SERVLET, SPRING]
		ArrayList<String> x = new ArrayList<>();
		
		for (String s : names) {
			if (s.length() >= 5) {
				x.add(s.toUpperCase());
				}
		}
		
		System.out.println(x);

		
        // 2. names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        // -> [4, 3, 4, 3, 10, 7, 3, 6]
		ArrayList<Integer> y = new ArrayList<>();
		
		for (String s : names) {
			y.add(s.length());
		}
        System.out.println(y);
		
        // 3. codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력
        List<Integer> codes = Arrays.asList(0, 1, 0, 1, 1, 0);
        
        ArrayList<String> i = new ArrayList<>();
        for(Integer j : codes) {
        	if (j == 0) {
        		i.add("남성");
        	} i.add("여성");
        }
        System.out.println(i);
        
	}

}
