package stacks;
import java.util.Stack;


class ParenthesisChecker{
     public static boolean isBalancedParenthesis(String expn) {
          Stack<Character> stk = new Stack<Character>();
          char[] array= expn.toCharArray();
          for (char ch=0;ch<array.length;ch++) {
              switch (ch) {
              case '{':
              case '[':
              case '(':
                  stk.push(ch);
                  break;
              case '}':
                  if (stk.pop() != '{') {
                      return false;
                  }
                  break;
              case ']':
                  if (stk.pop() != '[') {
                      return false;
                  }
                  break;
              case ')':
                  if (stk.pop() != '(') {
                      return false;
                  }
                  break;
              }
          }
          return stk.isEmpty();
     }
     
      public static void main(String[] args) {
          String expn = "{()}[]";
          boolean value = isBalancedParenthesis(expn);
          System.out.println("Given Expn:" + expn);
          System.out.println("Result after isParenthesisMatched:" + value);
     }

}

