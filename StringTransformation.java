/**  
* StringTransformation --- Given a dictionary D and two strings s and t, determine if s produces t. Assume that all characters are lowercase alphabets.
*							If s produces t, output the length of the shortest production sequence, otherwise output -1.
* @author Megha Rastogi
*/

import java.util.*;
public class StringTransformation{

	/**
	* Node --- class to store each vertex along with its adjacent vertices
	*/
	static class Node{		
		
		private String id;
		private int distance;
		
		public Node(String id, int distance){
			this.id = id;
			this.distance = distance;
		}
		
		//Getter method for start vertex
		public String getId(){
			return id;
		}
		
		//Getter method for distance
		public int getDistance(){
			return distance;
		}

		//set distance to given value
		public void setDistance(int d){
			distance = d;
		}

		//To print Node 
        public String toString(){
     		String msg = "id : " + id +"\n";
        	msg+= "distance = "+distance+"\n";
        	return msg;
        }
	}

	/**
    * transformDistance method
    * @param source start node
    * @param destination end node
    * @return true or false
    */ 
	public static int transformDistance(HashSet<String> d, String source, String destination){
	
		HashSet<String> visited = new HashSet<String>();
		Queue<Node> q = new LinkedList<Node>();

		visited.add(source);
		q.add(new Node(source, 0));

		Node parent;
		while((parent = q.poll()) != null){
		
			//System.out.println(parent.getId());
			if(parent.getId().equals(destination))
				return parent.getDistance();

			String temp = parent.getId();

			for(int i = 0; i < temp.length(); ++i){
				String start = (i == 0) ? "" : temp.substring(0, i);
				String end = (i+1 < temp.length()) ? temp.substring(i+1) : "";

				for(int j = 0; j < 26; ++j){
					String modifiedTemp = start + (char)('a' + j) + end;

					if(!visited.contains(modifiedTemp)){
						visited.add(modifiedTemp);
						q.add(new Node(modifiedTemp, parent.getDistance()+1));
					}
					
				}
			}
		}
		return -1;
	}

	
    /**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){
		
		//Input dictionary of the graph.
		String[] di = { "bat", "cot", "dog", "dag", "dot", "cat"};
		HashSet<String> d = new HashSet<String>();
		for(String s: di)
			d.add(s);
	
		//Find whether we can get won from cat.
		System.out.println(transformDistance(d, "cat", "won"));

	}

	
}
