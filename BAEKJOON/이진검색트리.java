import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이진검색트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Integer> list = new ArrayList<>();

	static class Node {
		Node l, r;
		int val;

		public Node(int val) {
			super();
			this.val = val;
		}

	}

	private static Node insert(Node node, int N) {
		Node cur = null;
		if (node == null) {
			return new Node(N);
		}
		if (node.val > N) {
			cur = insert(node.l, N);
			node.l = cur;
		} else {
			cur = insert(node.r, N);
			node.r = cur;
		}
		return node;
	}

	private static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.l);
			postOrder(node.r);
			System.out.println(node.val);
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Node root = new Node(n);
		String input;
		while (true) {

			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			root = insert(root, Integer.parseInt(input));

		}
		postOrder(root);
	}
}
