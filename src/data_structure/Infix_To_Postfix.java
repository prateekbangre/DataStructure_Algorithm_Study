package data_structure;

import java.util.Stack;

/**
 * @author prateek.bangre on 23/05/21.
 * @Project Algorithm_Study
 */
public class Infix_To_Postfix {

    // A utility function to return precedence of a given operator Higher returned value means higher precedence
    static int prec(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static String infixToPostfix(String exp) {

        StringBuilder result = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(ch)){
                result.append(ch);

            // If the scanned character is an '(', push it to the stack.
            }else if(ch == '('){
                stack.push(ch);

            //If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
            }else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }else { // an operator is encountered
                while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }


    public static void main(String[] args) {
//        String exp = "(A+B)*(C-D)"; //AB+CD-
        String exp = "a+b*(c^d-e)^(f+g*h)-i";   //abcd^e-fgh*+^*+i-
        System.out.println(infixToPostfix(exp));
    }
}
