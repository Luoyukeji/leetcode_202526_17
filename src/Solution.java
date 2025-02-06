import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *     给定一个仅包含数字 2-9 的字符串返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        String s = "23";
        so.letterCombinations(s);
        System.out.println(so.letterCombinations(s));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 边界判断：如果输入为空，则返回空列表
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 数字到字母的映射
        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        // 开始回溯
        backtrack(result, phone, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> phone, String digits, int index, StringBuilder combination) {
        // 当组合长度等于输入数字的长度时，将组合加入结果集
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // 取出当前数字对应的字母串
        char digit = digits.charAt(index);
        String letters = phone.get(digit);

        // 遍历当前数字对应的每个字母，递归生成后续组合
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));            // 做选择
            backtrack(result, phone, digits, index + 1, combination); // 进入下一层递归
            combination.deleteCharAt(combination.length() - 1);   // 撤销选择
        }
    }

}
