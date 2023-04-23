import java.util.Stack;

public class MPrefix {

    public VResult Prefix(VPrefix vPrefix) {
        int j = vPrefix.getCount() - 1; // 배열의 마지막 인덱스에서 1을 뺀 값
        int num1;
        int num2;
        String[] prefixArray = vPrefix.getPrefix();
        Stack<String> stack = new Stack<>();

        for (; j >= 0; j--) {
            if (prefixArray[j].matches("^[0-9]*$")) {
                stack.push(prefixArray[j]);
            } else {
                num1 = Integer.parseInt(stack.peek());
                stack.pop();
                num2 = Integer.parseInt(stack.peek());
                stack.pop();

                switch (prefixArray[j]) {
                    case "+":
                        stack.push(Integer.toString(num1 + num2));
                        break;
                    case "-":
                        stack.push(Integer.toString(num1 - num2));
                        break;
                    case "*":
                        stack.push(Integer.toString(num1 * num2));
                        break;
                    case "/":
                        stack.push(Integer.toString(num1 / num2));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + prefixArray[j]);
                }
            }
        }

        VResult vResult = new VResult();
        vResult.setResult(Integer.parseInt(stack.peek()));
        return vResult;
    }
}
