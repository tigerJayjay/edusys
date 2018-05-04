package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class RecordInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordInfoExample() {
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

        public Criteria andRecordnoIsNull() {
            addCriterion("RECORDNO is null");
            return (Criteria) this;
        }

        public Criteria andRecordnoIsNotNull() {
            addCriterion("RECORDNO is not null");
            return (Criteria) this;
        }

        public Criteria andRecordnoEqualTo(String value) {
            addCriterion("RECORDNO =", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotEqualTo(String value) {
            addCriterion("RECORDNO <>", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoGreaterThan(String value) {
            addCriterion("RECORDNO >", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoGreaterThanOrEqualTo(String value) {
            addCriterion("RECORDNO >=", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoLessThan(String value) {
            addCriterion("RECORDNO <", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoLessThanOrEqualTo(String value) {
            addCriterion("RECORDNO <=", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoLike(String value) {
            addCriterion("RECORDNO like", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotLike(String value) {
            addCriterion("RECORDNO not like", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoIn(List<String> values) {
            addCriterion("RECORDNO in", values, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotIn(List<String> values) {
            addCriterion("RECORDNO not in", values, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoBetween(String value1, String value2) {
            addCriterion("RECORDNO between", value1, value2, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotBetween(String value1, String value2) {
            addCriterion("RECORDNO not between", value1, value2, "recordno");
            return (Criteria) this;
        }

        public Criteria andStuUniNoIsNull() {
            addCriterion("STU_UNI_NO is null");
            return (Criteria) this;
        }

        public Criteria andStuUniNoIsNotNull() {
            addCriterion("STU_UNI_NO is not null");
            return (Criteria) this;
        }

        public Criteria andStuUniNoEqualTo(String value) {
            addCriterion("STU_UNI_NO =", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoNotEqualTo(String value) {
            addCriterion("STU_UNI_NO <>", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoGreaterThan(String value) {
            addCriterion("STU_UNI_NO >", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoGreaterThanOrEqualTo(String value) {
            addCriterion("STU_UNI_NO >=", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoLessThan(String value) {
            addCriterion("STU_UNI_NO <", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoLessThanOrEqualTo(String value) {
            addCriterion("STU_UNI_NO <=", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoLike(String value) {
            addCriterion("STU_UNI_NO like", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoNotLike(String value) {
            addCriterion("STU_UNI_NO not like", value, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoIn(List<String> values) {
            addCriterion("STU_UNI_NO in", values, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoNotIn(List<String> values) {
            addCriterion("STU_UNI_NO not in", values, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoBetween(String value1, String value2) {
            addCriterion("STU_UNI_NO between", value1, value2, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andStuUniNoNotBetween(String value1, String value2) {
            addCriterion("STU_UNI_NO not between", value1, value2, "stuUniNo");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyIsNull() {
            addCriterion("SELECTIONKEY is null");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyIsNotNull() {
            addCriterion("SELECTIONKEY is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyEqualTo(String value) {
            addCriterion("SELECTIONKEY =", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyNotEqualTo(String value) {
            addCriterion("SELECTIONKEY <>", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyGreaterThan(String value) {
            addCriterion("SELECTIONKEY >", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyGreaterThanOrEqualTo(String value) {
            addCriterion("SELECTIONKEY >=", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyLessThan(String value) {
            addCriterion("SELECTIONKEY <", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyLessThanOrEqualTo(String value) {
            addCriterion("SELECTIONKEY <=", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyLike(String value) {
            addCriterion("SELECTIONKEY like", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyNotLike(String value) {
            addCriterion("SELECTIONKEY not like", value, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyIn(List<String> values) {
            addCriterion("SELECTIONKEY in", values, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyNotIn(List<String> values) {
            addCriterion("SELECTIONKEY not in", values, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyBetween(String value1, String value2) {
            addCriterion("SELECTIONKEY between", value1, value2, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andSelectionkeyNotBetween(String value1, String value2) {
            addCriterion("SELECTIONKEY not between", value1, value2, "selectionkey");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoIsNull() {
            addCriterion("ADMISSIONNO is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoIsNotNull() {
            addCriterion("ADMISSIONNO is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoEqualTo(String value) {
            addCriterion("ADMISSIONNO =", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoNotEqualTo(String value) {
            addCriterion("ADMISSIONNO <>", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoGreaterThan(String value) {
            addCriterion("ADMISSIONNO >", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoGreaterThanOrEqualTo(String value) {
            addCriterion("ADMISSIONNO >=", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoLessThan(String value) {
            addCriterion("ADMISSIONNO <", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoLessThanOrEqualTo(String value) {
            addCriterion("ADMISSIONNO <=", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoLike(String value) {
            addCriterion("ADMISSIONNO like", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoNotLike(String value) {
            addCriterion("ADMISSIONNO not like", value, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoIn(List<String> values) {
            addCriterion("ADMISSIONNO in", values, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoNotIn(List<String> values) {
            addCriterion("ADMISSIONNO not in", values, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoBetween(String value1, String value2) {
            addCriterion("ADMISSIONNO between", value1, value2, "admissionno");
            return (Criteria) this;
        }

        public Criteria andAdmissionnoNotBetween(String value1, String value2) {
            addCriterion("ADMISSIONNO not between", value1, value2, "admissionno");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(Integer value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(Integer value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(Integer value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(Integer value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(Integer value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<Integer> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<Integer> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(Integer value1, Integer value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNull() {
            addCriterion("IDNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNotNull() {
            addCriterion("IDNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andIdnumberEqualTo(String value) {
            addCriterion("IDNUMBER =", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotEqualTo(String value) {
            addCriterion("IDNUMBER <>", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThan(String value) {
            addCriterion("IDNUMBER >", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThanOrEqualTo(String value) {
            addCriterion("IDNUMBER >=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThan(String value) {
            addCriterion("IDNUMBER <", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThanOrEqualTo(String value) {
            addCriterion("IDNUMBER <=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLike(String value) {
            addCriterion("IDNUMBER like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotLike(String value) {
            addCriterion("IDNUMBER not like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberIn(List<String> values) {
            addCriterion("IDNUMBER in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotIn(List<String> values) {
            addCriterion("IDNUMBER not in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberBetween(String value1, String value2) {
            addCriterion("IDNUMBER between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotBetween(String value1, String value2) {
            addCriterion("IDNUMBER not between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andEduGradationIsNull() {
            addCriterion("EDU_GRADATION is null");
            return (Criteria) this;
        }

        public Criteria andEduGradationIsNotNull() {
            addCriterion("EDU_GRADATION is not null");
            return (Criteria) this;
        }

        public Criteria andEduGradationEqualTo(String value) {
            addCriterion("EDU_GRADATION =", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationNotEqualTo(String value) {
            addCriterion("EDU_GRADATION <>", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationGreaterThan(String value) {
            addCriterion("EDU_GRADATION >", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationGreaterThanOrEqualTo(String value) {
            addCriterion("EDU_GRADATION >=", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationLessThan(String value) {
            addCriterion("EDU_GRADATION <", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationLessThanOrEqualTo(String value) {
            addCriterion("EDU_GRADATION <=", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationLike(String value) {
            addCriterion("EDU_GRADATION like", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationNotLike(String value) {
            addCriterion("EDU_GRADATION not like", value, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationIn(List<String> values) {
            addCriterion("EDU_GRADATION in", values, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationNotIn(List<String> values) {
            addCriterion("EDU_GRADATION not in", values, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationBetween(String value1, String value2) {
            addCriterion("EDU_GRADATION between", value1, value2, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andEduGradationNotBetween(String value1, String value2) {
            addCriterion("EDU_GRADATION not between", value1, value2, "eduGradation");
            return (Criteria) this;
        }

        public Criteria andNativespaceIsNull() {
            addCriterion("NATIVESPACE is null");
            return (Criteria) this;
        }

        public Criteria andNativespaceIsNotNull() {
            addCriterion("NATIVESPACE is not null");
            return (Criteria) this;
        }

        public Criteria andNativespaceEqualTo(String value) {
            addCriterion("NATIVESPACE =", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceNotEqualTo(String value) {
            addCriterion("NATIVESPACE <>", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceGreaterThan(String value) {
            addCriterion("NATIVESPACE >", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceGreaterThanOrEqualTo(String value) {
            addCriterion("NATIVESPACE >=", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceLessThan(String value) {
            addCriterion("NATIVESPACE <", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceLessThanOrEqualTo(String value) {
            addCriterion("NATIVESPACE <=", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceLike(String value) {
            addCriterion("NATIVESPACE like", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceNotLike(String value) {
            addCriterion("NATIVESPACE not like", value, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceIn(List<String> values) {
            addCriterion("NATIVESPACE in", values, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceNotIn(List<String> values) {
            addCriterion("NATIVESPACE not in", values, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceBetween(String value1, String value2) {
            addCriterion("NATIVESPACE between", value1, value2, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNativespaceNotBetween(String value1, String value2) {
            addCriterion("NATIVESPACE not between", value1, value2, "nativespace");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("NATION is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("NATION is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("NATION =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("NATION <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("NATION >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("NATION >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("NATION <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("NATION <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("NATION like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("NATION not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("NATION in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("NATION not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("NATION between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("NATION not between", value1, value2, "nation");
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