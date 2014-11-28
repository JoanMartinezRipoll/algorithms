package recursive.tree.nstructure;
import java.util.ArrayList;
import java.util.List;


public class Tree<T> {
		
	Node<T> root;
	
	public Tree (T rootData) {
		this.root = new Node<T>(rootData);
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public static class Node<T> {
		private T value;
		private List<Node<T>> children;

		// Constructor
		public Node(T value) {
			this.value = value;
			children = new ArrayList<Node<T>>();
		}

		public T getValue() {
			return this.value;
		}

		public List<Node<T>> getChildren() {
			return children;
		}

		public void setChildren(ArrayList<Node<T>> children) {
			this.children = children;
		}
		
		public String toString(){
			return value.toString();
		}
	}
}
