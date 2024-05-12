import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String[] args){
		AVLTree avlTree = new AVLTree();
		Node root = avlTree.insert(null, 1);
		root = avlTree.insert(root, 2);
		root = avlTree.insert(root, 3);
		root = avlTree.insert(root, 4);
		root = avlTree.insert(root, 5);
		root = avlTree.insert(root, 6);
		root = avlTree.insert(root, 7);

		List<Integer> inOrder = new ArrayList<>();
		inOrderTraversal(root, inOrder);

		System.out.println("inOrderTraversal");
		for(int i : inOrder){
			System.out.print(i + " ");
		}
		System.out.print("\n");

		List<Integer> preOrder = new ArrayList<>();
		preOrderTraversal(root, preOrder);
		
		System.out.println("preOrderTraversal");
		for(int i : preOrder){
			System.out.print(i + " ");
		}
	}

	private static void inOrderTraversal(Node root, List<Integer> inOrder){
		if(null == root){
			inOrder.add(-1);
			return;
		}
		inOrderTraversal(root.left, inOrder);
		inOrder.add(root.val);
		inOrderTraversal(root.right, inOrder);
	}

	private static void preOrderTraversal(Node root, List<Integer> preOrder){
		if(null == root){
			preOrder.add(-1);
			return;
		} else {
			preOrder.add(root.val);
		}
		preOrderTraversal(root.left, preOrder);
		preOrderTraversal(root.right, preOrder);
	}
}
