import java.util.Scanner;

public class PInfix {

	public void run() {
		Scanner sc = new Scanner(System.in);
		String[] arr_sik = new String[100]; // 배열 미리 생성
		int j = 0;
		while(true) {
			System.out.println("수식을 입력해주세요. = 을 입력할 시 결과가 출력됩니다.");
			String input = sc.nextLine().trim(); // 맨 앞, 맨 뒤 공백 제거
			String[] arr_input = input.split("[ \t]+");
			for(int i = 0; i < arr_input.length; i++) {
				arr_sik[j] = arr_input[i];
				j++;
			}
			if(arr_sik[j-1].contains("=")) {
				break;
			}
		}
		VInfix vInfix = new VInfix();
		vInfix.setInfix(arr_sik);
		vInfix.setCount(j-1);
		
		CInfix cInfix = new CInfix();
		VResult vResult = cInfix.Infix(vInfix);
		
		System.out.println("결과 : " + vResult.getResult2());

	}

}
