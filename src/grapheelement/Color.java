package grapheelement;

public enum Color {
    ROUGE, BLEU;

    @Override
    public String toString() {
        switch (this) {
            case ROUGE:
                return "R";
            case BLEU:
                return "B";
        }
       return super.toString();
    }
}
