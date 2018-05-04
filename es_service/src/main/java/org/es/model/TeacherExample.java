package org.es.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andJobnoIsNull() {
            addCriterion("JOBNO is null");
            return (Criteria) this;
        }

        public Criteria andJobnoIsNotNull() {
            addCriterion("JOBNO is not null");
            return (Criteria) this;
        }

        public Criteria andJobnoEqualTo(String value) {
            addCriterion("JOBNO =", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoNotEqualTo(String value) {
            addCriterion("JOBNO <>", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoGreaterThan(String value) {
            addCriterion("JOBNO >", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoGreaterThanOrEqualTo(String value) {
            addCriterion("JOBNO >=", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoLessThan(String value) {
            addCriterion("JOBNO <", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoLessThanOrEqualTo(String value) {
            addCriterion("JOBNO <=", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoLike(String value) {
            addCriterion("JOBNO like", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoNotLike(String value) {
            addCriterion("JOBNO not like", value, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoIn(List<String> values) {
            addCriterion("JOBNO in", values, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoNotIn(List<String> values) {
            addCriterion("JOBNO not in", values, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoBetween(String value1, String value2) {
            addCriterion("JOBNO between", value1, value2, "jobno");
            return (Criteria) this;
        }

        public Criteria andJobnoNotBetween(String value1, String value2) {
            addCriterion("JOBNO not between", value1, value2, "jobno");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("TNAME is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("TNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("TNAME =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("TNAME <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("TNAME >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("TNAME >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("TNAME <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("TNAME <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("TNAME like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("TNAME not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("TNAME in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("TNAME not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("TNAME between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("TNAME not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
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

        public Criteria andMaxdegreeIsNull() {
            addCriterion("MAXDEGREE is null");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeIsNotNull() {
            addCriterion("MAXDEGREE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeEqualTo(String value) {
            addCriterion("MAXDEGREE =", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeNotEqualTo(String value) {
            addCriterion("MAXDEGREE <>", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeGreaterThan(String value) {
            addCriterion("MAXDEGREE >", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeGreaterThanOrEqualTo(String value) {
            addCriterion("MAXDEGREE >=", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeLessThan(String value) {
            addCriterion("MAXDEGREE <", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeLessThanOrEqualTo(String value) {
            addCriterion("MAXDEGREE <=", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeLike(String value) {
            addCriterion("MAXDEGREE like", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeNotLike(String value) {
            addCriterion("MAXDEGREE not like", value, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeIn(List<String> values) {
            addCriterion("MAXDEGREE in", values, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeNotIn(List<String> values) {
            addCriterion("MAXDEGREE not in", values, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeBetween(String value1, String value2) {
            addCriterion("MAXDEGREE between", value1, value2, "maxdegree");
            return (Criteria) this;
        }

        public Criteria andMaxdegreeNotBetween(String value1, String value2) {
            addCriterion("MAXDEGREE not between", value1, value2, "maxdegree");
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