public class BST{
	public TreeNode delete(TreeNode root, int val){
		if(root == null) return null;
		if(root.val == val){

		}
		while(root != null){
			if(root.val > val){
				if(root.left != null && root.left.val == val){
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}
			} else {
				if(root.right != null && root.right.val == val){
					root.right = helper(root.right);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return root;
	}

	private TreeNode helper(TreeNode node){
		if(node.left == null) return node.right;
		else if(node.right == null) return node.left;
		else {
			TreeNode leftChild = node.left;
			TreeNode lastRightLeft = findLastLeftOfRight(node.right);
			lastRightLeft.left = leftChild;
			return node.right;
		}
	}

	private TreeNode findLastLeftOfRight(TreeNode node){
		if(node.left == null) return node;

		return findLastLeftOfRight(node.right);
	}

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
