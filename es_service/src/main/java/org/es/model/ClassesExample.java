package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassesExample() {
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

        public Criteria andClassNoIsNull() {
            addCriterion("CLASS_NO is null");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNotNull() {
            addCriterion("CLASS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andClassNoEqualTo(String value) {
            addCriterion("CLASS_NO =", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotEqualTo(String value) {
            addCriterion("CLASS_NO <>", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThan(String value) {
            addCriterion("CLASS_NO >", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NO >=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThan(String value) {
            addCriterion("CLASS_NO <", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NO <=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLike(String value) {
            addCriterion("CLASS_NO like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotLike(String value) {
            addCriterion("CLASS_NO not like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIn(List<String> values) {
            addCriterion("CLASS_NO in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotIn(List<String> values) {
            addCriterion("CLASS_NO not in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoBetween(String value1, String value2) {
            addCriterion("CLASS_NO between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotBetween(String value1, String value2) {
            addCriterion("CLASS_NO not between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoIsNull() {
            addCriterion("SPE_NO is null");
            return (Criteria) this;
        }

        public Criteria andSpeNoIsNotNull() {
            addCriterion("SPE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSpeNoEqualTo(String value) {
            addCriterion("SPE_NO =", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoNotEqualTo(String value) {
            addCriterion("SPE_NO <>", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoGreaterThan(String value) {
            addCriterion("SPE_NO >", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoGreaterThanOrEqualTo(String value) {
            addCriterion("SPE_NO >=", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoLessThan(String value) {
            addCriterion("SPE_NO <", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoLessThanOrEqualTo(String value) {
            addCriterion("SPE_NO <=", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoLike(String value) {
            addCriterion("SPE_NO like", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoNotLike(String value) {
            addCriterion("SPE_NO not like", value, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoIn(List<String> values) {
            addCriterion("SPE_NO in", values, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoNotIn(List<String> values) {
            addCriterion("SPE_NO not in", values, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoBetween(String value1, String value2) {
            addCriterion("SPE_NO between", value1, value2, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpeNoNotBetween(String value1, String value2) {
            addCriterion("SPE_NO not between", value1, value2, "speNo");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("SPECIALTY is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("SPECIALTY is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("SPECIALTY =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("SPECIALTY <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("SPECIALTY >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIALTY >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("SPECIALTY <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("SPECIALTY <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("SPECIALTY like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("SPECIALTY not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("SPECIALTY in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("SPECIALTY not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("SPECIALTY between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("SPECIALTY not between", value1, value2, "specialty");
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

        public Criteria andStucountIsNull() {
            addCriterion("STUCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andStucountIsNotNull() {
            addCriterion("STUCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andStucountEqualTo(Integer value) {
            addCriterion("STUCOUNT =", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotEqualTo(Integer value) {
            addCriterion("STUCOUNT <>", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountGreaterThan(Integer value) {
            addCriterion("STUCOUNT >", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUCOUNT >=", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountLessThan(Integer value) {
            addCriterion("STUCOUNT <", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountLessThanOrEqualTo(Integer value) {
            addCriterion("STUCOUNT <=", value, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountIn(List<Integer> values) {
            addCriterion("STUCOUNT in", values, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotIn(List<Integer> values) {
            addCriterion("STUCOUNT not in", values, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountBetween(Integer value1, Integer value2) {
            addCriterion("STUCOUNT between", value1, value2, "stucount");
            return (Criteria) this;
        }

        public Criteria andStucountNotBetween(Integer value1, Integer value2) {
            addCriterion("STUCOUNT not between", value1, value2, "stucount");
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