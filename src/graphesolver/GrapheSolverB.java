package graphesolver;

import grapheelement.Graphe;
import grapheelement.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrapheSolverB implements GrapheSolver {

    @Override
    public int solve(Graphe g) {
        List<Node> removedNodes = new ArrayList<>();
        g.nodes.sort(nodeComparator);
        while(g.nodes.size()>0&&g.nodes.get(0).importanceB()!=0) {
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
            return o2.importanceB() - o1.importanceB();
        }
    };
}
