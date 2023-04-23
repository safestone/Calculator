import java.io.IOException;
import java.util.Scanner;

public class Main {

	private void run() {
		try {
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("1. infix 계산기 2. prefix 계산기 3.종료");
				int answer = sc.nextInt();
				if(answer == 1) {
					PInfix pInfix = new PInfix();
					pInfix.run();
				} else if (answer == 2) {
					PPrefix pPrefix = new PPrefix();
					pPrefix.run();
				} else if (answer == 3) {
					System.exit(0);
				} else {
					System.out.println("잘 못 입력하셨습니다.");
					throw new IOException();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}



}
