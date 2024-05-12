public class AVLTree{
	public Node insert(Node root, int val){
		if(null == root) return new Node(val);

		if(val < root.val){
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		int balanceFactor = getBalanceFactor(root);

		if(balanceFactor > 1 && val < root.left.val){
			root = rightRotate(root);
			return root;
		} 
		if(balanceFactor < -1 && val > root.right.val){
			root = leftRotate(root);
			return root;
		}
		if(balanceFactor > 1 && val > root.left.val){
			root.left = leftRotate(root.left);
			root = rightRotate(root);
			return root;
		}
		if(balanceFactor < -1 && val < root.right.val){
			root.right = rightRotate(root.right);
			root = leftRotate(root);
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

	public Node delete(Node root, int key){
		  if (root == null) {
    		return root;
  		}

  		if (key < root.val) {
    		root.left = delete(root.left, key);
  		} else if (key > root.val) {
    		root.right = delete(root.right, key);
  		} else {
    		if (root.left == null) {
      			return root.right;
    		} else if (root.right == null) {
      			return root.left;
  		  	}

    		 Node temp = findLastLeftOfRight(root.right);
                root.val = temp.val;
                root.right = delete(root.right, root.val);
  		}

		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		int balance = getBalanceFactor(root);
  		if (balance > 1 && getBalanceFactor(root.left) >= 0) {
    		return rightRotate(root);
  		} else if (balance > 1 && getBalanceFactor(root.left) < 0) {
    		root.left = leftRotate(root.left);
    		return rightRotate(root);
  		} else if (balance < -1 && getBalanceFactor(root.right) <= 0) {
    		return leftRotate(root);
  		} else if (balance < -1 && getBalanceFactor(root.right) > 0) {
    		root.right = rightRotate(root.right);
    		return leftRotate(root);
  		}

  		return root;
	}

	private Node findLastLeftOfRight(Node node){
		if(node.left == null) return node;
		return findLastLeftOfRight(node.left);
	}
}
