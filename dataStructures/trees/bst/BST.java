public class BST{
	public TreeNode insert(TreeNode root, int val){
		if(root == null) return new TreeNode(val);

		if(root.val >= val){
			if(root.left == null){
				root.left = new TreeNode(val);
				return root;
			} else {
				return insert(root.left, val);
			}
		} else {
			if(root.right == null){
				root.right = new TreeNode(val);
				return root;
			} else {
				return insert(root.right, val);
			}
		}
	}

	public TreeNode search(TreeNode root, int val){
		if(root == null) return null;

		if(root.val == val) return root;
		else if (root.val < val) return search(root.right, val);
		else return search(root.left, val);
	}
}
