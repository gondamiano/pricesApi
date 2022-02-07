package com.zara.PricesApi.repository.specification;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class SearchCriteria {

    private String key;
    private SearchOperation searchOperation;
    private boolean isOrOperation;
    private ArrayList<Object> arguments;

    public List<Object> getArguments() {
        return arguments;
    }

    public SearchCriteria(String key, SearchOperation searchOperation, Object value) {
        this.key = key;
        this.searchOperation = searchOperation;
        this.isOrOperation = false;
        this.arguments = new ArrayList<>();
        this.arguments.add(value);
    }
}
