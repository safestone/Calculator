import java.util.Stack;

public class MInfix {

	public VResult Infix(VInfix vInfix) {
		int j = vInfix.getCount() - 1;
        String[] infixArray = vInfix.getInfix();
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
        
        for (int i = 0; i <= j; i++) {
        	if(infixArray[i].equals("(")) {
        		continue;
        	} else if(infixArray[i].matches("^[0-9]*$")) {
        		operands.push(Double.parseDouble(infixArray[i]));
        	} else if (infixArray[i].matches("[+\\-*/]")) {
        		operators.push(infixArray[i]);
        	} else if (infixArray[i].equals(")")) {
        		double num1 = operands.pop();
                double num2 = operands.pop();
                String operator = operators.pop();
                switch (operator) {
                    case "+":
                        operands.push(num2 + num1);
                        break;
                    case "-":
                        operands.push(num2 - num1);
                        break;
                    case "*":
                        operands.push(num2 * num1);
                        break;
                    case "/":
                        operands.push(num2 / num1);
                        break;
                }
        	}
        }
        
        
        VResult vResult = new VResult();
        vResult.setResult2(operands.peek());
		
        return vResult;
		
	}

}
