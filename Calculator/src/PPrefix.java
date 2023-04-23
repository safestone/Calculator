import java.util.Scanner;

public class PPrefix {
	public void run() {
			Scanner sc = new Scanner(System.in);
			int j = 0;
			String input;
			String[] arr_sik = new String[100]; // 배열 미리 생성
			while(true) {
				System.out.println("수식을 입력해주세요. = 을 입력할 시 결과가 출력됩니다.");
				System.out.println("숫자와 연산자 사이를 띄워주세요.");
				input = sc.nextLine().trim(); // 맨 앞, 맨 뒤 공백 제거
				String[] arr_input = input.split("[ \t]+");
				for(int i = 0; i < arr_input.length; i++) {
					arr_sik[j] = arr_input[i];
					j++;
				}
				if(arr_sik[j-1].contains("=")) {
					break;
				}
			}
			VPrefix vPrefix = new VPrefix();
			vPrefix.setPrefix(arr_sik);
			vPrefix.setCount(j-1);
				
			CPrefix cPrefix = new CPrefix();
			VResult vResult = cPrefix.prefix(vPrefix);
			
			System.out.println("결과 : " + vResult.getResult());
		}		
	}


