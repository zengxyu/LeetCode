import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        int length = s.length();
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 判断第一个和最后一个是否为一对
            char item = s.charAt(i);
            if (i == length - 1) {
                if (stack.size() != 0 && isPair(item, stack.get(stack.size() - 1))) {
                    stack.remove(stack.size() - 1);
                    break;
                } else {
                    return false;
                }
            }
            char next_item = s.charAt(i + 1);
            //如果i是最后一个元素

            if (isPair(item, next_item)) {
                //如果和下一个是一对，遍历到下下个
                i++;
            } else if (stack.size() != 0 && isPair(item, stack.get(stack.size() - 1))) {
                //如果和下一个不是一对，和上一个是一对
                stack.remove(stack.size() - 1);
            } else {
                stack.add(item);
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isPair(char x, char y) {
        if (x == '{' && y == '}' || x == '}' && y == '{')
            return true;
        if (x == '(' && y == ')' || x == ')' && y == '(')
            return true;
        if (x == '[' && y == ']' || x == ']' && y == '[')
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[]}"));
    }
}
