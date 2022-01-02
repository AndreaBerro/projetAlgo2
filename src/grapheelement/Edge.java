package grapheelement;

public class Edge {
    public Color color;
    public Node startingNode;
    public Node endingNode;

    public Edge(Node startingNode, Node endingNode, Color color) {
        this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.color = color;
    }

    //change the color and remove the edge from relations
    public boolean changeEndingColor(){
        if(endingNode==null){
            return false;
        }
        endingNode.color=this.color;
        removeEdge();
        return true;
    }
    public void removeEdge(){
        if(endingNode.leftEdge==this){
            endingNode.leftEdge=null;
        }else if (endingNode.rightEdge==this){
            endingNode.rightEdge=null;
        }
        if(startingNode.leftEdge==this){
            startingNode.leftEdge=null;
        }else if (startingNode.rightEdge==this){
            startingNode.rightEdge=null;
        }
    }

    public boolean isOutEdge(Node start){
        return start==startingNode;
    }

    public Edge() {
    }
}
