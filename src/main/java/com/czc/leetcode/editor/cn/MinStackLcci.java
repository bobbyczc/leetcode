
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 22 👎 0

package com.czc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class MinStackLcci {
    public static void main(String[] args) {
        MinStack solution = new MinStackLcci().new MinStack();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
        int minIndex, topIndex;
        int[] arr;;
        HashMap<Integer,Integer> map;
        /** initialize your data structure here. */
        public MinStack() {
            minIndex = 0;
            topIndex = -1;
            arr = new int[8];
            map = new HashMap<>();
        }

        public void push(int x) {
            if(topIndex == arr.length - 1){
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[++topIndex] = x;
            if(x <= arr[minIndex]){
                map.put(topIndex,minIndex);
                minIndex = topIndex;
            }
        }

        public void pop() {
            if(map.containsKey(topIndex)){
                minIndex = map.get(topIndex);
            }
            topIndex --;

        }

        public int top() {
            return arr[topIndex];
        }

        public int getMin() {
            return arr[minIndex];
        }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}