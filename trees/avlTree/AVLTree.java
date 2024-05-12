public class AVLTree{
	public Node insert(Node root, int val){
		if(null == root) return new Node(val);

		if(val < root.val){
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		System.out.println("Tree Height: " + root.height);
		int balanceFactor = getBalanceFactor(root);
		System.out.println("Balance Factor of Node " + root.val + " is " + balanceFactor);

		if(balanceFactor > 1 && val < root.left.val){
			root = rightRotate(root);
			System.out.println("New Balance Factor is : "+ getBalanceFactor(root));
			return root;
		} 
		if(balanceFactor < -1 && val > root.right.val){
			root = leftRotate(root);
			System.out.println("New Balance Factor is : "+ getBalanceFactor(root));
			return root;
		}
		if(balanceFactor > 1 && val > root.left.val){
			root.left = leftRotate(root.left);
			root = rightRotate(root);
			System.out.println("New Balance Factor is : "+ getBalanceFactor(root));
			return root;
		}
		if(balanceFactor < -1 && val < root.right.val){
			root.right = rightRotate(root.right);
			root = leftRotate(root);
			System.out.println("New Balance Factor is : "+ getBalanceFactor(root));
			return root;
		}
		return root;
	}

	private int getHeight(Node node){
		if(null == node) return 0;
		else return node.height;
	}

	private int getBalanceFactor(Node node){
		if(null == node) return 0;
		return getHeight(node.left)-getHeight(node.right);
	}

	private Node leftRotate(Node node){
		Node temp = node.right;
		Node y = temp.left;

		temp.left = node;
		node.right = y;

		node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));
		temp.height = 1+Math.max(getHeight(temp.left), getHeight(temp.right));
		
		return temp;
	}

	private Node rightRotate(Node node){
		Node temp = node.left;
		Node y = temp.right;

		temp.right = node;
		node.left = y;

		node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));
		temp.height = 1+Math.max(getHeight(temp.left), getHeight(temp.right));

		return temp;
	}
}
