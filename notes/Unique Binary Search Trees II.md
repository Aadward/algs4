# LeetCode笔记——Unique Binary Search Trees II

#### 题目

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example,
Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

根据题目可以看出，用例会穿一个整形n给我，然后我要得到由1到n（包括n）n个数字能够组成的所有二叉搜索树。

##### 1.解题思路
* 看到树，第一个想到的就是递归，确实，我也用到了递归，可以将递归逻辑概括为：找左子树和找右子树。
* 首先最重要的是，根节点的选择。由上图可以看出，1-n之间的任一数字都有可以作为根节点，故我们遍历1-n之间的所有数字，分别让其作为根节点然后进行递归。
* 具体步骤为：首先遍历1-n将其分别当做根节点寻找左右子节点，然后将得到的左右子节点再次进行遍历和递归，当到达叶子节点（数字的边缘）的时候开始收敛。
#### 2.具体代码
* 首先是递归的起点  
```java
    public List<TreeNode> generateTrees(int n){
      return findChildren(1, n);
    }
```
* 具体的递归操作
```java
    List<TreeNode> ret = new ArrayList<TreeNode>();
 //如果不是底部，则需要继续递归查询
		for(int i = lo; i <= hi; i++){
			 List<TreeNode> leftNodes = findChildren(lo, i-1);
			 List<TreeNode> rightNodes = findChildren(i+1, hi);
			 ...//判断子树是否为空，如果左右都为空则这是一个孤立节点，若左或者右为空则将其中不为空一边的节点的依次加到i节点的相应子树
			    //若两边都不为空，则交叉结合（总数量n = leftNodes.size() * rightNodes.size()）
		}
		return ret;
```
