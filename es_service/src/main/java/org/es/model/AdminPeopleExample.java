package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminPeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminPeopleExample() {
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

        public Criteria andJobNoIsNull() {
            addCriterion("JOB_NO is null");
            return (Criteria) this;
        }

        public Criteria andJobNoIsNotNull() {
            addCriterion("JOB_NO is not null");
            return (Criteria) this;
        }

        public Criteria andJobNoEqualTo(String value) {
            addCriterion("JOB_NO =", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotEqualTo(String value) {
            addCriterion("JOB_NO <>", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoGreaterThan(String value) {
            addCriterion("JOB_NO >", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_NO >=", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLessThan(String value) {
            addCriterion("JOB_NO <", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLessThanOrEqualTo(String value) {
            addCriterion("JOB_NO <=", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLike(String value) {
            addCriterion("JOB_NO like", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotLike(String value) {
            addCriterion("JOB_NO not like", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoIn(List<String> values) {
            addCriterion("JOB_NO in", values, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotIn(List<String> values) {
            addCriterion("JOB_NO not in", values, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoBetween(String value1, String value2) {
            addCriterion("JOB_NO between", value1, value2, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotBetween(String value1, String value2) {
            addCriterion("JOB_NO not between", value1, value2, "jobNo");
            return (Criteria) this;
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

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNull() {
            addCriterion("BIRTHDATE is null");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNotNull() {
            addCriterion("BIRTHDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdateEqualTo(Date value) {
            addCriterion("BIRTHDATE =", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotEqualTo(Date value) {
            addCriterion("BIRTHDATE <>", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThan(Date value) {
            addCriterion("BIRTHDATE >", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThanOrEqualTo(Date value) {
            addCriterion("BIRTHDATE >=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThan(Date value) {
            addCriterion("BIRTHDATE <", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThanOrEqualTo(Date value) {
            addCriterion("BIRTHDATE <=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateIn(List<Date> values) {
            addCriterion("BIRTHDATE in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotIn(List<Date> values) {
            addCriterion("BIRTHDATE not in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateBetween(Date value1, Date value2) {
            addCriterion("BIRTHDATE between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotBetween(Date value1, Date value2) {
            addCriterion("BIRTHDATE not between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNull() {
            addCriterion("NATIVEPLACE is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("NATIVEPLACE is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("NATIVEPLACE =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("NATIVEPLACE <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("NATIVEPLACE >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("NATIVEPLACE >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("NATIVEPLACE <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("NATIVEPLACE <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("NATIVEPLACE like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("NATIVEPLACE not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("NATIVEPLACE in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("NATIVEPLACE not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("NATIVEPLACE between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("NATIVEPLACE not between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNull() {
            addCriterion("ENTRYTIME is null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNotNull() {
            addCriterion("ENTRYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeEqualTo(Date value) {
            addCriterion("ENTRYTIME =", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotEqualTo(Date value) {
            addCriterion("ENTRYTIME <>", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThan(Date value) {
            addCriterion("ENTRYTIME >", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENTRYTIME >=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThan(Date value) {
            addCriterion("ENTRYTIME <", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThanOrEqualTo(Date value) {
            addCriterion("ENTRYTIME <=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIn(List<Date> values) {
            addCriterion("ENTRYTIME in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotIn(List<Date> values) {
            addCriterion("ENTRYTIME not in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeBetween(Date value1, Date value2) {
            addCriterion("ENTRYTIME between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotBetween(Date value1, Date value2) {
            addCriterion("ENTRYTIME not between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusIsNull() {
            addCriterion("MARITALSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusIsNotNull() {
            addCriterion("MARITALSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusEqualTo(Integer value) {
            addCriterion("MARITALSTATUS =", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusNotEqualTo(Integer value) {
            addCriterion("MARITALSTATUS <>", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusGreaterThan(Integer value) {
            addCriterion("MARITALSTATUS >", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("MARITALSTATUS >=", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusLessThan(Integer value) {
            addCriterion("MARITALSTATUS <", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusLessThanOrEqualTo(Integer value) {
            addCriterion("MARITALSTATUS <=", value, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusIn(List<Integer> values) {
            addCriterion("MARITALSTATUS in", values, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusNotIn(List<Integer> values) {
            addCriterion("MARITALSTATUS not in", values, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusBetween(Integer value1, Integer value2) {
            addCriterion("MARITALSTATUS between", value1, value2, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andMaritalstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("MARITALSTATUS not between", value1, value2, "maritalstatus");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNull() {
            addCriterion("POSITIONS is null");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNotNull() {
            addCriterion("POSITIONS is not null");
            return (Criteria) this;
        }

        public Criteria andPositionsEqualTo(String value) {
            addCriterion("POSITIONS =", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotEqualTo(String value) {
            addCriterion("POSITIONS <>", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThan(String value) {
            addCriterion("POSITIONS >", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThanOrEqualTo(String value) {
            addCriterion("POSITIONS >=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThan(String value) {
            addCriterion("POSITIONS <", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThanOrEqualTo(String value) {
            addCriterion("POSITIONS <=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLike(String value) {
            addCriterion("POSITIONS like", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotLike(String value) {
            addCriterion("POSITIONS not like", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsIn(List<String> values) {
            addCriterion("POSITIONS in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotIn(List<String> values) {
            addCriterion("POSITIONS not in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsBetween(String value1, String value2) {
            addCriterion("POSITIONS between", value1, value2, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotBetween(String value1, String value2) {
            addCriterion("POSITIONS not between", value1, value2, "positions");
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