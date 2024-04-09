package com.itwill.file05;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args) {
		// 파일에 쓸(write) 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(new Product(i, "name_" + i, i));
		}
		System.out.println("size = " + list.size());
		
		// ArrayList를 저장하는 파일 이름
		String fileName = "data/product_list.dat";
		
		// 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일 쓰기
		// FOS, BOS, OOS을 이용.
		
		try (
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				) {
			oos.writeObject(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		// 2. 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기
		// FIS, BIS, OIS을 이용.
		try (
				FileInputStream out = new FileInputStream(fileName);
				BufferedInputStream bos = new BufferedInputStream(out);
				ObjectInputStream oos = new ObjectInputStream(bos);
				) {
			ArrayList<Product> pr = (ArrayList<Product>)oos.readObject();
//			for(Product p : pr) {
//				System.out.println(p);
//			}			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
