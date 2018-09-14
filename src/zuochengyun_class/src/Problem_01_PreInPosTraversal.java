import java.util.Stack;

public class Problem_01_PreInPosTraversal {
/*
一、分别用递归和非递归方式实现二叉树先序、中序和后序遍历
用递归和非递归方式，分别按照二叉树先序、中序和后序打印所有的节点。
我们约定：先序遍历顺序为根、左、右；中序遍历顺序为左、根、右；后序遍历顺序为左、右、根。
*/
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");  //先打印
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");  //回来再打印
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");  //最后打印
	}

	/**
	 *
	 * @param root 树的根节点
	 * 放一个，弹出一个。依次遍历
	 */
	public static void preOrderUnRecur_1(Node head) { //先序非递归
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);  //先放根节点
			while (!stack.isEmpty()) { //此时不需要对head判断，因为是弹出-判断-再放。
				head = stack.pop();  //弹出一个节点后，先放入弹出节点的右边，左边
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	/**
	 *
	 * @param root 树的根节点
	 * 利用栈模拟递归过程实现循环先序遍历二叉树。一直放，放完了再弹出
	 * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
	 */
	public static void preOrderUnRecur_2(Node root){
		if(root==null) {
            return;
        }
		Stack<Node> s=new Stack<Node>();
		while(root!=null||!s.isEmpty()){ //要对栈进行处理分两种情况：可以一直压栈 or 可以一直弹出
			while(root!=null){ //先压栈
				System.out.println(root.value);
				s.push(root);//先访问再入栈
				root=root.left;
			}
			root=s.pop();
			root=root.right;//如果是null，出栈并处理右子树
		}
	}

	/**
	 *
	 * @param root 树根节点
	 * 利用栈模拟递归过程实现循环中序遍历二叉树
	 * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。
	 */
	public static void inOrderUnRecur(Node head) {  //中序非递归
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {  //第一次满足条件
				if (head != null) {
					stack.push(head);  //只要左边有东西，就一直压栈
					head = head.left;
				} else {    //左边压到底了，弹出就打印，再往右边
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur_1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur_2(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && head != c.left && head != c.right) {
					stack.push(c.left);
				} else if (c.right != null && head != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					head = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
//		System.out.println("==============recursive==============");
//		System.out.print("pre-order: ");
//		preOrderRecur(head);
//		System.out.println();
//		System.out.print("in-order: ");
//		inOrderRecur(head);
//		System.out.println();
//		System.out.print("pos-order: ");
//		posOrderRecur(head);
//		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		//preOrderUnRecur_1(head);
		//preOrderUnRecur_2(head);
//		inOrderUnRecur(head);
		posOrderUnRecur_1(head);
//		posOrderUnRecur_2(head);

	}

}
