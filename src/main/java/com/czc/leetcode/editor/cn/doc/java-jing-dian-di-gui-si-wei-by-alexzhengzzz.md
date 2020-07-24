# ZMH的题解
## 题目解读
求最长同值路径
* 情况1
 [image.png](https://pic.leetcode-cn.com/d9ec8f1ab993b7075c83a575071b03672feea6803110450b09132733da03f3fd-image.png)
* 情况2
 [image.png](https://pic.leetcode-cn.com/e250a13caf0b8bd3a2f280e407e34bfd9e88cda6b3a4aa73410fca11539be937-image.png)

## 解答

```java
class Solution {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0; //创建全局变量保存结果
        sameValHeight(root);
        return res;
    }
    // 函数的意思是得到最长同值路径! 但不包括情况2, 只针对情况1
    private int sameValHeight(TreeNode root) {
        if(root == null) return 0;
        int l = sameValHeight(root.left); //得到左边最长同值路径
        int r = sameValHeight(root.right); // 得到右边最长同值路径
        int tmpRes = 0;
        int left = 0;
        int right = 0;
        // 如果左边节点和当前节点相同, 结果+1
        if(root.left != null && root.left.val == root.val) {
            left = l + 1;
        }
        // 如果右边节点和当前节点相同, 结果+1
        if(root.right != null && root.right.val == root.val) {
            right = r + 1;
        }
        // left + right 的含义 包括了情况2, 当出现情况2的时候, left + right = l + r + 2
        // 如果只有情况1, 就是单边的结果
        res = Math.max(res, left + right);
        // 返回单边最长路径 符合这个函数想表达的意思
        return Math.max(left, right);
    }
}
```