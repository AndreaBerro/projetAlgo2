package grapheelement;

public class Node {
    public Color color;
    public String name;
    public Edge leftEdge;
    public Edge rightEdge;
    public Node(String n, Color c) {
        this.color = c;
        this.name = n;

    }
    public void setLeft(Edge e) {
        this.leftEdge = e;
    }
    public void setRight(Edge e) {
        this.rightEdge = e;
    }
    @Override
    public String toString() {
        return "("+this.name+":"+this.color+")";
    }

    public int importanceB(){
        if(color == Color.BLEU){
            return 0;
        }
        int i=5;
        i = getI(i, leftEdge);
        i = getI(i, rightEdge);
        return i;
    }

    private int getI(int i, Edge leftEdge) {
        if(leftEdge != null){
            if(leftEdge.isOutEdge(this)){
                if(leftEdge.color == Color.ROUGE){
                    i+=10;
                    if(leftEdge.endingNode.color == Color.BLEU){
                         i+=5;
                    }
                }
            }else {
                if(leftEdge.color == Color.BLEU&& leftEdge.startingNode.color == Color.ROUGE){
                    i+=5;
                }
            }
        }
        return i;
    }
}
