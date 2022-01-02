package grapheelement;

public class Node {
    public Color color;
    public String name;
    public Edge leftEdge;
    public Edge rightEdge;
    public Edge left;
    public Edge right;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Edge getLeft() {
        return left;
    }

    public Edge getRight() {
        return right;
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
