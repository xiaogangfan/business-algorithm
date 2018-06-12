Leetcode 题解
---
不是每道题都会一一解答，重在思想，使用模板来解题，达到触类旁通！

doc中有好几份文档，比较经典，可以参考。

- [CleanCodeHandbook](./doc/CleanCodeHandbook_v1.0.1.pdf)
- [leetcode-cpp](./doc/leetcode-cpp.pdf)
- [leetcode高频面试题总结](./doc/leetcode-frequencey.xlsx)
- [algorithm](./doc/algorithm-zh-hans.pdf)
- [手写代码必备手册](./doc/手写代码必备手册(C++版).pdf)

---

# 基本数据结构定义
- [ListNode](./src/entity/ListNode.java) 链表节点
- [TreeNode](./src/entity/TreeNode.java) 树节点
- [UndirectedGraphNode](./src/entity/UndirectedGraphNode.java) 无向图
- [TreeLinkNode](./src/entity/TreeLinkNode.java) 带链接的树节点
- [RandomListNode](./src/entity/RandomListNode.java) 随机链接节点
- [Interval](./src/entity/Interval.java) 间隔

# 常用解题模板
- [二分查找](./src/template/bs_template.md)
- [宽度优先搜索](./src/template/bfs_template.md)
- [深度优先搜索](./src/template/dfs_template.md)
- [二叉树递归遍历](./src/template/binary_tree_preorder_traversal_template.md)
- [动态规划](./src/template/dynamic_programing_template.md)
- [排列组合](./src/template/permute_template.md)
- [堆排序](./src/template/heapify_template.md)

# leetcode高频题目录
## frequencey 5
1. [leetcode1:tow-sum](https://leetcode.com/problems/two-sum)
    - 难度 ※※
    - 数据结构 array、set
    - 算法 sort、tow pointers
    - 思路 hashmap
    - 解题 [TwoSum.java](./src/learn/freq05/TwoSum.java)
2. [leetcode8:string-to-integer](https://leetcode.com/problems/string-to-integer-atoi)
    - 难度 ※※
    - 数据结构 string
    - 算法 math
    - 思路
        1. trim后看是不是空 
        2. 第一位是不是有正负 符号 
        3. 接下去位数有没有 str.charAt(i)<'0'||str.charAt(i)>'9' 
        4. 如果是正常数值value=10*value+str.charAt(i)-'0'; 
        5. 最后在和integer max/min value 
    - 解题 [StringToInteger.java](./src/learn/freq05/StringtoInteger.java)
3. [leetcode15:3sum](https://leetcode.com/problems/3sum)
    - 难度 ※※※
    - 数据结构 array
    - 算法 two pointer
    - 思路 for循环 外层控制I  内层控制left，right 然后i+left+right==0 就是答案。 注意先sort 数组 当中去重
    - 题解 [ThreeSum.java](./src/learn/freq05/ThreeSum.java)
4. [leetcode20:valid-parentheses](https://leetcode.com/problems/valid-parentheses)
    - 难度 ※※
    - 数据结构 string
    - 算法 stack
    - 思路 用stack实现，左括号add 右括号pop 然后比较是否是pair
    - 题解 [ValidParentheses.java](./src/learn/freq05/ValidParentheses.java)
5. [leetcode21:merge-two-sorted-lists](https://leetcode.com/problems/merge-two-sorted-lists)
    - 难度 ※※
    - 数据结构 linkedlist
    - 算法 sort, two pointers, merge
    - 思路 遍历过程中比较两个链表的头元素
    - 题解 [Merge2SortedList.java](./src/learn/freq05/Merge2SortedList.java)
6. [leetcode28:implement-strstr](https://leetcode.com/problems/implement-strstr)
    - 难度 ※※※※
    - 数据结构 string
    - 算法 two pointers, KMP, rolling hash, BM
    - 思路
    ```java
    for (int i = 0; i < h_len - n_len + 1; i++) {  //剩下的不够匹配完整needle就不用再循环了
     for (int j = 0; j < n_len; j++) {  //因为是从haystack的i位和needle的0位开始比
        if (haystack.charAt(i + j)!=needle.charAt(j)){//所以直接是haystack i+j..和neddle的j比 j从0开始
    ```
    - 题解 [ImptStrStr.java](./src/learn/freq05/ImptStrStr.java)
7. [leetcode50:powx-n](https://leetcode.com/problems/powx-n)
    - 难度 ※※※
    - 算法 binary search, math
    - 思路
        1. 先处理负指数,1.0/pow2(x,-n)
        2. 然后再用二分思想处理问题 因为指数的运算规律2^8=2^4*2^4 所以 double result=pow2(x, n/2);然后 return的时候如果指数为偶数就 return result*result 基数就在补乘个x （因为在/2的时候基数会损失一个 9/2=4）
    - 题解 [Pow.java](./src/learn/freq05/Pow.java)
8. [leetcode56:merge-intervals](https://leetcode.com/problems/merge-intervals)
    - 难度 ※※※※
    - 数据结构 array, linked list, red-black tree
    - 算法 sort, merge
    - 思路
        1. arraylist 转数组，先写comparator给数组排序，按start比。
        2. 排序好后弄一个 prev=0位 然后 和从1遍历的curr比 
           - 如果curr.start>=prev.end 说明有 interval那时候只要在比较prev.end和curr.end 那个end 大就更新prev.edm
           - 如果 curr.start<prev.end  说明没有interval直接   result.add(prev); prev=curr;循环结束后再加一次即可。
    - 题解 [MergeInterval.java](./src/learn/freq05/MergeInterval.java)
9. [leetcode57:insert-intervals](https://leetcode.com/problems/insert-interval)
   - 难度 ※※※※
   - 数据结构 array, linked list, red-black tree
   - 算法 sort, merge
   - 思路 把要插入的add到linked list后 再sort。。然后接下去和上一题完全一样
   - 题解 [InsertInterval.java](./src/learn/freq05/InsertInterval.java)
10. [leetcode65:valid-number](https://leetcode.com/problems/valid-number)
    - 难度 ※※※※※
    - 数据结构 string
    - 算法 math
    - 思路 
        1. 如果遍历中有些东西如果有一次就够了可以立个boolean的flag    
        2. 注意. Arrays.toString(char) 会返回带括号和逗号的数组形式的string 所以要，而不是一个正常string 所以要s = new String(temp);
        3. 如果实在做不出  try{ Double.valueOf(s); return true;}catch (Exception e){ return false; }    
        4. 正则做法   Pattern p = Pattern.compile("^[\\+\\-]?((\\d+(\\.\\d*)?)|(\\.\\d+))(e[\\+\\-]?\\d+)?$");
    - 题解[IsNumber.java](./src/learn/freq05/IsNumber.java)
    
11. [leetcode70:climbing-stairs](https://leetcode.com/problems/climbing-stairs)
    - 难度 ※※※※※
    - 算法 dp
    - 思路 
    Dynamic Programming, 先确定初始问题， 在递推 recursion解决后面的子问题 
    ```bash 
    if (n >= 3) { ways= climbStairs(n - 1) + climbStairs(n - 2);} 
    ```
    
    但是这么写会超时.所以用iterator 的方法 复杂度变为0（n）
    
    ```base
    for(int i=3;i<=n;i++){
        n3=n1+n2;  // 本质还是f(n)=f(n-1)+f(n-2)
        n1=n2;     //每当i++时候
        n2=n3;     //n1=上一次的n2 n2等于上一次的n3
    }
    ```
    - 题解 [ClimbStairs.java](./src/learn/freq05/ClimbStairs.java)

12. [leetcode73:set-matrix-zeros](https://leetcode.com/problems/set-matrix-zeroes)
    - 难度 ※※※
    - 数据结构 array
    - 思路 这题和CC150上1_7类似 但是cc 150的解法是用了 rows 和columns2个数组来储存0的坐标，比如matrix[i][j]=0  columns[i]++ rows[j]++,然后再次遍历这个matrix,当if(columns[i]!=0||rows[j]!=0)这个matrix[i][j]=0， leetcode上要求不需求辅助空间  那么我们就把matrix的第0行和第0列当做columns[] rows[] 来存0.先检查第0行和第0列 然后在检查从下标1开始的行和列 然后处理下标1开始的行和列，最后再处理第0行和第0列
    - 题解 [SetMatrixZeroes.java](./src/learn/freq05/SetMatrixZeroes.java)

13. [leetcode88:merge-sorted-array](https://leetcode.com/problems/merge-sorted-array)
    - 难度 ※※
    - 数据结构 array
    - 算法 two pointers, merge
    - 思路
        1. A，B不是都sorted了吗，我们不从头开始比谁小，我们从A，B的尾巴开始比谁大
        2. 谁大，谁就放到A的[(a最后一个有数据的下标)+(b.length)],然后该--下标的--,接下去就和普通mergesort一样(不要忘记检查2个数组是否为空 比方说 A空B有的时候就把B一个一个赋值到A里)
    - 题解 [MergeSortedArray.java](./src/learn/freq05/MergeSortedArray.java)

14. [leetcode98:validate-binary-search-tree](https://leetcode.com/problems/validate-binary-search-tree)
    - 难度 ※※※
    - 数据结构 tree
    - 算法 dfs
    - 思路 即如果一棵二叉树是BST，那么它的中序遍历是一个递增的数组。所以可以对中序遍历算法稍加修改，
    ```java
    static int lastVisit=Integer.MIN_VALUE;   
    public boolean isValidBST(TreeNode root) { 
        if(root==null){ return true;}
        if(!isValidBST(root.left)){return false;}//从左子树最左节点开始
        if(root.val<=lastVisit){return false;}
        lastVisit=root.val;//中间结点
        if(!isValidBST(root.right)){return false;}//右子树最左开始
        return true;
    }
    ```
    - 题解 [ValidateBST.java](./src/learn/freq05/ValidateBST.java)
    
15. [leetcode125:valid-palindrome](https://leetcode.com/problems/valid-palindrome)
    - 难度 ※※
    - 数据结构 string
    - 算法 two pointers
    - 思路 2个指针从头++尾巴--开始对比，然后要处理非字母和数字的字符 可以先tolowercase 然后 ((temp.charAt(start) >= '0' && temp.charAt(start) <= '9') || (temp
          .charAt(start) >= 'a' && temp.charAt(start) <= 'z'))
    - 题解 [ValidPalindrome.java](./src/learn/freq05/ValidPalindrome.java)

16. [leetcode127:word-ladder](https://leetcode.com/problems/word-ladder)
    - 难度 ※※※
    - 数据结构 graph
    - 算法 bfs, shortest path
    - 思路 因为每次只能在词里改一个字母，我们先把start放到一个queue里（可以用linkedlist实现 然后另外一个linkedlist存Integer的distance）然后只要queue里还有词。我们把词取出来，从首字母for循环遍历到尾巴字母，里面再一个循环 每个字母(char temp='a';temp<='z';temp++) 从A遍历到Z 然后再转回string看看字典里有没有，字典里面有再放入word的那个的queue 以此循环 直到==end 或者wordqueue空了返回0
    - 题解 [WordLadder.java](./src/learn/freq05/WordLadder.java)
    
## frequency4


# 刷题总结

## chapter01 基础编程面试总结
**面试考察的编程基本功**

- 程序风格(缩进,括号,变量名)
- Coding习惯(异常检查,边界处理)
- 沟通(让面试官时刻明白你的意图)
- 测试(主动写出合理的Testcase)

**算法其实很简单**

- 在刷题时,总结、归类相似题目
- 找出适合同一类题目的模板程序

**排列组合模板**


## chapter02 binary search & sorted array
这一部分都可以使用bs模板来解决问题 [二分搜索模板](./src/template/bs_template.md)

算法面试中如果需要优化O(n)的时间复杂度，那么只能是O(logn)的二分法

**二分搜索四点要素**:
1. start + 1 < end
2. start + (end - start) / 2
3. A[mid] ==, <, >
4. A[start] A[end] ? target

- [question01:first position of target](./src/ninechapter/ch02_binary_search_and_sorted_array/Question01FirstPositionOfTarget.java) || [lintcode](http://www.lintcode.com/zh-cn/problem/first-position-of-target/)
- [question02:search for a range](./src/ninechapter/ch02_binary_search_and_sorted_array/Question02SearchForARange.java)
- [question03:search insert position](./src/ninechapter/ch02_binary_search_and_sorted_array/Question03SearchInsertPosition.java)
- [question04:search a 2D matrix](./src/ninechapter/ch02_binary_search_and_sorted_array/Question04SearchA2DMatrix.java)
- [question05:search a 2D matrix ii](./src/ninechapter/ch02_binary_search_and_sorted_array/Question05SearchA2DMatrixII.java)
- [question06:first bad version](./src/ninechapter/ch02_binary_search_and_sorted_array/Question06FirstBadVersion.java)
- [question07:find peak element](./src/ninechapter/ch02_binary_search_and_sorted_array/Question07FindPeakElement.java)
- [question08:find minimum in rotated sorted array](./src/ninechapter/ch02_binary_search_and_sorted_array/Question08FindMinimumInRotatedSortedArray.java)
- [question09:find minimum in rotated sorted array ii](./src/ninechapter/ch02_binary_search_and_sorted_array/Question08FindMinimumInRotatedSortedArrayII.java)
- [question10:search in rotated sorted array](./src/ninechapter/ch02_binary_search_and_sorted_array/Question10SearchInRotatedSortedArray.java)
- [question11:search in rotated sorted array ii](./src/ninechapter/ch02_binary_search_and_sorted_array/Question10SearchInRotatedSortedArrayII.java)
- [question12:median of two sorted arrays](./src/ninechapter/ch02_binary_search_and_sorted_array/Question12MedianOfTwoSortedArrays.java)
- [question13:recover rotated sorted array](./src/ninechapter/ch02_binary_search_and_sorted_array/Question13RecoverRotatedSortedArray.java)
- [question14:rotate string](./src/ninechapter/ch02_binary_search_and_sorted_array/Question14RotateString.java)
- [question15:reverse words in a string](./src/ninechapter/ch02_binary_search_and_sorted_array/Question15ReverseWordsInAString.java)

**总结**

1. Binary Search Template (4 key points)
2. Rotated Sorted Array
    1. Find Minimum
    2. Find Target
    3. why o(n) with duplicates ?
3. Find Median in Two Sorted Array **find kth**
4. Reverse in 3 steps

## chapter03 Binary Tree & Divide Conquer & DFS/BFS

*任何二叉树的问题都可以尝试使用分治法解决*

二叉树的遍历问题，递归转为非递归的写法都是使用人工栈模拟系统栈的方式

宽度优先遍历的方法
- 2 Queues
- 1 Queues + Dummy Node
- 1 Queues(best)

**参考模板** [dfs_template](./src/template/dfs_template.md)

- [question01 binary tree preorder traversal](./src/ninechapter/ch03_binary_tree_and_divide_conquer_and_dfs_bfs/Question01BinaryTreePreorderTraversal.java)
- [question02 maximum depth of binary tree](./src/ninechapter/ch03_binary_tree_and_divide_conquer_and_dfs_bfs/Question02MaximumDepthOfBinaryTree.java)
- [question03 balanced binary tree](./src/ninechapter/ch03_binary_tree_and_divide_conquer_and_dfs_bfs/Question03BalancedBinaryTree.java)
- [question04 binary tree maximum path sum](./src/ninechapter/ch03_binary_tree_and_divide_conquer_and_dfs_bfs/Question04BinaryTreeMaximumPathSum.java)

## chapter04 permutation & subset

排列组合问题总结
- Arrays.sort 去重
- result.add 什么时候输出结果
- if(condition) continue 什么情况跳过
- 回溯，关键是在递归完了，需要还原items的状态

排列组合适用题目
- word break ii
- palindrome partition
- path sum ii
- restore ip address
- subsets ii
- subsets
- combinations
- permutations ii
- permutation
- combination sum ii
- substring with concatenation of all words
- letter combination of a phone number

## chapter05 linked list

需要掌握的技能
- insert a node in sorted list
- **remove a node from linked list**
- **reverse a linked list**
- merge two linked list
- find the middle of a linked list

**Dummy Node**
1. remove duplicates from sorted list i,ii
2. merge two sorted lists
3. partition list
4. reverse linked list ii

**Two Pointer **

## chapter06 dynamic programming

DP的本质就是 **记忆化搜索**
