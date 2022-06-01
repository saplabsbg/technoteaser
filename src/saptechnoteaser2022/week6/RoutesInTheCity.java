package saptechnoteaser2022.week6;

import java.util.HashMap;
import java.util.stream.Stream;
/* 
 * <h1>Routes in the city</h1>
 * SAPTechnoteaser 2022, Week6, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week6,question2">Description and explanation</a>
 */ 
public class RoutesInTheCity {

	private static final int ROWS_NUM = 6;
	private static final int COLS_NUM = 6;
	
	private static enum Direction {
		HORIZONTAL_LEFT, HORIZONTAL_RIGHT, VERTICAL_DOWN, VERTICAL_UP;
		
		public static Direction getReversedDirection(Direction d) {
			switch (d) {
				case HORIZONTAL_LEFT: return HORIZONTAL_RIGHT;
				case HORIZONTAL_RIGHT: return HORIZONTAL_LEFT;
				case VERTICAL_DOWN: return VERTICAL_UP;
				case VERTICAL_UP: return VERTICAL_DOWN;
			}
			return null;
		}
	
	};
	
	private Node[][] landmarks;
	private final Node startLandmark;
    private final Node finalLandmark;
    
    private int solutions = 0;
    
    public RoutesInTheCity () {		
    	this.landmarks = new Node[ROWS_NUM][COLS_NUM];
        for (int i=0; i<ROWS_NUM; i++) {
        	for (int j=0; j<COLS_NUM; j++) {
        		landmarks[i][j] = new Node(i, j);
        	}
        }
        for (int i=0; i<ROWS_NUM; i++) {
        	for (int j=0; j<COLS_NUM; j++) {
        		if (i > 0) {
        			landmarks[i][j].addNeighbor(landmarks[i-1][j], Direction.VERTICAL_UP);
        		}
        		if (j > 0) {
        			landmarks[i][j].addNeighbor(landmarks[i][j-1], Direction.HORIZONTAL_LEFT);
        		}
        	}
        }
        
        this.startLandmark = landmarks[0][0];
        this.finalLandmark = landmarks[ROWS_NUM-1][COLS_NUM-2];
    }
    		
	public static void main(String[] args) {
		RoutesInTheCity route = new RoutesInTheCity();
        route.findAllPaths (route.startLandmark);
	}

	private void findAllPaths (Node currentNode) {
	
		if (currentNode == finalLandmark) {
			if (getPathCurves() == 17 && isPathViaAllLandmarks()) {
				int length = getPathLength();
				solutions++;
				print();
			}
			return;	
		}
		currentNode.getPossibleNeighbours().forEach( nextNode -> {
			currentNode.setNextNode(nextNode);
			findAllPaths(nextNode);
			currentNode.revertNextNode();
		});
	}
	
	public int getPathCurves() {
		int curves = 0;
		Node currentNode = this.startLandmark;
		Direction currentDirection = currentNode.getDirection();
		while (currentNode != this.finalLandmark) {
			if (currentNode.getDirection() != currentDirection) {
				curves++;
				currentDirection = currentNode.getDirection();
			}
			currentNode = currentNode.getNextNode();
		} 
		return curves;
	}
	public int getPathLength() {
		int length = 0;
		Node currentNode = this.startLandmark;
		while (currentNode != this.finalLandmark) {
			length++;
			currentNode = currentNode.getNextNode();
		}
		return length;
	}
	public boolean isPathViaAllLandmarks() {
		return getPathLength() == ROWS_NUM*COLS_NUM - 1;
	}
	
	public void print() {
		 System.out.println("Solution #" + solutions);
		 for (int i=0; i<ROWS_NUM; i++) {
        	for (int j=0; j<COLS_NUM; j++) {
        		System.out.print("○");
        		if (landmarks[i][j].getDirection() == Direction.HORIZONTAL_RIGHT) {
        			System.out.print("――");
        		} else if (j<COLS_NUM-1 && landmarks[i][j+1].getDirection() == Direction.HORIZONTAL_LEFT) {
        			System.out.print("――");
        		} else {
        			System.out.print("  ");
        		}
        	}
        	System.out.println();
        	for (int j=0; j<COLS_NUM; j++) {
        		if (landmarks[i][j].getDirection() == Direction.VERTICAL_DOWN) {
        			System.out.print("|  ");
        		} else if (i<COLS_NUM-1 && landmarks[i+1][j].getDirection() == Direction.VERTICAL_UP) {
        			System.out.print("|  ");
        		} else {
        			System.out.print("   ");
        		}
        	}
        	System.out.println();
	      }
	}
	
	private static class Node {
		int row, col;
		Node nextNode;
		HashMap<Node, Direction> neighbors = new HashMap<>(); 
		
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		void setNextNode(Node n) {
			this.nextNode = n;
		}
		void revertNextNode() {
			this.nextNode = null;
		}
		Node getNextNode() {
			return nextNode;
		}
		boolean isNotVisited() {
			return nextNode == null;
		}
		void addNeighbor(Node n, Direction d) {
			neighbors.put(n, d);
			n.neighbors.put(this, Direction.getReversedDirection(d));
		}
		Stream<Node> getPossibleNeighbours() {
			return neighbors.keySet().stream()
					.filter(n -> n.isNotVisited());
		}
		Direction getDirection() {
			return neighbors.get(nextNode);
		}
		@Override
		public String toString() {
			return row + "," + col;
		}
		
	}
	
}
