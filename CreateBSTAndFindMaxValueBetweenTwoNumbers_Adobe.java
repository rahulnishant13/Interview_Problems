package Interviews;

public class CreateBSTAndFindMaxValueBetweenTwoNumbers_Adobe {
    public static void main(String[] args) {
        int [] arr = {18, 36, 9, 6, 12, 10, 1, 8, 14};

        Node node = createBST(arr);
        printBST(node);
        System.out.println();

        System.out.println(indMaxValueBetweenTwoNumbers(1, 10, node));
    }

    private static int indMaxValueBetweenTwoNumbers(int l, int k, Node node) {
        while((node.data > l && node.data > k) || (node.data < l && node.data < k)){
            if ((node.data > l && node.data > k))
                node = node.left;
            else if((node.data < l && node.data < k))
                node = node.right;
        }
        return Math.max(getMax(node, l), getMax(node, k));
    }

    private static int getMax(Node node, int data){
        int max = -1;
        while(node.data != data){
            max = Math.max(max, node.data);
            if(data > node.data){
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        return Math.max(max, data);
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