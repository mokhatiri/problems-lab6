package problem3;

public class Document {
    private static int counter = 1;
    protected int numRec;
    protected String title;

    public Document(String title) {
        this.title = title;
        this.numRec = counter++; // auto incremental using static counter :)
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Document #" + numRec + " : " + title;
    }
}
