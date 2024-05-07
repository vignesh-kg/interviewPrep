public class Main{
	public static void main(String[] args){
		BST bst = new BST();
		TreeNode root = bst.insert(null, 4);
		bst.insert(root, 2);
		bst.insert(root, 1);
		bst.insert(root, 3);
		bst.insert(root, 7);
		bst.insert(root, 5);
		dfs(root);
	}

	private static void dfs(TreeNode root){
		if(root != null){
			System.out.println(root.val);
			dfs(root.left);
			dfs(root.right);
		}
	}
}
