package com.brandlee.anonymous.entities;

import java.util.List;

/**
 * @ClassName: SearchEntity
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class SearchEntity extends BaseEntity {
    private int count;
    private boolean error;
    private List<ResultEntity> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }
}
