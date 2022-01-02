package grapheelement;

import java.util.ArrayList;

public class Graphe {
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public Graphe(ArrayList<Node> nodes,ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

//    public boolean removeNode(Node node) {
//        int i = this.nodes.indexOf(node);
//        if (i != -1) {
//            Node nodeToRemove = this.nodes.get(i);
//            Color c = nodeToRemove.color;
//            ArrayList<Edge> edgesToRemove = new ArrayList<>();
//            for (Edge edge : edges) {
//                if (edge.startingNode == nodeToRemove) {
//                    edgesToRemove.add(edge);
//                    edge.endingNode.color = c;
//                }
//                if (edge.endingNode == nodeToRemove) {
//                    edge.endingNode = null;
//                }
//            }
//            nodes.remove(nodeToRemove);
//            for (Edge edge : edgesToRemove) {
//                edges.remove(edge);
//            }
//            return true;
//        }
//        return false;
//    }
    public boolean removeNode(Node node){
        if(!this.nodes.contains(node)){
            return false;
        }
        if(node.leftEdge!=null&&node.leftEdge.startingNode==node){
            edges.remove(node.leftEdge);
            node.leftEdge.changeEndingColor();
        }else if(node.leftEdge!=null){
            edges.remove(node.leftEdge);
            node.leftEdge.removeEdge();
        }
        if(node.rightEdge!=null&&node.rightEdge.startingNode==node){
            edges.remove(node.rightEdge);
            node.rightEdge.changeEndingColor();
        }else if(node.rightEdge!=null){
            edges.remove(node.rightEdge);
            node.rightEdge.removeEdge();
        }
        nodes.remove(node);
        return true;
    }
    @Override
    public String toString() {
        String result = "";

        result += nodes.get(0);
        for (int i = 0; i < nodes.size()-1; i++) {
            if(nodes.get(i).rightEdge==null){
                result += "   ";
            }else if(nodes.get(i).rightEdge.isOutEdge(nodes.get(i))){

                result +=" -"+nodes.get(i).rightEdge.color+"-> ";
            }else {
                result += " <-"+nodes.get(i).rightEdge.color+"- ";
            }
           // result += this.edges.get(i).endingNode==nodes.get(i) ? " <-- " : " --> ";
            result += nodes.get(i+1);
        }
        return result;
    }


}
