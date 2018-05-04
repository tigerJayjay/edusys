package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class EvaluateConExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateConExample() {
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

        public Criteria andYeartimeIsNull() {
            addCriterion("YEARTIME is null");
            return (Criteria) this;
        }

        public Criteria andYeartimeIsNotNull() {
            addCriterion("YEARTIME is not null");
            return (Criteria) this;
        }

        public Criteria andYeartimeEqualTo(String value) {
            addCriterion("YEARTIME =", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotEqualTo(String value) {
            addCriterion("YEARTIME <>", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeGreaterThan(String value) {
            addCriterion("YEARTIME >", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeGreaterThanOrEqualTo(String value) {
            addCriterion("YEARTIME >=", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLessThan(String value) {
            addCriterion("YEARTIME <", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLessThanOrEqualTo(String value) {
            addCriterion("YEARTIME <=", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLike(String value) {
            addCriterion("YEARTIME like", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotLike(String value) {
            addCriterion("YEARTIME not like", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeIn(List<String> values) {
            addCriterion("YEARTIME in", values, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotIn(List<String> values) {
            addCriterion("YEARTIME not in", values, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeBetween(String value1, String value2) {
            addCriterion("YEARTIME between", value1, value2, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotBetween(String value1, String value2) {
            addCriterion("YEARTIME not between", value1, value2, "yeartime");
            return (Criteria) this;
        }

        public Criteria andTermtimeIsNull() {
            addCriterion("TERMTIME is null");
            return (Criteria) this;
        }

        public Criteria andTermtimeIsNotNull() {
            addCriterion("TERMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTermtimeEqualTo(Integer value) {
            addCriterion("TERMTIME =", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotEqualTo(Integer value) {
            addCriterion("TERMTIME <>", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeGreaterThan(Integer value) {
            addCriterion("TERMTIME >", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TERMTIME >=", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeLessThan(Integer value) {
            addCriterion("TERMTIME <", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeLessThanOrEqualTo(Integer value) {
            addCriterion("TERMTIME <=", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeIn(List<Integer> values) {
            addCriterion("TERMTIME in", values, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotIn(List<Integer> values) {
            addCriterion("TERMTIME not in", values, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeBetween(Integer value1, Integer value2) {
            addCriterion("TERMTIME between", value1, value2, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("TERMTIME not between", value1, value2, "termtime");
            return (Criteria) this;
        }

        public Criteria andCheckNoIsNull() {
            addCriterion("CHECK_NO is null");
            return (Criteria) this;
        }

        public Criteria andCheckNoIsNotNull() {
            addCriterion("CHECK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNoEqualTo(Integer value) {
            addCriterion("CHECK_NO =", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotEqualTo(Integer value) {
            addCriterion("CHECK_NO <>", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoGreaterThan(Integer value) {
            addCriterion("CHECK_NO >", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHECK_NO >=", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoLessThan(Integer value) {
            addCriterion("CHECK_NO <", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoLessThanOrEqualTo(Integer value) {
            addCriterion("CHECK_NO <=", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoIn(List<Integer> values) {
            addCriterion("CHECK_NO in", values, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotIn(List<Integer> values) {
            addCriterion("CHECK_NO not in", values, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_NO between", value1, value2, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_NO not between", value1, value2, "checkNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoIsNull() {
            addCriterion("SELECT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSelectNoIsNotNull() {
            addCriterion("SELECT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSelectNoEqualTo(Integer value) {
            addCriterion("SELECT_NO =", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoNotEqualTo(Integer value) {
            addCriterion("SELECT_NO <>", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoGreaterThan(Integer value) {
            addCriterion("SELECT_NO >", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SELECT_NO >=", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoLessThan(Integer value) {
            addCriterion("SELECT_NO <", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoLessThanOrEqualTo(Integer value) {
            addCriterion("SELECT_NO <=", value, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoIn(List<Integer> values) {
            addCriterion("SELECT_NO in", values, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoNotIn(List<Integer> values) {
            addCriterion("SELECT_NO not in", values, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoBetween(Integer value1, Integer value2) {
            addCriterion("SELECT_NO between", value1, value2, "selectNo");
            return (Criteria) this;
        }

        public Criteria andSelectNoNotBetween(Integer value1, Integer value2) {
            addCriterion("SELECT_NO not between", value1, value2, "selectNo");
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

        public Criteria andTnoIsNull() {
            addCriterion("TNO is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("TNO is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(String value) {
            addCriterion("TNO =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(String value) {
            addCriterion("TNO <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(String value) {
            addCriterion("TNO >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(String value) {
            addCriterion("TNO >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(String value) {
            addCriterion("TNO <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(String value) {
            addCriterion("TNO <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLike(String value) {
            addCriterion("TNO like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotLike(String value) {
            addCriterion("TNO not like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<String> values) {
            addCriterion("TNO in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<String> values) {
            addCriterion("TNO not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(String value1, String value2) {
            addCriterion("TNO between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(String value1, String value2) {
            addCriterion("TNO not between", value1, value2, "tno");
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