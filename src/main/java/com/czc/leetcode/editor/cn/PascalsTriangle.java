
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 333 👎 0

package com.czc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5).toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> tempList = new ArrayList<>(1);
        tempList.add(1);
        result.add(tempList);
        if(numRows == 1) return result;
        for(int i = 1; i < numRows; i++){
            tempList = new ArrayList<>(i+1);
            tempList.add(1);
            for(int j = 0; j < i - 1; j++){
                tempList.add(result.get(i-1).get(j) + result.get(i-1).get(j+1));
            }
            tempList.add(1);
            result.add(tempList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}