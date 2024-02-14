import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public void insert(E data) {
        root = insertAction(root, data);
    }

    private Node<E> insertAction(Node<E> current, E data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertAction(current.left, data);
        } 
        
        else if (data.compareTo(current.data) > 0) {
            current.right = insertAction(current.right, data);
        }

        return current;
    }

    public Iterator<E> iterator() {
        return new IteratingTree(root);
    }

    public class IteratingTree implements Iterator<E> {
        private Node<E> current;
        private Stack<Node<E>> stack;

        public IteratingTree(Node<E> root) {
            current = root;
            stack = new Stack<>();

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public E next() {
            if (!hasNext()) {
                return null;
            }

            current = stack.pop();
            E data = current.data;

            if (current.right != null) {
                current = current.right;

                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

            return data;
        }
    }

    public void remove(E data) {
        root = removeAction(root, data);
    }

    private Node<E> removeAction(Node<E> root, E data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = removeAction(root.left, data);
        }
        else if (data.compareTo(root.data) > 0) {
            root.right = removeAction(root.right, data);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            Node<E> iop = findIOP(root.left);
            root.data = iop.data;
            root.left = removeAction(root.left, iop.data);
        }

        return root;
    }

    private Node<E> findIOP(Node<E> current) {
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public boolean search(E data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<E> root, E data) {
        if (root == null) {
            return false;
        }
        if (data.compareTo(root.data) == 0) {
            return true;
        }
        else if (data.compareTo(root.data) < 0) {
            return searchRecursive(root.left, data);
        }
        else {
            return searchRecursive(root.right, data);
        }
    }
}
