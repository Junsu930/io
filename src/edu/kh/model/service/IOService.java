package edu.kh.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {
	
	// IO
	
	// Input (입력)  : 외부 -> 내부로 데이터를 들여오는 것
	// Output (출력) : 내부 -> 외부로 데이터를 내보내는 것
	
	// Stream : 입/출력 통로 역할(데이터가 흘러가는 통로)
	//			기본적으로 Stream은 단방향
	
	// 1) 파일 출력 (내부 == 프로그램, 외부는 파일)
	public void output1() {
		
		FileOutputStream fos = null;
		// 바이트 기반
		
		//FileOutputStream fos = new FileOutputStream("test1.txt");
		// Unhandled exception type FileNotFoundException 
		// = FileOutputStream 객체 생성 시
		// FileNotFoundException 예외가 발생할 수 있어 -> 예외 처리가 필요하다
		
		try {
			fos = new FileOutputStream("test1.txt");
			// 현재 프로그램에서
			// test1.txt 파일로 출력하는 통로 객체 생성
			
			// 이 파일은 목적지가 필요함
			// -> 12_IO 지금 해당된 프로젝트 폴더가
			// 기본 목적지로 설정되어있음
			
			// 파일에 "Hello" 내보내기
			String str = "Hello";
			
			for(int i = 0; i< str.length(); i++) {
				
				// "Hello"를 한 문자씩 끊어서 파일로 출력
				fos.write( str.charAt(i));
				// Unhandled IOException
				// writer()는 IOException을 발생시킬 가능성이 있다. 
			}
			
		}catch(IOException e){
			// FileNotFoundException은 IOException의 자식
			// 다형성 적용으로 IOException 하나로 둘 다 잡을 수 있다. 
			
			System.out.println("예외 발생");
			e.printStackTrace();
			// 예외 추적
		}
		finally {
			// 예외가 발생 하든말든 무조건 수행
			
			// 쓸데 없는 통로 지우기!
			// -> 자원 반환 
			// 사용한 스트림 자원 반환 ( 통로 없앰 ) -> 필수 작성 !!
			// 프로그램 메모리 관리 차원에서 항상 다 쓰면 끊어줌
			// -> 작성 안 하면 문제점으로 꼽을 수 있음.
			
			try {
				// IOEception 발생하여
				// try-catch구문
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void input1() {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test1.txt");
			
			// FileInputStream은 1바이트씩만 읽어옴
			while(true) {
				
				int data = fis.read(); // 다음 1byte를 읽어오는데 정수형 
									   // 다음 내용이 없으면 -1을 반환
				
				if(data == -1) { // 다음 내용이 없으면 => 종료
					break;
				}
				// 반복 종료가 안됐으면 char로 강제 형변환하여 문자로 출력
				System.out.print( (char)data );
			}
			
		}catch(IOException e) {
			System.out.println("예외 발생");
		}
		finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// --------------------------
	
	// 문자 기반 스트림 
	
	// 3) 파일 출력 ( 문자 기반 스트림 )
	public void output2() {
		
		FileWriter fw = null; // 프로그램 -> 파일로 쓰는 문자 기반 스트림
		
		try {
			fw = new FileWriter("test1.txt",true); // 외부 파일과 연결하는 스트림 객체 생성
			//매개변수에 true 같이 전달하면 이어쓰기 가능
			String str = "안녕하시렵니까. hello. 으아악!@!#";
			
			fw.write(str);
			
		}catch(IOException e){
			
			System.out.println("예외 발생");
			e.printStackTrace();
			
		}finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void input2() {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("test1.txt");
			
			while(true) {
				int data = fr.read();
				
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
		}catch(IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void outputjs() {
		
		FileWriter out = null;
		
		try {
			out = new FileWriter("test1.txt");
			
			String str = "으아아 비상사태!";
			
			out.write(str);
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void inputjs() {
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("test1.txt");
			
			while(true) {
				int data;
				data = fis.read();
				if(data == -1) {
					break;
				}
				
				System.out.print((char)data);
			}
			
		}catch(IOException e){
			System.out.println("예외 발생");
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
