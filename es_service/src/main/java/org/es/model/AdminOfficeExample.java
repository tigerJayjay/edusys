package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminOfficeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminOfficeExample() {
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

        public Criteria andOfficeNoIsNull() {
            addCriterion("OFFICE_NO is null");
            return (Criteria) this;
        }

        public Criteria andOfficeNoIsNotNull() {
            addCriterion("OFFICE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeNoEqualTo(String value) {
            addCriterion("OFFICE_NO =", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoNotEqualTo(String value) {
            addCriterion("OFFICE_NO <>", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoGreaterThan(String value) {
            addCriterion("OFFICE_NO >", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoGreaterThanOrEqualTo(String value) {
            addCriterion("OFFICE_NO >=", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoLessThan(String value) {
            addCriterion("OFFICE_NO <", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoLessThanOrEqualTo(String value) {
            addCriterion("OFFICE_NO <=", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoLike(String value) {
            addCriterion("OFFICE_NO like", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoNotLike(String value) {
            addCriterion("OFFICE_NO not like", value, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoIn(List<String> values) {
            addCriterion("OFFICE_NO in", values, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoNotIn(List<String> values) {
            addCriterion("OFFICE_NO not in", values, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoBetween(String value1, String value2) {
            addCriterion("OFFICE_NO between", value1, value2, "officeNo");
            return (Criteria) this;
        }

        public Criteria andOfficeNoNotBetween(String value1, String value2) {
            addCriterion("OFFICE_NO not between", value1, value2, "officeNo");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
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

        public Criteria andLeaderNoIsNull() {
            addCriterion("LEADER_NO is null");
            return (Criteria) this;
        }

        public Criteria andLeaderNoIsNotNull() {
            addCriterion("LEADER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderNoEqualTo(String value) {
            addCriterion("LEADER_NO =", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoNotEqualTo(String value) {
            addCriterion("LEADER_NO <>", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoGreaterThan(String value) {
            addCriterion("LEADER_NO >", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoGreaterThanOrEqualTo(String value) {
            addCriterion("LEADER_NO >=", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoLessThan(String value) {
            addCriterion("LEADER_NO <", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoLessThanOrEqualTo(String value) {
            addCriterion("LEADER_NO <=", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoLike(String value) {
            addCriterion("LEADER_NO like", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoNotLike(String value) {
            addCriterion("LEADER_NO not like", value, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoIn(List<String> values) {
            addCriterion("LEADER_NO in", values, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoNotIn(List<String> values) {
            addCriterion("LEADER_NO not in", values, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoBetween(String value1, String value2) {
            addCriterion("LEADER_NO between", value1, value2, "leaderNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNoNotBetween(String value1, String value2) {
            addCriterion("LEADER_NO not between", value1, value2, "leaderNo");
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