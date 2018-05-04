package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatorRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperatorRecordExample() {
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

        public Criteria andOprnoIsNull() {
            addCriterion("OPRNO is null");
            return (Criteria) this;
        }

        public Criteria andOprnoIsNotNull() {
            addCriterion("OPRNO is not null");
            return (Criteria) this;
        }

        public Criteria andOprnoEqualTo(String value) {
            addCriterion("OPRNO =", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotEqualTo(String value) {
            addCriterion("OPRNO <>", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoGreaterThan(String value) {
            addCriterion("OPRNO >", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoGreaterThanOrEqualTo(String value) {
            addCriterion("OPRNO >=", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLessThan(String value) {
            addCriterion("OPRNO <", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLessThanOrEqualTo(String value) {
            addCriterion("OPRNO <=", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoLike(String value) {
            addCriterion("OPRNO like", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotLike(String value) {
            addCriterion("OPRNO not like", value, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoIn(List<String> values) {
            addCriterion("OPRNO in", values, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotIn(List<String> values) {
            addCriterion("OPRNO not in", values, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoBetween(String value1, String value2) {
            addCriterion("OPRNO between", value1, value2, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprnoNotBetween(String value1, String value2) {
            addCriterion("OPRNO not between", value1, value2, "oprno");
            return (Criteria) this;
        }

        public Criteria andOprtimeIsNull() {
            addCriterion("OPRTIME is null");
            return (Criteria) this;
        }

        public Criteria andOprtimeIsNotNull() {
            addCriterion("OPRTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOprtimeEqualTo(Date value) {
            addCriterion("OPRTIME =", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeNotEqualTo(Date value) {
            addCriterion("OPRTIME <>", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeGreaterThan(Date value) {
            addCriterion("OPRTIME >", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPRTIME >=", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeLessThan(Date value) {
            addCriterion("OPRTIME <", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeLessThanOrEqualTo(Date value) {
            addCriterion("OPRTIME <=", value, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeIn(List<Date> values) {
            addCriterion("OPRTIME in", values, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeNotIn(List<Date> values) {
            addCriterion("OPRTIME not in", values, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeBetween(Date value1, Date value2) {
            addCriterion("OPRTIME between", value1, value2, "oprtime");
            return (Criteria) this;
        }

        public Criteria andOprtimeNotBetween(Date value1, Date value2) {
            addCriterion("OPRTIME not between", value1, value2, "oprtime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
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