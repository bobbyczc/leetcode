### 解题思路

利用栈，遇到字母，将其压入栈，遇到退格，相当于从栈顶弹出元素。处理完所有字符后，得到最终的字符串。
比较两个字符串用上述方法得到的最终结果是否相等。

注意点:1.“equals()”比较字符串中所包含的内容是否相同，返回值为布尔型。2.String.toCharArray 方法,作用：将字符串转换为字符数组。3.if，else if语句执行顺序，当满足if条件时一直执行if语句，不满足时执行elseif的语句；4.String.valueOf(char[] data) : 将 char 数组 data 转换成字符串 

### 代码

```java
/*

利用栈，遇到字母，将其压入栈，遇到退格，相当于从栈顶弹出元素。处理完所有字符后，得到最终的字符串。
比较两个字符串用上述方法得到的最终结果是否相等。

时间复杂度：O(n)。n为两字符串长度之和。
空间复杂度：O(n)。

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));    //“equals()”比较字符串中所包含的内容是否相同。
    }
//方法build遍历字符使其进栈及出栈
////build(s)使用栈存储每次输入的字符。
    public String build(String S) {
        Stack<Character> st = new Stack<>();
        for(char c : S.toCharArray()){//String.toCharArray 方法,作用：将字符串转换为字符数组
            if(c!='#'){  ////只要满足字符不是#，则一直进栈，否则的话执行else if语句进行出栈操作
                st.push(c);
            }
            else if(!st.empty()){
                st.pop();
            }
        }
        return String.valueOf(st);//将变量st转换为字符串，String.valueOf(char[] data) :
                                // 将 char 数组 data 转换成字符串 
    }
}
```