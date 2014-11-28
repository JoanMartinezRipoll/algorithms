package recursive.tree.nstructure;
import java.util.ArrayList;

import recursive.tree.nstructure.Tree.Node;

public class TreeNodesAverageCount {

		public static class AvgCount {
			double sum;
			int count;
			
			public AvgCount(){};
			
			public AvgCount (double sum, int count) {
				this.sum = sum;
				this.count = count;
			}
			public double getSum() {
				return sum;
			}
			public void setSum(double sum) {
				this.sum = sum;
			}
			public int getCount() {
				return count;
			}
			public void setCount(int count) {
				this.count = count;
			}
			
			
		}
		public static void main (String args[]) {

			/*
			 * Create the following tree:
			 * 				5____
			 * 			   / \   \
			 * 		      2   4   3
			 *           / \     
			 *         3    2
			 *             / 
			 *            1
			 */
			Tree<Double> tree = new Tree<Double>(5.0);
			ArrayList<Node<Double>> firstLevel = new ArrayList<Node<Double>>();
			firstLevel.add(new Node<Double>(2.0));
			firstLevel.add(new Node<Double>(4.0));
			firstLevel.add(new Node<Double>(3.0));
			
			ArrayList<Node<Double>> secondLevel = new ArrayList<Node<Double>>();
			secondLevel.add(new Node<Double>(3.0));
			secondLevel.add(new Node<Double>(7.0));
			
			ArrayList<Node<Double>> thirdLevel = new ArrayList<Node<Double>>();
			thirdLevel.add(new Node<Double>(1.0));
			
			secondLevel.get(1).setChildren(thirdLevel);
			firstLevel.get(0).setChildren(secondLevel);
			tree.getRoot().setChildren(firstLevel);
		
			double average = getAverage(tree);
			System.out.println("The average is " + average);
		}


		public static double getAverage(Tree<Double> tree) {
			AvgCount avgCount = getAverageWithCount(tree.getRoot(), 0);
			return avgCount.getSum()/avgCount.getCount() ;
		}


		private static AvgCount getAverageWithCount(Node<Double> root, int i) {
			if (root.getChildren().isEmpty()) return new AvgCount(root.getValue(), 1);
			else {
				AvgCount aux;
				AvgCount result = null;
				for (Node<Double> node : root.getChildren()) {
					aux = getAverageWithCount(node, i);
					if (result == null) {
						result = aux; 
					}
					else {
					result.setCount(result.getCount() + aux.getCount());
					result.setSum(result.getSum() + aux.getSum());
					}
				}
				result.setSum(result.getSum() + root.getValue());
				result.setCount(result.getCount() + 1);
				return result;
			}
		}




	}
