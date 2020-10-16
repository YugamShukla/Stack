package stacks;
import java.util.Stack;
public class InfixToPreFix {
    //define the precednce of each operator
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        //precedence of  an operand is always -1
        return -1;
    }
    //rules for same precedence of prefix expressions
    //if associativity is from left to right then push into the stack
    //if associativity is from right to left then pop and check untill lower precednce is left in stack and then push the char

    static StringBuilder infixToPreFix(String expression){
        //we take expression input for infix
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();
        //creating a chracter array out of the given string so as to apply manipulations in it
        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {
            //Convert opening bracket to closing and closing to opening
            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){//this checks if c is opertor
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    //if the stack is not empty and precence of c is less than top element pop the top until top is higher
                    result.append(stack.pop());
                }
                stack.push(c);//if precedence of c is higher than that of top then push it into the stack
            }
            //if c is the closing bracket 
            else if(c==')'){
                char x = stack.pop();
                while(x!='('){//pop the stack untill opening bracket corresponding to the closing is achieved
                    result.append(x);
                    x = stack.pop();
                }
            }
            
            else if(c=='('){//always push the opening bracket into the stack
                stack.push(c);
            }
            
            else{
                //character is neither operator nor "("
                result.append(c);
            }
        }
        //pop all the remaining elemnts of the stack
        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        //again reverse the stack
        return result.reverse();
    }

    public static void main(String[] args) {
        String exp = "(A+B)*(C^D-E)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPreFix(exp));
    }
}
