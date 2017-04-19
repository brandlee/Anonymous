package com.brandlee.anonymous.entities;

import java.util.List;

/**
 * @ClassName: DataEntity
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public class DataEntity extends BaseEntity {
    private boolean error;
    private List<ResultEntity> results;

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
