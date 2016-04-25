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
		List<TreeNode> list = ub.generateTrees(4);
		for(TreeNode t : list){
			System.out.println(t.val);
		}
	}
	
	 public List<TreeNode> generateTrees(int n){
		 return findChildren(1, n);
	 }
	 private List<TreeNode> findChildren(int lo, int hi){
		 List<TreeNode> ret = new ArrayList<TreeNode>();
		 if(lo == hi){//�ҵ���Ҷ�ӽڵ�
			 ret.add(new TreeNode(lo));
			 return ret;
		 } else if (lo > hi) {//�ӽڵ�Ϊ�գ���������ӽڵ�֮һΪ�գ������Ϊ�յĻ���ᱻ����Ҷ�ӽڵ㷵�أ�
			return ret;
		 }
		 //������ǵײ�������Ҫ�����ݹ��ѯ
		 for(int i = lo; i <= hi; i++){
			 List<TreeNode> leftNodes = findChildren(lo, i-1);
			 List<TreeNode> rightNodes = findChildren(i+1, hi);
			 if(leftNodes.size() == 0 && rightNodes.size() == 0){
				 ret.add(new TreeNode(i));
				 return ret;
			 }else if(leftNodes.size() == 0){//����Ϊ�գ�����������
            	for(TreeNode r : rightNodes){
                    TreeNode temp = new TreeNode(i);
                    temp.left = null;
                    temp.right = r;
                    ret.add(temp);
                }
            } else if(rightNodes.size() == 0){//����Ϊ�գ�����������
            	for(TreeNode l : leftNodes){
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = null;
                    ret.add(temp);
                    
                }
            } else{
            	for(TreeNode l : leftNodes){//������������ӽڵ�
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
}
