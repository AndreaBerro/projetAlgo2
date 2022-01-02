package grapheelement;

import java.util.ArrayList;
import java.util.HashMap;

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

    public int numRed(){
        int i=0;
        for (Node node: nodes){
            if (node.getColor().equals(Color.ROUGE)){
                i++;
            }
        }
        return i;
    }
//    public int Solution2(Graphe graphe){
//        int taille=0;
//        while (graphe.numRed()!=0){
//            ArrayList<Node> redNode = new ArrayList<>();
//            ArrayList<Integer> EdgeEnter = new ArrayList<>();
//            ArrayList<Integer> OutBleu = new ArrayList<>();
//            for (Node node:graphe.nodes){
//                if (node.getColor().equals(Color.ROUGE)){
//                    redNode.add(node);
//                }
//            }
//            for (Node node:redNode){
//                Edge left=node.leftEdge;
//                Edge right=node.rightEdge;
//                int i=0;
//                if (redNode.indexOf(node)==0&&right.endingNode.equals(node)){EdgeEnter.add(1);}
//                else if (redNode.indexOf(node)==99&&left.endingNode.equals(node)){EdgeEnter.add(1);}
//                else if (redNode.indexOf(node)>0&&redNode.indexOf(node)<99&&left.endingNode.equals(node)&&right.endingNode.equals(node)){
//                    EdgeEnter.add(2);
//                }
//                else if (redNode.indexOf(node)>0&&redNode.indexOf(node)<99&&!left.endingNode.equals(node)&&right.endingNode.equals(node)){
//                    EdgeEnter.add(1);
//                }
//                else if (redNode.indexOf(node)>0&&redNode.indexOf(node)<99&&left.endingNode.equals(node)&&!right.endingNode.equals(node)){
//                    EdgeEnter.add(1);
//                }
//
//                else {
//                    EdgeEnter.add(0);
//                }
//            }
//            for (Node node:redNode){
//                Edge left=node.leftEdge;
//                Edge right=node.rightEdge;
//                int i=0;
//                if (left.color.equals(Color.BLEU)&&left.startingNode.equals(node)){i++;}
//                if (right.color.equals(Color.BLEU)&&right.startingNode.equals(node)){i++;}
//                OutBleu.add(i);
//            }
//            Node delete=redNode.get(0);
//            for (Node node:redNode){
//
//                int num=redNode.indexOf(node);
//                int deleteNum=redNode.indexOf(delete);
//                if (EdgeEnter.get(num)<=EdgeEnter.get(deleteNum)&&OutBleu.get(num)<=OutBleu.get(deleteNum)){
//                    delete=node;
//                };
//
//
//            }
//            for (Node node: nodes){
//                if (node.getName().equals(delete.getName())){
//                    for (Edge edge:edges){
//                        if (edge.startingNode.equals(node)){
//                            edge.endingNode.setColor(edge.startingNode.getColor());
//                            edges.remove(edge);
//                        }
//                    }
//                    removeNode(node);
//                }
//            }
//
//            taille++;
//
//        }
//        return taille;
//
//
//    }

}
