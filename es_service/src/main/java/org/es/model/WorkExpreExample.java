package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkExpreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkExpreExample() {
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

        public Criteria andWorkerNoIsNull() {
            addCriterion("WORKER_NO is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNoIsNotNull() {
            addCriterion("WORKER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNoEqualTo(Integer value) {
            addCriterion("WORKER_NO =", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotEqualTo(Integer value) {
            addCriterion("WORKER_NO <>", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoGreaterThan(Integer value) {
            addCriterion("WORKER_NO >", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORKER_NO >=", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoLessThan(Integer value) {
            addCriterion("WORKER_NO <", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoLessThanOrEqualTo(Integer value) {
            addCriterion("WORKER_NO <=", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoIn(List<Integer> values) {
            addCriterion("WORKER_NO in", values, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotIn(List<Integer> values) {
            addCriterion("WORKER_NO not in", values, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoBetween(Integer value1, Integer value2) {
            addCriterion("WORKER_NO between", value1, value2, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotBetween(Integer value1, Integer value2) {
            addCriterion("WORKER_NO not between", value1, value2, "workerNo");
            return (Criteria) this;
        }

        public Criteria andComponyIsNull() {
            addCriterion("COMPONY is null");
            return (Criteria) this;
        }

        public Criteria andComponyIsNotNull() {
            addCriterion("COMPONY is not null");
            return (Criteria) this;
        }

        public Criteria andComponyEqualTo(String value) {
            addCriterion("COMPONY =", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyNotEqualTo(String value) {
            addCriterion("COMPONY <>", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyGreaterThan(String value) {
            addCriterion("COMPONY >", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyGreaterThanOrEqualTo(String value) {
            addCriterion("COMPONY >=", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyLessThan(String value) {
            addCriterion("COMPONY <", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyLessThanOrEqualTo(String value) {
            addCriterion("COMPONY <=", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyLike(String value) {
            addCriterion("COMPONY like", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyNotLike(String value) {
            addCriterion("COMPONY not like", value, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyIn(List<String> values) {
            addCriterion("COMPONY in", values, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyNotIn(List<String> values) {
            addCriterion("COMPONY not in", values, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyBetween(String value1, String value2) {
            addCriterion("COMPONY between", value1, value2, "compony");
            return (Criteria) this;
        }

        public Criteria andComponyNotBetween(String value1, String value2) {
            addCriterion("COMPONY not between", value1, value2, "compony");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("BEGINTIME is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("BEGINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterion("BEGINTIME =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterion("BEGINTIME <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterion("BEGINTIME >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGINTIME >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterion("BEGINTIME <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGINTIME <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterion("BEGINTIME in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterion("BEGINTIME not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterion("BEGINTIME between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGINTIME not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNull() {
            addCriterion("POSITIONs is null");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNotNull() {
            addCriterion("POSITIONs is not null");
            return (Criteria) this;
        }

        public Criteria andPositionsEqualTo(String value) {
            addCriterion("POSITIONs =", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotEqualTo(String value) {
            addCriterion("POSITIONs <>", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThan(String value) {
            addCriterion("POSITIONs >", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThanOrEqualTo(String value) {
            addCriterion("POSITIONs >=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThan(String value) {
            addCriterion("POSITIONs <", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThanOrEqualTo(String value) {
            addCriterion("POSITIONs <=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLike(String value) {
            addCriterion("POSITIONs like", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotLike(String value) {
            addCriterion("POSITIONs not like", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsIn(List<String> values) {
            addCriterion("POSITIONs in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotIn(List<String> values) {
            addCriterion("POSITIONs not in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsBetween(String value1, String value2) {
            addCriterion("POSITIONs between", value1, value2, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotBetween(String value1, String value2) {
            addCriterion("POSITIONs not between", value1, value2, "positions");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("DES is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("DES is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("DES =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("DES <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("DES >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("DES >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("DES <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("DES <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("DES like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("DES not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("DES in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("DES not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("DES between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("DES not between", value1, value2, "des");
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