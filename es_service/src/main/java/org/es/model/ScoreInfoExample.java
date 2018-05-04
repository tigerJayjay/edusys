package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreInfoExample() {
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

        public Criteria andPaperScoreIsNull() {
            addCriterion("PAPER_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIsNotNull() {
            addCriterion("PAPER_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreEqualTo(Double value) {
            addCriterion("PAPER_SCORE =", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotEqualTo(Double value) {
            addCriterion("PAPER_SCORE <>", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThan(Double value) {
            addCriterion("PAPER_SCORE >", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("PAPER_SCORE >=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThan(Double value) {
            addCriterion("PAPER_SCORE <", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThanOrEqualTo(Double value) {
            addCriterion("PAPER_SCORE <=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIn(List<Double> values) {
            addCriterion("PAPER_SCORE in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotIn(List<Double> values) {
            addCriterion("PAPER_SCORE not in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreBetween(Double value1, Double value2) {
            addCriterion("PAPER_SCORE between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotBetween(Double value1, Double value2) {
            addCriterion("PAPER_SCORE not between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreIsNull() {
            addCriterion("MANI_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andManiScoreIsNotNull() {
            addCriterion("MANI_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andManiScoreEqualTo(Double value) {
            addCriterion("MANI_SCORE =", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreNotEqualTo(Double value) {
            addCriterion("MANI_SCORE <>", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreGreaterThan(Double value) {
            addCriterion("MANI_SCORE >", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("MANI_SCORE >=", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreLessThan(Double value) {
            addCriterion("MANI_SCORE <", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreLessThanOrEqualTo(Double value) {
            addCriterion("MANI_SCORE <=", value, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreIn(List<Double> values) {
            addCriterion("MANI_SCORE in", values, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreNotIn(List<Double> values) {
            addCriterion("MANI_SCORE not in", values, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreBetween(Double value1, Double value2) {
            addCriterion("MANI_SCORE between", value1, value2, "maniScore");
            return (Criteria) this;
        }

        public Criteria andManiScoreNotBetween(Double value1, Double value2) {
            addCriterion("MANI_SCORE not between", value1, value2, "maniScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("TOTAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("TOTAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Double value) {
            addCriterion("TOTAL_SCORE =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Double value) {
            addCriterion("TOTAL_SCORE <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Double value) {
            addCriterion("TOTAL_SCORE >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_SCORE >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Double value) {
            addCriterion("TOTAL_SCORE <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_SCORE <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Double> values) {
            addCriterion("TOTAL_SCORE in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Double> values) {
            addCriterion("TOTAL_SCORE not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Double value1, Double value2) {
            addCriterion("TOTAL_SCORE between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_SCORE not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andExamStatusIsNull() {
            addCriterion("EXAM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andExamStatusIsNotNull() {
            addCriterion("EXAM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andExamStatusEqualTo(Integer value) {
            addCriterion("EXAM_STATUS =", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotEqualTo(Integer value) {
            addCriterion("EXAM_STATUS <>", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusGreaterThan(Integer value) {
            addCriterion("EXAM_STATUS >", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_STATUS >=", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusLessThan(Integer value) {
            addCriterion("EXAM_STATUS <", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_STATUS <=", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusIn(List<Integer> values) {
            addCriterion("EXAM_STATUS in", values, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotIn(List<Integer> values) {
            addCriterion("EXAM_STATUS not in", values, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_STATUS between", value1, value2, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_STATUS not between", value1, value2, "examStatus");
            return (Criteria) this;
        }

        public Criteria andReexamIsNull() {
            addCriterion("REEXAM is null");
            return (Criteria) this;
        }

        public Criteria andReexamIsNotNull() {
            addCriterion("REEXAM is not null");
            return (Criteria) this;
        }

        public Criteria andReexamEqualTo(Double value) {
            addCriterion("REEXAM =", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamNotEqualTo(Double value) {
            addCriterion("REEXAM <>", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamGreaterThan(Double value) {
            addCriterion("REEXAM >", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamGreaterThanOrEqualTo(Double value) {
            addCriterion("REEXAM >=", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamLessThan(Double value) {
            addCriterion("REEXAM <", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamLessThanOrEqualTo(Double value) {
            addCriterion("REEXAM <=", value, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamIn(List<Double> values) {
            addCriterion("REEXAM in", values, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamNotIn(List<Double> values) {
            addCriterion("REEXAM not in", values, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamBetween(Double value1, Double value2) {
            addCriterion("REEXAM between", value1, value2, "reexam");
            return (Criteria) this;
        }

        public Criteria andReexamNotBetween(Double value1, Double value2) {
            addCriterion("REEXAM not between", value1, value2, "reexam");
            return (Criteria) this;
        }

        public Criteria andRebuildIsNull() {
            addCriterion("REBUILD is null");
            return (Criteria) this;
        }

        public Criteria andRebuildIsNotNull() {
            addCriterion("REBUILD is not null");
            return (Criteria) this;
        }

        public Criteria andRebuildEqualTo(Double value) {
            addCriterion("REBUILD =", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildNotEqualTo(Double value) {
            addCriterion("REBUILD <>", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildGreaterThan(Double value) {
            addCriterion("REBUILD >", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildGreaterThanOrEqualTo(Double value) {
            addCriterion("REBUILD >=", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildLessThan(Double value) {
            addCriterion("REBUILD <", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildLessThanOrEqualTo(Double value) {
            addCriterion("REBUILD <=", value, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildIn(List<Double> values) {
            addCriterion("REBUILD in", values, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildNotIn(List<Double> values) {
            addCriterion("REBUILD not in", values, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildBetween(Double value1, Double value2) {
            addCriterion("REBUILD between", value1, value2, "rebuild");
            return (Criteria) this;
        }

        public Criteria andRebuildNotBetween(Double value1, Double value2) {
            addCriterion("REBUILD not between", value1, value2, "rebuild");
            return (Criteria) this;
        }

        public Criteria andCoursenoIsNull() {
            addCriterion("COURSENO is null");
            return (Criteria) this;
        }

        public Criteria andCoursenoIsNotNull() {
            addCriterion("COURSENO is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenoEqualTo(String value) {
            addCriterion("COURSENO =", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoNotEqualTo(String value) {
            addCriterion("COURSENO <>", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoGreaterThan(String value) {
            addCriterion("COURSENO >", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoGreaterThanOrEqualTo(String value) {
            addCriterion("COURSENO >=", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoLessThan(String value) {
            addCriterion("COURSENO <", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoLessThanOrEqualTo(String value) {
            addCriterion("COURSENO <=", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoLike(String value) {
            addCriterion("COURSENO like", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoNotLike(String value) {
            addCriterion("COURSENO not like", value, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoIn(List<String> values) {
            addCriterion("COURSENO in", values, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoNotIn(List<String> values) {
            addCriterion("COURSENO not in", values, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoBetween(String value1, String value2) {
            addCriterion("COURSENO between", value1, value2, "courseno");
            return (Criteria) this;
        }

        public Criteria andCoursenoNotBetween(String value1, String value2) {
            addCriterion("COURSENO not between", value1, value2, "courseno");
            return (Criteria) this;
        }

        public Criteria andSnoIsNull() {
            addCriterion("SNO is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("SNO is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("SNO =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("SNO <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("SNO >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("SNO >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("SNO <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("SNO <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("SNO like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("SNO not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("SNO in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("SNO not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("SNO between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("SNO not between", value1, value2, "sno");
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