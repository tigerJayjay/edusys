package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DegreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DegreeExample() {
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

        public Criteria andGraduationschoolIsNull() {
            addCriterion("GRADUATIONSCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolIsNotNull() {
            addCriterion("GRADUATIONSCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolEqualTo(String value) {
            addCriterion("GRADUATIONSCHOOL =", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolNotEqualTo(String value) {
            addCriterion("GRADUATIONSCHOOL <>", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolGreaterThan(String value) {
            addCriterion("GRADUATIONSCHOOL >", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolGreaterThanOrEqualTo(String value) {
            addCriterion("GRADUATIONSCHOOL >=", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolLessThan(String value) {
            addCriterion("GRADUATIONSCHOOL <", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolLessThanOrEqualTo(String value) {
            addCriterion("GRADUATIONSCHOOL <=", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolLike(String value) {
            addCriterion("GRADUATIONSCHOOL like", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolNotLike(String value) {
            addCriterion("GRADUATIONSCHOOL not like", value, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolIn(List<String> values) {
            addCriterion("GRADUATIONSCHOOL in", values, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolNotIn(List<String> values) {
            addCriterion("GRADUATIONSCHOOL not in", values, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolBetween(String value1, String value2) {
            addCriterion("GRADUATIONSCHOOL between", value1, value2, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduationschoolNotBetween(String value1, String value2) {
            addCriterion("GRADUATIONSCHOOL not between", value1, value2, "graduationschool");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeIsNull() {
            addCriterion("GRADUATIOINTIME is null");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeIsNotNull() {
            addCriterion("GRADUATIOINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeEqualTo(Date value) {
            addCriterion("GRADUATIOINTIME =", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeNotEqualTo(Date value) {
            addCriterion("GRADUATIOINTIME <>", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeGreaterThan(Date value) {
            addCriterion("GRADUATIOINTIME >", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GRADUATIOINTIME >=", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeLessThan(Date value) {
            addCriterion("GRADUATIOINTIME <", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeLessThanOrEqualTo(Date value) {
            addCriterion("GRADUATIOINTIME <=", value, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeIn(List<Date> values) {
            addCriterion("GRADUATIOINTIME in", values, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeNotIn(List<Date> values) {
            addCriterion("GRADUATIOINTIME not in", values, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeBetween(Date value1, Date value2) {
            addCriterion("GRADUATIOINTIME between", value1, value2, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andGraduatiointimeNotBetween(Date value1, Date value2) {
            addCriterion("GRADUATIOINTIME not between", value1, value2, "graduatiointime");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNull() {
            addCriterion("DEGREE is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("DEGREE is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(String value) {
            addCriterion("DEGREE =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(String value) {
            addCriterion("DEGREE <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(String value) {
            addCriterion("DEGREE >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("DEGREE >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(String value) {
            addCriterion("DEGREE <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(String value) {
            addCriterion("DEGREE <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLike(String value) {
            addCriterion("DEGREE like", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotLike(String value) {
            addCriterion("DEGREE not like", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<String> values) {
            addCriterion("DEGREE in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<String> values) {
            addCriterion("DEGREE not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(String value1, String value2) {
            addCriterion("DEGREE between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(String value1, String value2) {
            addCriterion("DEGREE not between", value1, value2, "degree");
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