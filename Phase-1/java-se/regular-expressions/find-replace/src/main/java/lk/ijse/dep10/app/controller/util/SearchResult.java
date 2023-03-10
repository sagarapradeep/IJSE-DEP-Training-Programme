package lk.ijse.dep10.app.controller.util;

public class SearchResult {
    private int start;
    private int end;

    public SearchResult(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
