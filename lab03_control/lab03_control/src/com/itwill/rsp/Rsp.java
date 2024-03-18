package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // TODO: Random 타입 변수를 선언, 초기화.
    	Random r = new Random();
    	
        // TODO: Scanner 타입 변수를 선언, 초기화.
    	Scanner sc = new Scanner(System.in);

        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // TODO: 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장.
        int user = sc.nextInt();
       System.out.println("user: " + user);
        // TODO: 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
        int com = r.nextInt(0, 3);
        System.out.println("com: " + com);
        // TODO: 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.        
        if (com == 0 && user == 0) {
        	System.out.println("Tie");
            } else if(com == 0 && user == 1) {
        	System.out.println("User win");
        } else if(com == 0 && user == 2) {
        	System.out.println("Computer win");
        } else if (com == 1 && user == 1) {
        	System.out.println("Tie");
        } else if (com == 1 && user == 2) {
        	System.out.println("User win");
        } else if (com == 1 && user == 0){
        	System.out.println("Computer win");
        	} else if(com == 2 && user == 2) {
        		System.out.println("Tie");
        	} else if(com == 2 && user == 0) {
        		System.out.println("User win");
        	} else if(com == 2 && user == 1){
        		System.out.println("Computer win");
        	}


}
}
