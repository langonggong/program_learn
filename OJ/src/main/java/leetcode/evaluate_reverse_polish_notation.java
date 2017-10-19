package leetcode;

import java.text.NumberFormat;
import java.util.Stack;

/**
 * @author lanxu
 * @url https://www.nowcoder.com/practice/22f9d7dd89374b6c8289e44237c70447?tpId=46&tqId=29031&rp
 * =1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @email xu.lan@renren-inc.com
 * @create 2017年10月20 00:20
 **/
public class evaluate_reverse_polish_notation {
  public int evalRPN(String[] tokens) {
    if(tokens==null||tokens.length==0){
      return 0;
    }
    Stack<String> stack = new Stack();
    for (String str : tokens) {
      if(stack.size()<2){
        stack.push(str);
        continue;
      }
      if (str.equals("+")) {
        int d1 = Integer.parseInt(stack.pop());
        int d2 = Integer.parseInt(stack.pop());
        stack.push((d1 + d2) + "");
      } else if (str.equals("-")) {
        int d1 = Integer.parseInt(stack.pop());
        int d2 = Integer.parseInt(stack.pop());
        stack.push((d2 - d1) + "");
      } else if (str.equals("*")) {
        int d1 = Integer.parseInt(stack.pop());
        int d2 = Integer.parseInt(stack.pop());
        stack.push((d1 * d2) + "");
      } else if (str.equals("/")) {
        int d1 = Integer.parseInt(stack.pop());
        int d2 = Integer.parseInt(stack.pop());
        stack.push((d2 / d1) + "");
      } else{
        stack.push(str);
      }
    }
    return Integer.parseInt(stack.pop());
  }

  public static void main(String[] args) {
    String[] token={"4","13","5","/","+"};
    evaluate_reverse_polish_notation obj=new evaluate_reverse_polish_notation();
    obj.evalRPN(token);
  }

}