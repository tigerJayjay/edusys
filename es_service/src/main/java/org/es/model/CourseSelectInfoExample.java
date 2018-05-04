package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class CourseSelectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseSelectInfoExample() {
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

        public Criteria andSelectnoIsNull() {
            addCriterion("SELECTNO is null");
            return (Criteria) this;
        }

        public Criteria andSelectnoIsNotNull() {
            addCriterion("SELECTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSelectnoEqualTo(String value) {
            addCriterion("SELECTNO =", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoNotEqualTo(String value) {
            addCriterion("SELECTNO <>", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoGreaterThan(String value) {
            addCriterion("SELECTNO >", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoGreaterThanOrEqualTo(String value) {
            addCriterion("SELECTNO >=", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoLessThan(String value) {
            addCriterion("SELECTNO <", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoLessThanOrEqualTo(String value) {
            addCriterion("SELECTNO <=", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoLike(String value) {
            addCriterion("SELECTNO like", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoNotLike(String value) {
            addCriterion("SELECTNO not like", value, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoIn(List<String> values) {
            addCriterion("SELECTNO in", values, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoNotIn(List<String> values) {
            addCriterion("SELECTNO not in", values, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoBetween(String value1, String value2) {
            addCriterion("SELECTNO between", value1, value2, "selectno");
            return (Criteria) this;
        }

        public Criteria andSelectnoNotBetween(String value1, String value2) {
            addCriterion("SELECTNO not between", value1, value2, "selectno");
            return (Criteria) this;
        }

        public Criteria andSnoIsNull() {
            addCriterion("SNO is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("SNO is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("SNO =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("SNO <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("SNO >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("SNO >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("SNO <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("SNO <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("SNO like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("SNO not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("SNO in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("SNO not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("SNO between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("SNO not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andScheNoIsNull() {
            addCriterion("SCHE_NO is null");
            return (Criteria) this;
        }

        public Criteria andScheNoIsNotNull() {
            addCriterion("SCHE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andScheNoEqualTo(String value) {
            addCriterion("SCHE_NO =", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotEqualTo(String value) {
            addCriterion("SCHE_NO <>", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoGreaterThan(String value) {
            addCriterion("SCHE_NO >", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoGreaterThanOrEqualTo(String value) {
            addCriterion("SCHE_NO >=", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLessThan(String value) {
            addCriterion("SCHE_NO <", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLessThanOrEqualTo(String value) {
            addCriterion("SCHE_NO <=", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLike(String value) {
            addCriterion("SCHE_NO like", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotLike(String value) {
            addCriterion("SCHE_NO not like", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoIn(List<String> values) {
            addCriterion("SCHE_NO in", values, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotIn(List<String> values) {
            addCriterion("SCHE_NO not in", values, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoBetween(String value1, String value2) {
            addCriterion("SCHE_NO between", value1, value2, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotBetween(String value1, String value2) {
            addCriterion("SCHE_NO not between", value1, value2, "scheNo");
            return (Criteria) this;
        }

        public Criteria andIsbookIsNull() {
            addCriterion("ISBOOK is null");
            return (Criteria) this;
        }

        public Criteria andIsbookIsNotNull() {
            addCriterion("ISBOOK is not null");
            return (Criteria) this;
        }

        public Criteria andIsbookEqualTo(Integer value) {
            addCriterion("ISBOOK =", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookNotEqualTo(Integer value) {
            addCriterion("ISBOOK <>", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookGreaterThan(Integer value) {
            addCriterion("ISBOOK >", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISBOOK >=", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookLessThan(Integer value) {
            addCriterion("ISBOOK <", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookLessThanOrEqualTo(Integer value) {
            addCriterion("ISBOOK <=", value, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookIn(List<Integer> values) {
            addCriterion("ISBOOK in", values, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookNotIn(List<Integer> values) {
            addCriterion("ISBOOK not in", values, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookBetween(Integer value1, Integer value2) {
            addCriterion("ISBOOK between", value1, value2, "isbook");
            return (Criteria) this;
        }

        public Criteria andIsbookNotBetween(Integer value1, Integer value2) {
            addCriterion("ISBOOK not between", value1, value2, "isbook");
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