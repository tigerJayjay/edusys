package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class BookOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookOrderExample() {
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

        public Criteria andBookNoIsNull() {
            addCriterion("BOOK_NO is null");
            return (Criteria) this;
        }

        public Criteria andBookNoIsNotNull() {
            addCriterion("BOOK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBookNoEqualTo(Integer value) {
            addCriterion("BOOK_NO =", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoNotEqualTo(Integer value) {
            addCriterion("BOOK_NO <>", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoGreaterThan(Integer value) {
            addCriterion("BOOK_NO >", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOK_NO >=", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoLessThan(Integer value) {
            addCriterion("BOOK_NO <", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoLessThanOrEqualTo(Integer value) {
            addCriterion("BOOK_NO <=", value, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoIn(List<Integer> values) {
            addCriterion("BOOK_NO in", values, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoNotIn(List<Integer> values) {
            addCriterion("BOOK_NO not in", values, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_NO between", value1, value2, "bookNo");
            return (Criteria) this;
        }

        public Criteria andBookNoNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_NO not between", value1, value2, "bookNo");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("NUMBER =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("NUMBER <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("NUMBER >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUMBER >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("NUMBER <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("NUMBER <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("NUMBER in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("NUMBER not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("NUMBER between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("NUMBER not between", value1, value2, "number");
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

        public Criteria andTotalPriceIsNull() {
            addCriterion("TOTAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("TOTAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("TOTAL_PRICE =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("TOTAL_PRICE <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("TOTAL_PRICE >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRICE >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("TOTAL_PRICE <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRICE <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("TOTAL_PRICE in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("TOTAL_PRICE not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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