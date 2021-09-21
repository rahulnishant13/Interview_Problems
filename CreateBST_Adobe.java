package Interviews;

public class CreateBST_Adobe {
    public static void main(String[] args) {
        int [] arr = {10, 8, 12, 6, 9, 20};

        Node node = createBST(arr);
        printBST(node);
    }

    private static void printBST(Node node) {
        if(node == null){
            return;
        }
        printBST(node.left);
        System.out.print(node.data + " ");
        printBST(node.right);
    }

    private static Node createBST(int[] arr) {
        Node head = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            insertIntoBST(head, arr[i]);
        }

        return head;
    }

    private static void insertIntoBST(Node node, int data){
        if (data > node.data){
            if (node.right != null) {
                insertIntoBST(node.right, data);
            } else {
                node.right = new Node(data);
            }
        } else {
            if(node.left != null) {
                insertIntoBST(node.left, data);
            } else {
                node.left = new Node(data);
            }
        }
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int val){
        data = val;
    }
}