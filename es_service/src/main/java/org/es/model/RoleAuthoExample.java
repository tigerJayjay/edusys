package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class RoleAuthoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleAuthoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoIsNull() {
            addCriterion("NO is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("NO is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(Integer value) {
            addCriterion("NO =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(Integer value) {
            addCriterion("NO <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(Integer value) {
            addCriterion("NO >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(Integer value) {
            addCriterion("NO <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(Integer value) {
            addCriterion("NO <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<Integer> values) {
            addCriterion("NO in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<Integer> values) {
            addCriterion("NO not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(Integer value1, Integer value2) {
            addCriterion("NO between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(Integer value1, Integer value2) {
            addCriterion("NO not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andRolNoIsNull() {
            addCriterion("ROL_NO is null");
            return (Criteria) this;
        }

        public Criteria andRolNoIsNotNull() {
            addCriterion("ROL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRolNoEqualTo(Integer value) {
            addCriterion("ROL_NO =", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoNotEqualTo(Integer value) {
            addCriterion("ROL_NO <>", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoGreaterThan(Integer value) {
            addCriterion("ROL_NO >", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROL_NO >=", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoLessThan(Integer value) {
            addCriterion("ROL_NO <", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoLessThanOrEqualTo(Integer value) {
            addCriterion("ROL_NO <=", value, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoIn(List<Integer> values) {
            addCriterion("ROL_NO in", values, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoNotIn(List<Integer> values) {
            addCriterion("ROL_NO not in", values, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoBetween(Integer value1, Integer value2) {
            addCriterion("ROL_NO between", value1, value2, "rolNo");
            return (Criteria) this;
        }

        public Criteria andRolNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ROL_NO not between", value1, value2, "rolNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoIsNull() {
            addCriterion("AUTH_NO is null");
            return (Criteria) this;
        }

        public Criteria andAuthNoIsNotNull() {
            addCriterion("AUTH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNoEqualTo(Integer value) {
            addCriterion("AUTH_NO =", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoNotEqualTo(Integer value) {
            addCriterion("AUTH_NO <>", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoGreaterThan(Integer value) {
            addCriterion("AUTH_NO >", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTH_NO >=", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoLessThan(Integer value) {
            addCriterion("AUTH_NO <", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoLessThanOrEqualTo(Integer value) {
            addCriterion("AUTH_NO <=", value, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoIn(List<Integer> values) {
            addCriterion("AUTH_NO in", values, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoNotIn(List<Integer> values) {
            addCriterion("AUTH_NO not in", values, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_NO between", value1, value2, "authNo");
            return (Criteria) this;
        }

        public Criteria andAuthNoNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_NO not between", value1, value2, "authNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}