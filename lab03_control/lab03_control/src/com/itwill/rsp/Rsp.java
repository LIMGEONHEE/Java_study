package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // Random 타입 변수를 선언, 초기화.
    	Random r = new Random(); 
    	
        // Scanner 타입 변수를 선언, 초기화.
    	Scanner sc = new Scanner(System.in);

        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장.
        int user = sc.nextInt();
       System.out.println("user: " + user);
       
        // 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
        int com = r.nextInt(0, 3);
        System.out.println("com: " + com);
        
        // 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.   
        
        /* (1) if-else if 방법
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
            } else if (com == 1 && user == 0) {
        	System.out.println("Computer win");
        	} else if(com == 2 && user == 2) {
        		System.out.println("Tie");
        	} else if(com == 2 && user == 0) {
        		System.out.println("User win");
        	} else if(com == 2 && user == 1) {
        		System.out.println("Computer win");
        	}
 			*/ 
        
        /* (2)if-else if-else 방법
        if (user == 0) { //  user: 가위
        	 if (com == 0) {
        		 System.out.println("Tie");
        	 } else if (com == 1) {
        		 System.out.println("User win");
        	 } else {
        		 System.out.println("Computer win");
        	 }
         } else if (user ==1) { // user: 바위
        	 if (com == 0) {
        		 System.out.println("User win");
        	 } else if (com == 1) {
        		 System.out.println("Tie");
        	 } else {
        		 System.out.println("Computer win");
        	 }
         } else { // user: 보
        	 if (com == 0) {
        		 System.out.println("Computer win");
        	 } else if (com == 1) {
        		 System.out.println("User win");
        	 } else {
        		 System.out.println("Tie");
        	 }
         }
         */
        
        /* (3)비긴 경우의 수 빼기
         if (user == com) { // 비김
        	System.out.println("Tie");
        } else if(user == 0) {
        	if(com == 1) {
        		System.out.println("User win");
        	} else {
        		System.out.println("Computer win");
        	}
        } else if(user == 1) {
        	if(com ==0) {
        		System.out.println("User win");
        	} else {
        		System.out.println("Computer win");
        	}
        } else {
        	if(com == 0) {
        		System.out.println("Computer win");
        	} else(com == 1) {
        		System.out.println("User win");
        	}
        }
         */
        
        /* (4)비긴 경우의 수 빼기(간단)
        if(user == com) { //비김
        	System.out.println("Tie");
        } else if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
        	// user가 이긴 경우
        	System.out.println("User win");
        } else {
        	// computer가 이긴 경우
        	System.out.println("Computer win");
        }
        */
        
        /* 각자 부여된 숫자를 뺀 값으로 계산
        int result = user - com;
        if (result == 0) {
        	System.out.println("Tie");
        } else if (result == 1 || result == -2) {
        	System.out.println("User win");
        } else {
        	System.out.println("Computer win");
        }
        */
        
    }
}
