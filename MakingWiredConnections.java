/**  
* MakingWiredConnections --- Program that takes a set of pins and a set of wires connecting pins and determines 
* if it is possible to place some pins on the left half of the PCB, and the remainder on the right half of the PCB, 
* such that each wire is between the left halves and the right halves.
* @author Megha Rastogi
*/

import java.util.*;
public class MakingWiredConnections{

	/**
	* Node --- class to store each vertex along with its adjacent vertices and distance
	*/
	static class Node{		
		
		private String id;
		private LinkedList<Node> adjacent;
		private int distance;
		
		public Node(String id){
			this.id = id;
			adjacent = new LinkedList<Node>();
			distance = -1;
		}
		
		//Getter method for start vertex
		public String getId(){
			return id;
		}
		
		//Getter method for adajcent list
		public LinkedList<Node> getAdjacent(){
			return adjacent;
		}
		
		//Getter method for distance
		public int getDistance(){
			return distance;
		}

		//add node to the adajcent list
		public void addAdjacent(Node vertex){
			adjacent.add(vertex);
		}

		//set distance to given value
		public void setDistance(int d){
			distance = d;
		}

		//To print Node 
        	public String toString(){
			String msg = id + " : ";
			for(Node node: adjacent)
				msg = msg + node.id + " ";
			msg+= "distance = "+distance;
			return msg;
        	}
	}

    /**
    * Create and get node corresponding to a vertex.
    * @param HashMap<String, Node> graph 
    * @param id 
    * @return Node object.
    */ 
    private static Node getNode(HashMap<String, Node> graph, String id){
		if(graph.containsKey(id))
		    return graph.get(id);
        else{
        	Node node = new Node(id);
        	graph.put(id, node);
        	return node;
        }
    }

    /**
    * Adds edge between sorce and destination.
    * @param HashMap<String, Node> graph 
    * @param source start index
    * @param destinations end index
    * @return No return value.
    */ 
	public static void add(HashMap<String, Node> graph, String source, String destination){

		//Get nodes corresponding to source and destination vertices.
		Node s = getNode(graph, source);
		Node d = getNode(graph, destination);

		//add nodes to adjacent list
		s.addAdjacent(d);
		d.addAdjacent(s);
	}

    /**
    * Creates a HashMap with string key and Node value
    * @param input list of edges
    * @return HashMap<String,Node>
    */ 
	public static HashMap<String, Node> createGraph(String[] input){
		HashMap<String, Node> graph = new HashMap<String, Node>();
		Node node;
		for(String s: input){
			String first = String.valueOf(s.charAt(0));
			String second = String.valueOf(s.charAt(1));
			add(graph, first, second);
		}
		return graph;
	}

    /**
    * Helper method to check for each vertex of graph 
    * whether we can divide the graph into two sets such 
    * that each vertex in left halves is connected to 
    * each vertex in right halves
    * @param HashMap<String, Node> graph 
    * @return true or false
    */ 
	public static boolean canPartition(HashMap<String, Node> graph){
		HashSet<String> key = new HashSet<String>(graph.keySet());
		for(String k: key){
			Node node = graph.get(k);
			if(node.getDistance() == -1 && !canPartition(node))
				return false;
		}
		return true;
	}

    /**
    * BFS to find distance of all vertices from given node.
    * @param source start node
    * @return true or false
    */ 
	public static boolean canPartition(Node source){
	
		Queue<Node> queue = new LinkedList<Node>();
		source.setDistance(0);
		queue.add(source);
		while(!queue.isEmpty()){
			for(Node child: queue.peek().getAdjacent()){
				if(child.getDistance() == -1){
					child.setDistance(queue.peek().getDistance()+1);
					queue.add(child);
				}else if(child.getDistance() == queue.peek().getDistance())
					return false;
			}
			queue.remove();
		}
		return true;
	}

    /**
    * Print HashMap
    * @param HashMap<String, Node> graph 
    * @return no return value
    */ 
	public static void printGraph(HashMap<String,Node> graph){
		HashSet<String> key = new HashSet<String>(graph.keySet());
		for(String e: key)
			System.out.println(graph.get(e));
	}
	
    /**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){
		
		//Input edges of the graph.
		String[] input = {"AB", "BC", "CD", "AH", "BI", "HI", "ID", "DE", "HG", "GF", "IF", "FE"};
		String[] input1 = {"AB", "AC", "BC", "CD", "AH", "BI", "HI", "ID", "DE", "HG", "GF", "IF", "FE"};

		//Create Graph. Change to input2 to see the results for that graph
		HashMap<String, Node> graph = createGraph(input1);

		//Print Graph
		printGraph(graph);
		System.out.println("-----------------------------------");
		
		//Find whether partition exists.
		System.out.println("Partition exists "+canPartition(graph));

	}

	
}
