package main.java;

import java.util.List;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class ListResults {
    private List<Result> results;
public ListResults (List<Result> results){
    this.results=results;
}

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
