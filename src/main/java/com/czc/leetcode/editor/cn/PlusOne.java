
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 514 👎 0

package com.czc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length -1;
        digits[index] ++;
        while(digits[index] == 10){
            digits[index] = 0;
            if(index == 0){
                break;
            }
            digits[--index] ++;
        }
        if(digits[0] == 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++){
                result[i] = digits[i-1];
            }
            return result;
        }else{
            return digits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}