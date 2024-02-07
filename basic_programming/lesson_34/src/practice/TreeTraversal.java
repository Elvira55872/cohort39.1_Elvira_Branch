package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Класс {@code TreeTraversal} демонстрирует обход в глубину (DFS) и в ширину (BFS)
 * заполненного сбалансированного двоичного дерева. Дерево имеет следующую структуру:
 * <pre>
 *                  1
 *           /             \
 *           2                3
 *        /     \          /        \
 *       4       5        6          7
 *      / \     / \      /  \      /  \
 *     8  9    10 11   12   13    14  15
 * </pre>
 * Дерево полное и сбалансированное, с узлами от 1 до 15.
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        //dfs(root);
        bfs(root);
    }

    // Метод для обхода в глубину уже определен

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                System.out.print(node.value + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public static void dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                System.out.print(node.value + " ");
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }
}

