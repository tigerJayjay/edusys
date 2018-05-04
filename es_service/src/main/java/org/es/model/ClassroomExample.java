package org.es.model;

import java.util.ArrayList;
import java.util.List;

public class ClassroomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassroomExample() {
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

        public Criteria andBuildingnoIsNull() {
            addCriterion("BUILDINGNO is null");
            return (Criteria) this;
        }

        public Criteria andBuildingnoIsNotNull() {
            addCriterion("BUILDINGNO is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingnoEqualTo(String value) {
            addCriterion("BUILDINGNO =", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoNotEqualTo(String value) {
            addCriterion("BUILDINGNO <>", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoGreaterThan(String value) {
            addCriterion("BUILDINGNO >", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDINGNO >=", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoLessThan(String value) {
            addCriterion("BUILDINGNO <", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoLessThanOrEqualTo(String value) {
            addCriterion("BUILDINGNO <=", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoLike(String value) {
            addCriterion("BUILDINGNO like", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoNotLike(String value) {
            addCriterion("BUILDINGNO not like", value, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoIn(List<String> values) {
            addCriterion("BUILDINGNO in", values, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoNotIn(List<String> values) {
            addCriterion("BUILDINGNO not in", values, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoBetween(String value1, String value2) {
            addCriterion("BUILDINGNO between", value1, value2, "buildingno");
            return (Criteria) this;
        }

        public Criteria andBuildingnoNotBetween(String value1, String value2) {
            addCriterion("BUILDINGNO not between", value1, value2, "buildingno");
            return (Criteria) this;
        }

        public Criteria andTowernoIsNull() {
            addCriterion("TOWERNO is null");
            return (Criteria) this;
        }

        public Criteria andTowernoIsNotNull() {
            addCriterion("TOWERNO is not null");
            return (Criteria) this;
        }

        public Criteria andTowernoEqualTo(String value) {
            addCriterion("TOWERNO =", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoNotEqualTo(String value) {
            addCriterion("TOWERNO <>", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoGreaterThan(String value) {
            addCriterion("TOWERNO >", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoGreaterThanOrEqualTo(String value) {
            addCriterion("TOWERNO >=", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoLessThan(String value) {
            addCriterion("TOWERNO <", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoLessThanOrEqualTo(String value) {
            addCriterion("TOWERNO <=", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoLike(String value) {
            addCriterion("TOWERNO like", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoNotLike(String value) {
            addCriterion("TOWERNO not like", value, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoIn(List<String> values) {
            addCriterion("TOWERNO in", values, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoNotIn(List<String> values) {
            addCriterion("TOWERNO not in", values, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoBetween(String value1, String value2) {
            addCriterion("TOWERNO between", value1, value2, "towerno");
            return (Criteria) this;
        }

        public Criteria andTowernoNotBetween(String value1, String value2) {
            addCriterion("TOWERNO not between", value1, value2, "towerno");
            return (Criteria) this;
        }

        public Criteria andPlacenoIsNull() {
            addCriterion("PLACENO is null");
            return (Criteria) this;
        }

        public Criteria andPlacenoIsNotNull() {
            addCriterion("PLACENO is not null");
            return (Criteria) this;
        }

        public Criteria andPlacenoEqualTo(String value) {
            addCriterion("PLACENO =", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoNotEqualTo(String value) {
            addCriterion("PLACENO <>", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoGreaterThan(String value) {
            addCriterion("PLACENO >", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoGreaterThanOrEqualTo(String value) {
            addCriterion("PLACENO >=", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoLessThan(String value) {
            addCriterion("PLACENO <", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoLessThanOrEqualTo(String value) {
            addCriterion("PLACENO <=", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoLike(String value) {
            addCriterion("PLACENO like", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoNotLike(String value) {
            addCriterion("PLACENO not like", value, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoIn(List<String> values) {
            addCriterion("PLACENO in", values, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoNotIn(List<String> values) {
            addCriterion("PLACENO not in", values, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoBetween(String value1, String value2) {
            addCriterion("PLACENO between", value1, value2, "placeno");
            return (Criteria) this;
        }

        public Criteria andPlacenoNotBetween(String value1, String value2) {
            addCriterion("PLACENO not between", value1, value2, "placeno");
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