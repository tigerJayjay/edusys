package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class RoomUseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomUseInfoExample() {
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

        public Criteria andRoomNoIsNull() {
            addCriterion("ROOM_NO is null");
            return (Criteria) this;
        }

        public Criteria andRoomNoIsNotNull() {
            addCriterion("ROOM_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNoEqualTo(Integer value) {
            addCriterion("ROOM_NO =", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotEqualTo(Integer value) {
            addCriterion("ROOM_NO <>", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThan(Integer value) {
            addCriterion("ROOM_NO >", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROOM_NO >=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThan(Integer value) {
            addCriterion("ROOM_NO <", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThanOrEqualTo(Integer value) {
            addCriterion("ROOM_NO <=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoIn(List<Integer> values) {
            addCriterion("ROOM_NO in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotIn(List<Integer> values) {
            addCriterion("ROOM_NO not in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoBetween(Integer value1, Integer value2) {
            addCriterion("ROOM_NO between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ROOM_NO not between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andStartWeekIsNull() {
            addCriterion("START_WEEK is null");
            return (Criteria) this;
        }

        public Criteria andStartWeekIsNotNull() {
            addCriterion("START_WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andStartWeekEqualTo(Integer value) {
            addCriterion("START_WEEK =", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotEqualTo(Integer value) {
            addCriterion("START_WEEK <>", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekGreaterThan(Integer value) {
            addCriterion("START_WEEK >", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("START_WEEK >=", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekLessThan(Integer value) {
            addCriterion("START_WEEK <", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekLessThanOrEqualTo(Integer value) {
            addCriterion("START_WEEK <=", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekIn(List<Integer> values) {
            addCriterion("START_WEEK in", values, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotIn(List<Integer> values) {
            addCriterion("START_WEEK not in", values, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekBetween(Integer value1, Integer value2) {
            addCriterion("START_WEEK between", value1, value2, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("START_WEEK not between", value1, value2, "startWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekIsNull() {
            addCriterion("END_WEEK is null");
            return (Criteria) this;
        }

        public Criteria andEndWeekIsNotNull() {
            addCriterion("END_WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andEndWeekEqualTo(Integer value) {
            addCriterion("END_WEEK =", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotEqualTo(Integer value) {
            addCriterion("END_WEEK <>", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekGreaterThan(Integer value) {
            addCriterion("END_WEEK >", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("END_WEEK >=", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekLessThan(Integer value) {
            addCriterion("END_WEEK <", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekLessThanOrEqualTo(Integer value) {
            addCriterion("END_WEEK <=", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekIn(List<Integer> values) {
            addCriterion("END_WEEK in", values, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotIn(List<Integer> values) {
            addCriterion("END_WEEK not in", values, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekBetween(Integer value1, Integer value2) {
            addCriterion("END_WEEK between", value1, value2, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("END_WEEK not between", value1, value2, "endWeek");
            return (Criteria) this;
        }

        public Criteria andWeekthIsNull() {
            addCriterion("WEEKTH is null");
            return (Criteria) this;
        }

        public Criteria andWeekthIsNotNull() {
            addCriterion("WEEKTH is not null");
            return (Criteria) this;
        }

        public Criteria andWeekthEqualTo(Integer value) {
            addCriterion("WEEKTH =", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthNotEqualTo(Integer value) {
            addCriterion("WEEKTH <>", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthGreaterThan(Integer value) {
            addCriterion("WEEKTH >", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEEKTH >=", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthLessThan(Integer value) {
            addCriterion("WEEKTH <", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthLessThanOrEqualTo(Integer value) {
            addCriterion("WEEKTH <=", value, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthIn(List<Integer> values) {
            addCriterion("WEEKTH in", values, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthNotIn(List<Integer> values) {
            addCriterion("WEEKTH not in", values, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthBetween(Integer value1, Integer value2) {
            addCriterion("WEEKTH between", value1, value2, "weekth");
            return (Criteria) this;
        }

        public Criteria andWeekthNotBetween(Integer value1, Integer value2) {
            addCriterion("WEEKTH not between", value1, value2, "weekth");
            return (Criteria) this;
        }

        public Criteria andJieIsNull() {
            addCriterion("JIE is null");
            return (Criteria) this;
        }

        public Criteria andJieIsNotNull() {
            addCriterion("JIE is not null");
            return (Criteria) this;
        }

        public Criteria andJieEqualTo(String value) {
            addCriterion("JIE =", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotEqualTo(String value) {
            addCriterion("JIE <>", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieGreaterThan(String value) {
            addCriterion("JIE >", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieGreaterThanOrEqualTo(String value) {
            addCriterion("JIE >=", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLessThan(String value) {
            addCriterion("JIE <", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLessThanOrEqualTo(String value) {
            addCriterion("JIE <=", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLike(String value) {
            addCriterion("JIE like", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotLike(String value) {
            addCriterion("JIE not like", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieIn(List<String> values) {
            addCriterion("JIE in", values, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotIn(List<String> values) {
            addCriterion("JIE not in", values, "jie");
            return (Criteria) this;
        }

        public Criteria andJieBetween(String value1, String value2) {
            addCriterion("JIE between", value1, value2, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotBetween(String value1, String value2) {
            addCriterion("JIE not between", value1, value2, "jie");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
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