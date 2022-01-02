package graphesolver;

import grapheelement.Color;
import grapheelement.Edge;
import grapheelement.Graphe;
import grapheelement.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrapheSolverB implements GrapheSolver {
    public int[] weight=new int[4];
    public GrapheSolverB(){
        weight[0]=10;
        weight[1]=4;
        weight[2]=13;
        weight[3]=5;
    }
    @Override
    public int solve(Graphe g) {
        List<Node> removedNodes = new ArrayList<>();
        g.nodes.sort(nodeComparator);
        while(g.nodes.size()>0&&importance(g.nodes.get(0))!=0) {
            removedNodes.add(g.nodes.get(0));
            g.removeNode(g.nodes.get(0));

            g.nodes.sort(nodeComparator);
//            System.out.println(g.nodes);
        }


        return removedNodes.size();

    }
    Comparator<Node> nodeComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return importance(o2)-importance(o1);
        }
    };
    public int importance(Node node){
        if(node.color == Color.BLEU){
            return 0;
        }
        int i=3;
        i = getI(i, node.leftEdge,node);
        i = getI(i, node.rightEdge,node);
        return i;
    }
    private int getI(int i, Edge edge,Node node) {
        if(edge != null){
            if(edge.isOutEdge(node)){
                if(edge.color == Color.ROUGE){
                    i+=weight[0];
                    if(edge.endingNode.color == Color.BLEU){
                        i+=weight[1];
                    }
                }
            }else {
                if(edge.color == Color.BLEU){
                    i+=weight[2];
                    if( edge.startingNode.color == Color.ROUGE){
                        i+=weight[3];
                    }
                }
            }
        }
        return i;
    }
}
