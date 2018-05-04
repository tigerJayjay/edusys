package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCousenoIsNull() {
            addCriterion("COUSENO is null");
            return (Criteria) this;
        }

        public Criteria andCousenoIsNotNull() {
            addCriterion("COUSENO is not null");
            return (Criteria) this;
        }

        public Criteria andCousenoEqualTo(Integer value) {
            addCriterion("COUSENO =", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoNotEqualTo(Integer value) {
            addCriterion("COUSENO <>", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoGreaterThan(Integer value) {
            addCriterion("COUSENO >", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("COUSENO >=", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoLessThan(Integer value) {
            addCriterion("COUSENO <", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoLessThanOrEqualTo(Integer value) {
            addCriterion("COUSENO <=", value, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoIn(List<Integer> values) {
            addCriterion("COUSENO in", values, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoNotIn(List<Integer> values) {
            addCriterion("COUSENO not in", values, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoBetween(Integer value1, Integer value2) {
            addCriterion("COUSENO between", value1, value2, "couseno");
            return (Criteria) this;
        }

        public Criteria andCousenoNotBetween(Integer value1, Integer value2) {
            addCriterion("COUSENO not between", value1, value2, "couseno");
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

        public Criteria andCourseNameIsNull() {
            addCriterion("COURSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("COURSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("COURSE_NAME =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("COURSE_NAME <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("COURSE_NAME >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("COURSE_NAME <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("COURSE_NAME like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("COURSE_NAME not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("COURSE_NAME in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("COURSE_NAME not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("COURSE_NAME between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("COURSE_NAME not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(String value) {
            addCriterion("CREDIT =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(String value) {
            addCriterion("CREDIT <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(String value) {
            addCriterion("CREDIT >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(String value) {
            addCriterion("CREDIT <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(String value) {
            addCriterion("CREDIT <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLike(String value) {
            addCriterion("CREDIT like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotLike(String value) {
            addCriterion("CREDIT not like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<String> values) {
            addCriterion("CREDIT in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<String> values) {
            addCriterion("CREDIT not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(String value1, String value2) {
            addCriterion("CREDIT between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(String value1, String value2) {
            addCriterion("CREDIT not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andWeektimeIsNull() {
            addCriterion("WEEKTIME is null");
            return (Criteria) this;
        }

        public Criteria andWeektimeIsNotNull() {
            addCriterion("WEEKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andWeektimeEqualTo(String value) {
            addCriterion("WEEKTIME =", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotEqualTo(String value) {
            addCriterion("WEEKTIME <>", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeGreaterThan(String value) {
            addCriterion("WEEKTIME >", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeGreaterThanOrEqualTo(String value) {
            addCriterion("WEEKTIME >=", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeLessThan(String value) {
            addCriterion("WEEKTIME <", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeLessThanOrEqualTo(String value) {
            addCriterion("WEEKTIME <=", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeLike(String value) {
            addCriterion("WEEKTIME like", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotLike(String value) {
            addCriterion("WEEKTIME not like", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeIn(List<String> values) {
            addCriterion("WEEKTIME in", values, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotIn(List<String> values) {
            addCriterion("WEEKTIME not in", values, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeBetween(String value1, String value2) {
            addCriterion("WEEKTIME between", value1, value2, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotBetween(String value1, String value2) {
            addCriterion("WEEKTIME not between", value1, value2, "weektime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeIsNull() {
            addCriterion("TOTALTIME is null");
            return (Criteria) this;
        }

        public Criteria andTotaltimeIsNotNull() {
            addCriterion("TOTALTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTotaltimeEqualTo(String value) {
            addCriterion("TOTALTIME =", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeNotEqualTo(String value) {
            addCriterion("TOTALTIME <>", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeGreaterThan(String value) {
            addCriterion("TOTALTIME >", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeGreaterThanOrEqualTo(String value) {
            addCriterion("TOTALTIME >=", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeLessThan(String value) {
            addCriterion("TOTALTIME <", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeLessThanOrEqualTo(String value) {
            addCriterion("TOTALTIME <=", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeLike(String value) {
            addCriterion("TOTALTIME like", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeNotLike(String value) {
            addCriterion("TOTALTIME not like", value, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeIn(List<String> values) {
            addCriterion("TOTALTIME in", values, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeNotIn(List<String> values) {
            addCriterion("TOTALTIME not in", values, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeBetween(String value1, String value2) {
            addCriterion("TOTALTIME between", value1, value2, "totaltime");
            return (Criteria) this;
        }

        public Criteria andTotaltimeNotBetween(String value1, String value2) {
            addCriterion("TOTALTIME not between", value1, value2, "totaltime");
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