public class BSTree {

	private class BSTreeNode {
		private String data;
		private BSTreeNode left;
		private BSTreeNode right;

	private BSTreeNode(String value) {
		data = value;
	}

	}

	private BSTreeNode root ;

	public boolean find(String value){
		return find(root,value);
	}

	public void insert(String value){
		root = insert(root,value);
	}


	public void delete(String value){
		root = delete(root,value);
	}

	public String toStringInOrder(){
		
		return toStringInOrder(root);

	}


	public String toStringPreOrder(){
		return toStringPreOrder(root);
	}


	private boolean find(BSTreeNode tree,String value){
		if(tree == null) {
			return false;
		}
		if(tree.data.compareTo(value) == 0) {
			return true;
		}else if (tree.data.compareTo(value) > 0) {
			return find(tree.left,value);
		}else{
			return find(tree.right,value);
		}

	}


	private BSTreeNode insert(BSTreeNode tree,String value){
		if(tree == null) {
			tree = new BSTreeNode(value);
			return tree;
		}
		if(tree.data.compareTo(value) > 0){
			tree.left = insert(tree.left,value);
			return tree;
		}else{
			tree.right = insert(tree.right,value);
			return tree;
		}
	}

	private BSTreeNode delete(BSTreeNode tree,String value){
		if(tree == null){
			return null;
		}

		if(tree.data.compareTo(value) == 0) {
			if(tree.left == null){
				tree = tree.right;
				return tree;
			}
			if(tree.right == null) {
				tree = tree.left;
				return tree;
			}
			if(tree.right.left == null) {
				tree.data = tree.right.data;
				tree = tree.right;
				return tree;
			}else{
				tree.data = findSuccessor(tree.right);
				return tree;
			}

		}else if(tree.data.compareTo(value) > 0){
			tree.left = delete(tree.left,value);
			return tree;
		}else{
			tree.right = delete(tree.left,value);
			return tree;
		}
	}

	private String findSuccessor(BSTreeNode node){
		if(node.left.left == null){
			String successor = node.left.data;
			node.left = node.left.right;
			return successor;
		}else{
			return findSuccessor(node.left);
		}
	}


	private String toStringInOrder(BSTreeNode node){
		if(node == null) {
			return null;
		}
		String left = toStringInOrder(node.left);
		String nodeData = node.data;
		String right = toStringInOrder(node.right);

		return left + " " +nodeData + " " +right;
	}


	private String toStringPreOrder(BSTreeNode node){
		if(node == null) {
			return null;
		}
		String nodeData = node.data;
		String left = toStringInOrder(node.left);
		String right = toStringInOrder(node.right);

		return  nodeData + " " + left + " " + right;
	}


}