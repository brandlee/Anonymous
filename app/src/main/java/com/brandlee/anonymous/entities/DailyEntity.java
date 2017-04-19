package com.brandlee.anonymous.entities;

import java.util.List;

/**
 * @ClassName: DailyEntity
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class DailyEntity extends BaseEntity {
    private boolean error;
    private ResultEntity results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultEntity getResults() {
        return results;
    }

    public void setResults(ResultEntity results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}
