package bsuir.gr051002.Shamko.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria() {
    }
    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }
    public Map<String, Object> getCriteria() {
        return criteria;
    }
    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

}
