package sundry;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
}

public class UniqueBinary {
	public static void main(String[] args) {
		UniqueBinary ub = new UniqueBinary();
		List<TreeNode> list = ub.generateTrees(3);
		for(TreeNode t : list){
			System.out.println(t.val);
		}
	}
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        for(int i = 1; i <= n; i++){
            List<TreeNode> leftNodes = findChildren(1, i - 1);
            List<TreeNode> rightNodes = findChildren(i + 1, n);
            for(TreeNode l : leftNodes){//自由组合左右子节点
                for(TreeNode r : rightNodes){
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    ret.add(temp);
                }
            }
        }
        return ret;
    }
    
    private List<TreeNode> findChildren(int lo, int hi){
        List<TreeNode> ret = new ArrayList<TreeNode>();
        //如果为底部，则返回它本身，如果为边界，返回null
        if(lo == hi){
           ret.add(new TreeNode(lo));
           return ret;
        }  
        else if(lo > hi)  return ret;
        //如果不是底部
        for(int i = lo; i <= hi; i++){//找直接子节点
            List<TreeNode> leftNodes = findChildren(lo,i - 1);//递归得子节点的左子节点集合
            List<TreeNode> rightNodes = findChildren(i + 1, hi);//递归得子节点的右子节点集合
            
            if(leftNodes.size() == 0){
            	for(TreeNode r : rightNodes){
                    TreeNode temp = new TreeNode(i);
                    temp.left = null;
                    temp.right = r;
                    ret.add(temp);
                }
            } else if(rightNodes.size() == 0){
            	for(TreeNode l : leftNodes){//自由组合左右子节点
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = null;
                    ret.add(temp);
                    
                }
            } else{
            	for(TreeNode l : leftNodes){//自由组合左右子节点
                    for(TreeNode r : rightNodes){
                        TreeNode temp = new TreeNode(i);
                        temp.left = l;
                        temp.right = r;
                        ret.add(temp);
                    }
                }
            }            
        }
        return ret;
    }
    
    
    private TreeNode deepCopyBST(TreeNode old){
        TreeNode ret = new TreeNode(old.val);
        if(old.left != null)  ret.left = deepCopyBST(old.left);
        if(old.right != null)  ret.right = deepCopyBST(old.right);
        return ret;
    }
}
