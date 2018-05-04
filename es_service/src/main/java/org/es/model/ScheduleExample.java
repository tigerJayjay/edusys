package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleExample() {
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

        public Criteria andScheNoIsNull() {
            addCriterion("SCHE_NO is null");
            return (Criteria) this;
        }

        public Criteria andScheNoIsNotNull() {
            addCriterion("SCHE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andScheNoEqualTo(String value) {
            addCriterion("SCHE_NO =", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotEqualTo(String value) {
            addCriterion("SCHE_NO <>", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoGreaterThan(String value) {
            addCriterion("SCHE_NO >", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoGreaterThanOrEqualTo(String value) {
            addCriterion("SCHE_NO >=", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLessThan(String value) {
            addCriterion("SCHE_NO <", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLessThanOrEqualTo(String value) {
            addCriterion("SCHE_NO <=", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoLike(String value) {
            addCriterion("SCHE_NO like", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotLike(String value) {
            addCriterion("SCHE_NO not like", value, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoIn(List<String> values) {
            addCriterion("SCHE_NO in", values, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotIn(List<String> values) {
            addCriterion("SCHE_NO not in", values, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoBetween(String value1, String value2) {
            addCriterion("SCHE_NO between", value1, value2, "scheNo");
            return (Criteria) this;
        }

        public Criteria andScheNoNotBetween(String value1, String value2) {
            addCriterion("SCHE_NO not between", value1, value2, "scheNo");
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

        public Criteria andPlaceIsNull() {
            addCriterion("PLACE is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("PLACE =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("PLACE <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("PLACE >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("PLACE >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("PLACE <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("PLACE <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("PLACE like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("PLACE not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("PLACE in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("PLACE not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("PLACE between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("PLACE not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andStartWeekIsNull() {
            addCriterion("START_WEEK is null");
            return (Criteria) this;
        }

        public Criteria andStartWeekIsNotNull() {
            addCriterion("START_WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andStartWeekEqualTo(Integer value) {
            addCriterion("START_WEEK =", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotEqualTo(Integer value) {
            addCriterion("START_WEEK <>", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekGreaterThan(Integer value) {
            addCriterion("START_WEEK >", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("START_WEEK >=", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekLessThan(Integer value) {
            addCriterion("START_WEEK <", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekLessThanOrEqualTo(Integer value) {
            addCriterion("START_WEEK <=", value, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekIn(List<Integer> values) {
            addCriterion("START_WEEK in", values, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotIn(List<Integer> values) {
            addCriterion("START_WEEK not in", values, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekBetween(Integer value1, Integer value2) {
            addCriterion("START_WEEK between", value1, value2, "startWeek");
            return (Criteria) this;
        }

        public Criteria andStartWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("START_WEEK not between", value1, value2, "startWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekIsNull() {
            addCriterion("END_WEEK is null");
            return (Criteria) this;
        }

        public Criteria andEndWeekIsNotNull() {
            addCriterion("END_WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andEndWeekEqualTo(Integer value) {
            addCriterion("END_WEEK =", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotEqualTo(Integer value) {
            addCriterion("END_WEEK <>", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekGreaterThan(Integer value) {
            addCriterion("END_WEEK >", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("END_WEEK >=", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekLessThan(Integer value) {
            addCriterion("END_WEEK <", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekLessThanOrEqualTo(Integer value) {
            addCriterion("END_WEEK <=", value, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekIn(List<Integer> values) {
            addCriterion("END_WEEK in", values, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotIn(List<Integer> values) {
            addCriterion("END_WEEK not in", values, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekBetween(Integer value1, Integer value2) {
            addCriterion("END_WEEK between", value1, value2, "endWeek");
            return (Criteria) this;
        }

        public Criteria andEndWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("END_WEEK not between", value1, value2, "endWeek");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("CAPACITY is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("CAPACITY is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("CAPACITY =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("CAPACITY <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("CAPACITY >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("CAPACITY <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("CAPACITY in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("CAPACITY not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andMarginIsNull() {
            addCriterion("MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andMarginIsNotNull() {
            addCriterion("MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andMarginEqualTo(Integer value) {
            addCriterion("MARGIN =", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotEqualTo(Integer value) {
            addCriterion("MARGIN <>", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThan(Integer value) {
            addCriterion("MARGIN >", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThanOrEqualTo(Integer value) {
            addCriterion("MARGIN >=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThan(Integer value) {
            addCriterion("MARGIN <", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThanOrEqualTo(Integer value) {
            addCriterion("MARGIN <=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginIn(List<Integer> values) {
            addCriterion("MARGIN in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotIn(List<Integer> values) {
            addCriterion("MARGIN not in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginBetween(Integer value1, Integer value2) {
            addCriterion("MARGIN between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotBetween(Integer value1, Integer value2) {
            addCriterion("MARGIN not between", value1, value2, "margin");
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

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("GRADE like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("GRADE not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
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

        public Criteria andJieIsNull() {
            addCriterion("JIE is null");
            return (Criteria) this;
        }

        public Criteria andJieIsNotNull() {
            addCriterion("JIE is not null");
            return (Criteria) this;
        }

        public Criteria andJieEqualTo(String value) {
            addCriterion("JIE =", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotEqualTo(String value) {
            addCriterion("JIE <>", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieGreaterThan(String value) {
            addCriterion("JIE >", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieGreaterThanOrEqualTo(String value) {
            addCriterion("JIE >=", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLessThan(String value) {
            addCriterion("JIE <", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLessThanOrEqualTo(String value) {
            addCriterion("JIE <=", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieLike(String value) {
            addCriterion("JIE like", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotLike(String value) {
            addCriterion("JIE not like", value, "jie");
            return (Criteria) this;
        }

        public Criteria andJieIn(List<String> values) {
            addCriterion("JIE in", values, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotIn(List<String> values) {
            addCriterion("JIE not in", values, "jie");
            return (Criteria) this;
        }

        public Criteria andJieBetween(String value1, String value2) {
            addCriterion("JIE between", value1, value2, "jie");
            return (Criteria) this;
        }

        public Criteria andJieNotBetween(String value1, String value2) {
            addCriterion("JIE not between", value1, value2, "jie");
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

        public Criteria andClassnoIsNull() {
            addCriterion("CLASSNO is null");
            return (Criteria) this;
        }

        public Criteria andClassnoIsNotNull() {
            addCriterion("CLASSNO is not null");
            return (Criteria) this;
        }

        public Criteria andClassnoEqualTo(String value) {
            addCriterion("CLASSNO =", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotEqualTo(String value) {
            addCriterion("CLASSNO <>", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoGreaterThan(String value) {
            addCriterion("CLASSNO >", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoGreaterThanOrEqualTo(String value) {
            addCriterion("CLASSNO >=", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoLessThan(String value) {
            addCriterion("CLASSNO <", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoLessThanOrEqualTo(String value) {
            addCriterion("CLASSNO <=", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoLike(String value) {
            addCriterion("CLASSNO like", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotLike(String value) {
            addCriterion("CLASSNO not like", value, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoIn(List<String> values) {
            addCriterion("CLASSNO in", values, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotIn(List<String> values) {
            addCriterion("CLASSNO not in", values, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoBetween(String value1, String value2) {
            addCriterion("CLASSNO between", value1, value2, "classno");
            return (Criteria) this;
        }

        public Criteria andClassnoNotBetween(String value1, String value2) {
            addCriterion("CLASSNO not between", value1, value2, "classno");
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