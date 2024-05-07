public class Main{
	public static void main(String[] args){
		BST bst = new BST();
		TreeNode root = bst.insert(null, 4);
		bst.insert(root, 2);
		bst.insert(root, 1);
		bst.insert(root, 3);
		bst.insert(root, 7);
		bst.insert(root, 5);

		TreeNode searchNode = bst.search(root, 7);
		System.out.println("After Searching For a Node:");
		dfs(searchNode);
		System.out.println("Whole Tree Traversal");
		dfs(root);

		bst.delete(root, 7);
		System.out.println("After deletion");
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
