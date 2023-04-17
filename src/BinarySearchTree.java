//PA03 Binary Search Tree
//IST 311
//By Ritvik Kumar Kothapalli

import java.util.ArrayList;
import java.util.List;

//Implementing Comparable
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    //Added Insert
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    //Adding Delete
    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Data not found in the tree.");
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }

        return node;
    }

    private T minValue(Node<T> node) {
        T minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return contains(node.left, data);
        } else if (cmp > 0) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    // Extra Credit
    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<T> node) {
        if (node == null) {
            return "N";
        }
        return node.data + ", " + toString(node.left) + ", " + toString(node.right);
    }


    public BinarySearchTree<T> rebalance() {
        List<T> inOrderList = inOrder();
        return buildBalancedTree(inOrderList, 0, inOrderList.size() - 1);
    }

    private BinarySearchTree<T> buildBalancedTree(List<T> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinarySearchTree<T> tree = new BinarySearchTree<>();
        tree.insert(sortedList.get(mid));

        tree.root.left = buildBalancedTree(sortedList, start, mid - 1).root;
        tree.root.right = buildBalancedTree(sortedList, mid + 1, end).root;

        return tree;
    }

    public List<T> inOrder() {
        List<T> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        return inOrderList;
    }

    private void inOrder(Node<T> node, List<T> inOrderList) {
        if (node != null) {
            inOrder(node.left, inOrderList);
            inOrderList.add(node.data);
            inOrder(node.right, inOrderList);
        }
    }

    public List<T> partition(T data) {
        List<T> result = new ArrayList<>();
        partition(root, data, result);
        return result;
    }

    private void partition(Node<T> node, T data, List<T> result) {
        if (node != null) {
            partition(node.left, data, result);
            if (node.data.compareTo(data) >= 0) {
                result.add(node.data);
            }
            partition(node.right, data, result);
        }
    }
}







