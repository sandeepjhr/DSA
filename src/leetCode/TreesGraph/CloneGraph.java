package leetCode.TreesGraph;

import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node cloneGraphMethod(Node node){
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node origNode = queue.poll();
            for(Node origNeigh : origNode.neighbors){
                if(!map.containsKey(origNeigh)){ // check if not visited
                    map.put(origNeigh, new Node(origNeigh.val));
                    queue.offer(origNeigh);
                }
                Node copyNode = map.get(origNode);
                Node copyNeigh = map.get(origNeigh);
                copyNode.neighbors.add(copyNeigh);
            }
        }

        return map.get(node);

    }
}
