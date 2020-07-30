
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 227 👎 0

package com.czc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stackPre = new Stack<>();
        stackPre.push(root);
        Stack<TreeNode> stackPost = new Stack<>();
        Stack<TreeNode> temp = null;
        TreeNode node = null;
        List<Integer> list = new ArrayList<>();
        int deep = 1;
        while(!stackPre.isEmpty()){
            node = stackPre.pop();
            list.add(node.val);
            if(deep % 2 == 1){
                if(node.left!=null)
                    stackPost.push(node.left);
                if(node.right!=null)
                    stackPost.push(node.right);
            }else{
                if(node.right!=null)
                    stackPost.push(node.right);
                if(node.left!=null)
                    stackPost.push(node.left);
            }
            if(stackPre.isEmpty()){
                temp = stackPre;
                stackPre = stackPost;
                stackPost = temp;
                deep++;
                result.add(list);
                list = new ArrayList<>();
            }
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}