package grapheelement;

import java.util.ArrayList;

public class Graphe {
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public Graphe(ArrayList<Node> nodes,ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public boolean removeNode(Node node) {
        int i = this.nodes.indexOf(node);
        if (i != -1) {
            Node nodeToRemove = this.nodes.get(i);
            Color c = nodeToRemove.color;
            ArrayList<Edge> edgesToRemove = new ArrayList<>();
            for (Edge edge : edges) {
                if (edge.startingNode == nodeToRemove) {
                    edgesToRemove.add(edge);
                    edge.endingNode.color = c;
                }
                if (edge.endingNode == nodeToRemove) {
                    edge.endingNode = null;
                }
            }
            nodes.remove(nodeToRemove);
            for (Edge edge : edgesToRemove) {
                edges.remove(edge);
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        result += nodes.get(0);
        for (int i = 0; i < nodes.size()-1; i++) {
            result += this.edges.get(i).endingNode==nodes.get(i) ? " <-- " : " --> ";
            result += nodes.get(i+1);
        }
        return result;
    }

}
