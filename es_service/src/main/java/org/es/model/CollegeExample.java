package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollegeExample() {
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

        public Criteria andColNoIsNull() {
            addCriterion("COL_NO is null");
            return (Criteria) this;
        }

        public Criteria andColNoIsNotNull() {
            addCriterion("COL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andColNoEqualTo(String value) {
            addCriterion("COL_NO =", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoNotEqualTo(String value) {
            addCriterion("COL_NO <>", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoGreaterThan(String value) {
            addCriterion("COL_NO >", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoGreaterThanOrEqualTo(String value) {
            addCriterion("COL_NO >=", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoLessThan(String value) {
            addCriterion("COL_NO <", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoLessThanOrEqualTo(String value) {
            addCriterion("COL_NO <=", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoLike(String value) {
            addCriterion("COL_NO like", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoNotLike(String value) {
            addCriterion("COL_NO not like", value, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoIn(List<String> values) {
            addCriterion("COL_NO in", values, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoNotIn(List<String> values) {
            addCriterion("COL_NO not in", values, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoBetween(String value1, String value2) {
            addCriterion("COL_NO between", value1, value2, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNoNotBetween(String value1, String value2) {
            addCriterion("COL_NO not between", value1, value2, "colNo");
            return (Criteria) this;
        }

        public Criteria andColNameIsNull() {
            addCriterion("COL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andColNameIsNotNull() {
            addCriterion("COL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andColNameEqualTo(String value) {
            addCriterion("COL_NAME =", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotEqualTo(String value) {
            addCriterion("COL_NAME <>", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThan(String value) {
            addCriterion("COL_NAME >", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThanOrEqualTo(String value) {
            addCriterion("COL_NAME >=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThan(String value) {
            addCriterion("COL_NAME <", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThanOrEqualTo(String value) {
            addCriterion("COL_NAME <=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLike(String value) {
            addCriterion("COL_NAME like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotLike(String value) {
            addCriterion("COL_NAME not like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameIn(List<String> values) {
            addCriterion("COL_NAME in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotIn(List<String> values) {
            addCriterion("COL_NAME not in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameBetween(String value1, String value2) {
            addCriterion("COL_NAME between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotBetween(String value1, String value2) {
            addCriterion("COL_NAME not between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("LEADER is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("LEADER is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("LEADER =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("LEADER <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("LEADER >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("LEADER >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("LEADER <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("LEADER <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("LEADER like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("LEADER not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("LEADER in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("LEADER not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("LEADER between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("LEADER not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNull() {
            addCriterion("BUILDTIME is null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNotNull() {
            addCriterion("BUILDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeEqualTo(Date value) {
            addCriterion("BUILDTIME =", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotEqualTo(Date value) {
            addCriterion("BUILDTIME <>", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThan(Date value) {
            addCriterion("BUILDTIME >", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BUILDTIME >=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThan(Date value) {
            addCriterion("BUILDTIME <", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThanOrEqualTo(Date value) {
            addCriterion("BUILDTIME <=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIn(List<Date> values) {
            addCriterion("BUILDTIME in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotIn(List<Date> values) {
            addCriterion("BUILDTIME not in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeBetween(Date value1, Date value2) {
            addCriterion("BUILDTIME between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotBetween(Date value1, Date value2) {
            addCriterion("BUILDTIME not between", value1, value2, "buildtime");
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