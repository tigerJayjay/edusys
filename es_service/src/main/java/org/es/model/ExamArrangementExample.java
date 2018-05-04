package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class ExamArrangementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamArrangementExample() {
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

        public Criteria andSeatNumberIsNull() {
            addCriterion("SEAT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIsNotNull() {
            addCriterion("SEAT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberEqualTo(Integer value) {
            addCriterion("SEAT_NUMBER =", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotEqualTo(Integer value) {
            addCriterion("SEAT_NUMBER <>", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThan(Integer value) {
            addCriterion("SEAT_NUMBER >", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEAT_NUMBER >=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThan(Integer value) {
            addCriterion("SEAT_NUMBER <", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("SEAT_NUMBER <=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIn(List<Integer> values) {
            addCriterion("SEAT_NUMBER in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotIn(List<Integer> values) {
            addCriterion("SEAT_NUMBER not in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberBetween(Integer value1, Integer value2) {
            addCriterion("SEAT_NUMBER between", value1, value2, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SEAT_NUMBER not between", value1, value2, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andExamnoIsNull() {
            addCriterion("EXAMNO is null");
            return (Criteria) this;
        }

        public Criteria andExamnoIsNotNull() {
            addCriterion("EXAMNO is not null");
            return (Criteria) this;
        }

        public Criteria andExamnoEqualTo(Integer value) {
            addCriterion("EXAMNO =", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoNotEqualTo(Integer value) {
            addCriterion("EXAMNO <>", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoGreaterThan(Integer value) {
            addCriterion("EXAMNO >", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAMNO >=", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoLessThan(Integer value) {
            addCriterion("EXAMNO <", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoLessThanOrEqualTo(Integer value) {
            addCriterion("EXAMNO <=", value, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoIn(List<Integer> values) {
            addCriterion("EXAMNO in", values, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoNotIn(List<Integer> values) {
            addCriterion("EXAMNO not in", values, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoBetween(Integer value1, Integer value2) {
            addCriterion("EXAMNO between", value1, value2, "examno");
            return (Criteria) this;
        }

        public Criteria andExamnoNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAMNO not between", value1, value2, "examno");
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