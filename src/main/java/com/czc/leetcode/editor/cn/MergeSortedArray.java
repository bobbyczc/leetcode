
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 574 👎 0

package com.czc.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        int[] nums1 = {2,0};
//        int[] nums2 = {1};
        solution.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        int index = 0;
        System.arraycopy(nums1,0,temp,0,m);
        for(int i = 0, j = 0; i < m || j < n; ){
            if(i == m){
                nums1[index++] = nums2[j++];
                continue;
            }
            if(j == n){
                nums1[index++] = temp[i++];
                continue;
            }
            if(nums2[j] <= temp[i]){
                nums1[index++] = nums2[j++];
            }else{
                nums1[index++] = temp[i++];
            }
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}