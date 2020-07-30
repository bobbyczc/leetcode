
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
        solution.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, j;
        for(i = 0, j = 0; j < n && i <= m + j;){
            if(nums2[j] <= nums1[i]){
                insert(nums1, i, nums2[j]);
                j++;
            }else{
                i++;
            }

        }
        if(j != n - 1){
            for(int index = j; index < n; index++){
                nums1[i-1] = nums2[index];
                i++;
            }
        }

    }

    private void insert(int[] arr, int index, int value){
        int temp;
        for(int i = index; i < arr.length; i++){
            temp = arr[i];
            arr[i] = value;
            value = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}