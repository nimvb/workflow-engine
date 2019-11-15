package com.example.service.criteria;

import com.example.model.base.BaseContext;
import com.example.service.criteria.base.BaseCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExampledStringBasedCriteria implements BaseCriteria<BaseContext<String>> {

    private String filter;

    public ExampledStringBasedCriteria(String filter){

        this.filter = filter;
    }

    @Override
    public BaseContext<String> filter(BaseContext<String> context) {
        String data = context.getContextData();
        String[] parts = data.split(",");
        List<String> result = new ArrayList<>();
        for (String part : parts) {
            if (part.startsWith(filter)) {
                result.add(part);
            }
        }
        Optional<String> filtered = result.stream().reduce((s, s2) -> s.concat(",").concat(s2));
        BaseContext<String> r = new BaseContext<>();
        r.setContextData(filtered.orElse(""));
        return r;
    }
}
