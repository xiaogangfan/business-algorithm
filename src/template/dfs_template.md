Template 1: Traverse
---
```java
public class Solution{
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        // do something with root
        traverse(root.left);
        // do something with root
        traverse(root.right);
        // do something with root
    }
}

```

Template 2: Divide & Conquer
---
```java
public class Solution{
    public ResultType traversal(TreeNode root){
        // null or left
        if(root == null){
            // do something and return;
        }
        
        // Divide 问题分解
        ResultType left = traversal(root.left);
        ResultType right = traversal(root.right);
        
        // Conquer 问题合并
        ResultType result = Merge from left and right
        return result;
    }
}
```

