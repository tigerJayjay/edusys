package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class ExamArrangementStatisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamArrangementStatisExample() {
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

        public Criteria andCourseNoIsNull() {
            addCriterion("COURSE_NO is null");
            return (Criteria) this;
        }

        public Criteria andCourseNoIsNotNull() {
            addCriterion("COURSE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNoEqualTo(String value) {
            addCriterion("COURSE_NO =", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotEqualTo(String value) {
            addCriterion("COURSE_NO <>", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoGreaterThan(String value) {
            addCriterion("COURSE_NO >", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_NO >=", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLessThan(String value) {
            addCriterion("COURSE_NO <", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLessThanOrEqualTo(String value) {
            addCriterion("COURSE_NO <=", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoLike(String value) {
            addCriterion("COURSE_NO like", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotLike(String value) {
            addCriterion("COURSE_NO not like", value, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoIn(List<String> values) {
            addCriterion("COURSE_NO in", values, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotIn(List<String> values) {
            addCriterion("COURSE_NO not in", values, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoBetween(String value1, String value2) {
            addCriterion("COURSE_NO between", value1, value2, "courseNo");
            return (Criteria) this;
        }

        public Criteria andCourseNoNotBetween(String value1, String value2) {
            addCriterion("COURSE_NO not between", value1, value2, "courseNo");
            return (Criteria) this;
        }

        public Criteria andTermtimeIsNull() {
            addCriterion("TERMTIME is null");
            return (Criteria) this;
        }

        public Criteria andTermtimeIsNotNull() {
            addCriterion("TERMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTermtimeEqualTo(Integer value) {
            addCriterion("TERMTIME =", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotEqualTo(Integer value) {
            addCriterion("TERMTIME <>", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeGreaterThan(Integer value) {
            addCriterion("TERMTIME >", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TERMTIME >=", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeLessThan(Integer value) {
            addCriterion("TERMTIME <", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeLessThanOrEqualTo(Integer value) {
            addCriterion("TERMTIME <=", value, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeIn(List<Integer> values) {
            addCriterion("TERMTIME in", values, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotIn(List<Integer> values) {
            addCriterion("TERMTIME not in", values, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeBetween(Integer value1, Integer value2) {
            addCriterion("TERMTIME between", value1, value2, "termtime");
            return (Criteria) this;
        }

        public Criteria andTermtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("TERMTIME not between", value1, value2, "termtime");
            return (Criteria) this;
        }

        public Criteria andYeartimeIsNull() {
            addCriterion("YEARTIME is null");
            return (Criteria) this;
        }

        public Criteria andYeartimeIsNotNull() {
            addCriterion("YEARTIME is not null");
            return (Criteria) this;
        }

        public Criteria andYeartimeEqualTo(String value) {
            addCriterion("YEARTIME =", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotEqualTo(String value) {
            addCriterion("YEARTIME <>", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeGreaterThan(String value) {
            addCriterion("YEARTIME >", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeGreaterThanOrEqualTo(String value) {
            addCriterion("YEARTIME >=", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLessThan(String value) {
            addCriterion("YEARTIME <", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLessThanOrEqualTo(String value) {
            addCriterion("YEARTIME <=", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeLike(String value) {
            addCriterion("YEARTIME like", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotLike(String value) {
            addCriterion("YEARTIME not like", value, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeIn(List<String> values) {
            addCriterion("YEARTIME in", values, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotIn(List<String> values) {
            addCriterion("YEARTIME not in", values, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeBetween(String value1, String value2) {
            addCriterion("YEARTIME between", value1, value2, "yeartime");
            return (Criteria) this;
        }

        public Criteria andYeartimeNotBetween(String value1, String value2) {
            addCriterion("YEARTIME not between", value1, value2, "yeartime");
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

        public Criteria andWeeknoIsNull() {
            addCriterion("WEEKNO is null");
            return (Criteria) this;
        }

        public Criteria andWeeknoIsNotNull() {
            addCriterion("WEEKNO is not null");
            return (Criteria) this;
        }

        public Criteria andWeeknoEqualTo(Integer value) {
            addCriterion("WEEKNO =", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoNotEqualTo(Integer value) {
            addCriterion("WEEKNO <>", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoGreaterThan(Integer value) {
            addCriterion("WEEKNO >", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEEKNO >=", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoLessThan(Integer value) {
            addCriterion("WEEKNO <", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoLessThanOrEqualTo(Integer value) {
            addCriterion("WEEKNO <=", value, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoIn(List<Integer> values) {
            addCriterion("WEEKNO in", values, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoNotIn(List<Integer> values) {
            addCriterion("WEEKNO not in", values, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoBetween(Integer value1, Integer value2) {
            addCriterion("WEEKNO between", value1, value2, "weekno");
            return (Criteria) this;
        }

        public Criteria andWeeknoNotBetween(Integer value1, Integer value2) {
            addCriterion("WEEKNO not between", value1, value2, "weekno");
            return (Criteria) this;
        }

        public Criteria andSchooltimeIsNull() {
            addCriterion("SCHOOLTIME is null");
            return (Criteria) this;
        }

        public Criteria andSchooltimeIsNotNull() {
            addCriterion("SCHOOLTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSchooltimeEqualTo(String value) {
            addCriterion("SCHOOLTIME =", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotEqualTo(String value) {
            addCriterion("SCHOOLTIME <>", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeGreaterThan(String value) {
            addCriterion("SCHOOLTIME >", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOLTIME >=", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLessThan(String value) {
            addCriterion("SCHOOLTIME <", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLessThanOrEqualTo(String value) {
            addCriterion("SCHOOLTIME <=", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLike(String value) {
            addCriterion("SCHOOLTIME like", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotLike(String value) {
            addCriterion("SCHOOLTIME not like", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeIn(List<String> values) {
            addCriterion("SCHOOLTIME in", values, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotIn(List<String> values) {
            addCriterion("SCHOOLTIME not in", values, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeBetween(String value1, String value2) {
            addCriterion("SCHOOLTIME between", value1, value2, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotBetween(String value1, String value2) {
            addCriterion("SCHOOLTIME not between", value1, value2, "schooltime");
            return (Criteria) this;
        }

        public Criteria andExamPlaceIsNull() {
            addCriterion("EXAM_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andExamPlaceIsNotNull() {
            addCriterion("EXAM_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andExamPlaceEqualTo(String value) {
            addCriterion("EXAM_PLACE =", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceNotEqualTo(String value) {
            addCriterion("EXAM_PLACE <>", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceGreaterThan(String value) {
            addCriterion("EXAM_PLACE >", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_PLACE >=", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceLessThan(String value) {
            addCriterion("EXAM_PLACE <", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceLessThanOrEqualTo(String value) {
            addCriterion("EXAM_PLACE <=", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceLike(String value) {
            addCriterion("EXAM_PLACE like", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceNotLike(String value) {
            addCriterion("EXAM_PLACE not like", value, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceIn(List<String> values) {
            addCriterion("EXAM_PLACE in", values, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceNotIn(List<String> values) {
            addCriterion("EXAM_PLACE not in", values, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceBetween(String value1, String value2) {
            addCriterion("EXAM_PLACE between", value1, value2, "examPlace");
            return (Criteria) this;
        }

        public Criteria andExamPlaceNotBetween(String value1, String value2) {
            addCriterion("EXAM_PLACE not between", value1, value2, "examPlace");
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