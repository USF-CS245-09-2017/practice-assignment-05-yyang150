public class BSTree {

    private BSTreeNode root;

    public boolean find(String value) {
        return find(root, value);
    }

    public void insert(String value) {
        root = insert(root, value);
    }

    public void delete(String value) {
        root = delete(root, value);
    }
    
    public String toStringInOrder() {

        return toStringInOrder(root);

    }

    public String toStringPreOrder() {
        return toStringPreOrder(root);
    }

    private boolean find(BSTreeNode tree, String value) {
        if (tree == null) {
            return false;
        }
        if (tree.data.compareTo(value) == 0) {
            return true;
        } else if (tree.data.compareTo(value) > 0) {
            return find(tree.left, value);
        } else {
            return find(tree.right, value);
        }

    }

    private BSTreeNode insert(BSTreeNode tree, String value) {
        if (tree == null) {
            tree = new BSTreeNode(value);
            return tree;
        }
        if (tree.data.compareTo(value) > 0) {
            tree.left = insert(tree.left, value);
            return tree;
        } else{
            tree.right = insert(tree.right, value);
            return tree;
        }
    }

    private BSTreeNode delete(BSTreeNode tree, String value) {
        if (tree == null) {
            return null;
        }

        if (tree.data.compareTo(value) == 0) {
            if (tree.left == null) {
                return tree.right;
            } else if (tree.right == null) {
                return tree.left;
            } else {
                if (tree.right.left == null) {
                    tree.data = tree.right.data;
                    tree = tree.right.right;
                    return tree;
                } else {
                    tree.data = findSuccessor(tree.right);
                    return tree;
                }
            }
        } else if (tree.data.compareTo(value) > 0) {
            tree.left = delete(tree.left, value);
            return tree;
        } else {
            tree.right = delete(tree.left, value);
            return tree;
        }

    }

    private String findSuccessor(BSTreeNode node) {
        if (node.left.left == null) {
            String successor = node.left.data;
            node.left = node.left.right;
            return successor;
        } else {
            return findSuccessor(node.left);
        }
    }

    private String toStringInOrder(BSTreeNode node) {
        if (node == null) {
            return "";
        }

        String left = "";
        left += toStringInOrder(node.left).trim();
        String nodeData = node.data.trim();
        String right = "";
        right += toStringInOrder(node.right).trim();

        return left + " " + nodeData + " " + right;

}

    private String toStringPreOrder(BSTreeNode node) {
        if (node == null) {
            return "";
        }

        String left = "";
        String nodeData = node.data.trim();
        left += toStringPreOrder(node.left).trim();

        String right = "";
        right += toStringPreOrder(node.right).trim();

        return (nodeData+ " " +left + " " + right).replaceAll("  ", " ");

    }

    private class BSTreeNode {
        private String data;
        private BSTreeNode left;
        private BSTreeNode right;

        private BSTreeNode(String value) {
            data = value;
        }
    }


}
