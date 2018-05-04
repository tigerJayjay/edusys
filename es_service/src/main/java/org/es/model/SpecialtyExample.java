package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialtyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialtyExample() {
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

        public Criteria andSpeNameIsNull() {
            addCriterion("SPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSpeNameIsNotNull() {
            addCriterion("SPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSpeNameEqualTo(String value) {
            addCriterion("SPE_NAME =", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotEqualTo(String value) {
            addCriterion("SPE_NAME <>", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameGreaterThan(String value) {
            addCriterion("SPE_NAME >", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameGreaterThanOrEqualTo(String value) {
            addCriterion("SPE_NAME >=", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLessThan(String value) {
            addCriterion("SPE_NAME <", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLessThanOrEqualTo(String value) {
            addCriterion("SPE_NAME <=", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameLike(String value) {
            addCriterion("SPE_NAME like", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotLike(String value) {
            addCriterion("SPE_NAME not like", value, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameIn(List<String> values) {
            addCriterion("SPE_NAME in", values, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotIn(List<String> values) {
            addCriterion("SPE_NAME not in", values, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameBetween(String value1, String value2) {
            addCriterion("SPE_NAME between", value1, value2, "speName");
            return (Criteria) this;
        }

        public Criteria andSpeNameNotBetween(String value1, String value2) {
            addCriterion("SPE_NAME not between", value1, value2, "speName");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("COLLEGE is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("COLLEGE is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("COLLEGE =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("COLLEGE <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("COLLEGE >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("COLLEGE >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("COLLEGE <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("COLLEGE <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("COLLEGE like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("COLLEGE not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("COLLEGE in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("COLLEGE not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("COLLEGE between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("COLLEGE not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andLenSchoolIsNull() {
            addCriterion("LEN_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andLenSchoolIsNotNull() {
            addCriterion("LEN_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andLenSchoolEqualTo(Integer value) {
            addCriterion("LEN_SCHOOL =", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolNotEqualTo(Integer value) {
            addCriterion("LEN_SCHOOL <>", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolGreaterThan(Integer value) {
            addCriterion("LEN_SCHOOL >", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEN_SCHOOL >=", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolLessThan(Integer value) {
            addCriterion("LEN_SCHOOL <", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolLessThanOrEqualTo(Integer value) {
            addCriterion("LEN_SCHOOL <=", value, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolIn(List<Integer> values) {
            addCriterion("LEN_SCHOOL in", values, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolNotIn(List<Integer> values) {
            addCriterion("LEN_SCHOOL not in", values, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolBetween(Integer value1, Integer value2) {
            addCriterion("LEN_SCHOOL between", value1, value2, "lenSchool");
            return (Criteria) this;
        }

        public Criteria andLenSchoolNotBetween(Integer value1, Integer value2) {
            addCriterion("LEN_SCHOOL not between", value1, value2, "lenSchool");
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