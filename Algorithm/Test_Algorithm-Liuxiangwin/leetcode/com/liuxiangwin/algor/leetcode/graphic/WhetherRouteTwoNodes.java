package com.liuxiangwin.algor.leetcode.graphic;

import java.util.LinkedList;
import com.liuxiangwin.algor.leetcode.uitl.*;
//Given a directed graph, 
 //design an algorithm to find out
//whether there is a route between two nodes

//		         b (0-adjacent)
//		        / 
//             /
//            /^   
//		     a (3- adjacent)
//		   ~/ \~ 
//         /   \
//        /     c (0- adjacent)
//       /    
//     d(1- adjacent) (Start)
//     | ~\
//     |   \
//     |    e (1- adjacent)---- f (0- adjacent)(End)
//     |
///    h (1)----k(0)
///    	
public class WhetherRouteTwoNodes {
	private static LinkedList<Node> res;
	
	public enum State {
		Unvisited, Visited, Visiting;
	}

	public static void main(String a[]) {
		Graph graphic = createNewGraph();
		Node[] nodes = graphic.getNodes();
		Node start = nodes[3];
		Node end = nodes[5];
		System.out.println(search(graphic, start, end));
		
		System.out.println(res.toString());
		

	}

	public static Graph createNewGraph() {
		Graph graphic = new Graph(8);
		//Node[] temp = new Node[6];
		Node[] temp = new Node[8];
		
		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		//temp[3] = new Node("d", 1);
		temp[3] = new Node("d", 2);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);
		temp[6] = new Node("h", 1);
		temp[7] = new Node("k", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[3].addAdjacent(temp[6]);
		temp[4].addAdjacent(temp[5]);
		temp[6].addAdjacent(temp[7]);
		
		for (int i = 0; i < 8; i++) {
			graphic.addNodes(temp[i]);
		}
		return graphic;
	}

	public static boolean search(Graph graphic, Node start, Node end) {
		LinkedList<Node> path = new LinkedList<Node>();
		LinkedList<Boolean> boolres = new LinkedList<Boolean>();
		res = new LinkedList<Node>();
		
		for (Node node : graphic.getNodes()) {
			node.state = State.Unvisited;
		}
		start.state = State.Visiting;
		path.add(start);
		res.add(start);
		
		Node tmp;
		while (!path.isEmpty()) {
			tmp = path.removeFirst();
			if (tmp != null) {
				if(tmp.adjacentCount == 0){
					if(tmp == end)
					  boolres.add(true);
					else{
						res.remove(tmp);
					}
				}
				
				for (Node adjacent : tmp.getAdjacent()) {//寻找所有的链接点
					if (adjacent.state == State.Unvisited) {//处理连接点中没有访问的
						if (adjacent == end) {
							res.add(end);
							
							boolres.add(true);
							//return true;
						} else {
							adjacent.state = State.Visiting;//访问了，就置为visiting
							path.add(adjacent);
							
							res.add(adjacent);
						}
					}
				}
				tmp.state = State.Visited;
			}
		}
		//return false;
		return boolres.size()>0? true:false;
	}
}
