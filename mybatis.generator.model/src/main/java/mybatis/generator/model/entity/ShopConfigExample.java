package mybatis.generator.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ShopConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopConfigExample() {
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andShopIDIsNull() {
            addCriterion("shopID is null");
            return (Criteria) this;
        }

        public Criteria andShopIDIsNotNull() {
            addCriterion("shopID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIDEqualTo(Integer value) {
            addCriterion("shopID =", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDNotEqualTo(Integer value) {
            addCriterion("shopID <>", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDGreaterThan(Integer value) {
            addCriterion("shopID >", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopID >=", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDLessThan(Integer value) {
            addCriterion("shopID <", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDLessThanOrEqualTo(Integer value) {
            addCriterion("shopID <=", value, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDIn(List<Integer> values) {
            addCriterion("shopID in", values, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDNotIn(List<Integer> values) {
            addCriterion("shopID not in", values, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDBetween(Integer value1, Integer value2) {
            addCriterion("shopID between", value1, value2, "shopID");
            return (Criteria) this;
        }

        public Criteria andShopIDNotBetween(Integer value1, Integer value2) {
            addCriterion("shopID not between", value1, value2, "shopID");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessIsNull() {
            addCriterion("isNotifyBalanceLess is null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessIsNotNull() {
            addCriterion("isNotifyBalanceLess is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessEqualTo(Integer value) {
            addCriterion("isNotifyBalanceLess =", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessNotEqualTo(Integer value) {
            addCriterion("isNotifyBalanceLess <>", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessGreaterThan(Integer value) {
            addCriterion("isNotifyBalanceLess >", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessGreaterThanOrEqualTo(Integer value) {
            addCriterion("isNotifyBalanceLess >=", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessLessThan(Integer value) {
            addCriterion("isNotifyBalanceLess <", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessLessThanOrEqualTo(Integer value) {
            addCriterion("isNotifyBalanceLess <=", value, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessIn(List<Integer> values) {
            addCriterion("isNotifyBalanceLess in", values, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessNotIn(List<Integer> values) {
            addCriterion("isNotifyBalanceLess not in", values, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessBetween(Integer value1, Integer value2) {
            addCriterion("isNotifyBalanceLess between", value1, value2, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBalanceLessNotBetween(Integer value1, Integer value2) {
            addCriterion("isNotifyBalanceLess not between", value1, value2, "isNotifyBalanceLess");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueIsNull() {
            addCriterion("balanceLessValue is null");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueIsNotNull() {
            addCriterion("balanceLessValue is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueEqualTo(Integer value) {
            addCriterion("balanceLessValue =", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueNotEqualTo(Integer value) {
            addCriterion("balanceLessValue <>", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueGreaterThan(Integer value) {
            addCriterion("balanceLessValue >", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("balanceLessValue >=", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueLessThan(Integer value) {
            addCriterion("balanceLessValue <", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueLessThanOrEqualTo(Integer value) {
            addCriterion("balanceLessValue <=", value, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueIn(List<Integer> values) {
            addCriterion("balanceLessValue in", values, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueNotIn(List<Integer> values) {
            addCriterion("balanceLessValue not in", values, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueBetween(Integer value1, Integer value2) {
            addCriterion("balanceLessValue between", value1, value2, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andBalanceLessValueNotBetween(Integer value1, Integer value2) {
            addCriterion("balanceLessValue not between", value1, value2, "balanceLessValue");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireIsNull() {
            addCriterion("isNotifyBeforeExpire is null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireIsNotNull() {
            addCriterion("isNotifyBeforeExpire is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireEqualTo(Integer value) {
            addCriterion("isNotifyBeforeExpire =", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireNotEqualTo(Integer value) {
            addCriterion("isNotifyBeforeExpire <>", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireGreaterThan(Integer value) {
            addCriterion("isNotifyBeforeExpire >", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("isNotifyBeforeExpire >=", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireLessThan(Integer value) {
            addCriterion("isNotifyBeforeExpire <", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireLessThanOrEqualTo(Integer value) {
            addCriterion("isNotifyBeforeExpire <=", value, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireIn(List<Integer> values) {
            addCriterion("isNotifyBeforeExpire in", values, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireNotIn(List<Integer> values) {
            addCriterion("isNotifyBeforeExpire not in", values, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireBetween(Integer value1, Integer value2) {
            addCriterion("isNotifyBeforeExpire between", value1, value2, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBeforeExpireNotBetween(Integer value1, Integer value2) {
            addCriterion("isNotifyBeforeExpire not between", value1, value2, "isNotifyBeforeExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireIsNull() {
            addCriterion("beforeDaysExpire is null");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireIsNotNull() {
            addCriterion("beforeDaysExpire is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireEqualTo(Integer value) {
            addCriterion("beforeDaysExpire =", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireNotEqualTo(Integer value) {
            addCriterion("beforeDaysExpire <>", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireGreaterThan(Integer value) {
            addCriterion("beforeDaysExpire >", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("beforeDaysExpire >=", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireLessThan(Integer value) {
            addCriterion("beforeDaysExpire <", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireLessThanOrEqualTo(Integer value) {
            addCriterion("beforeDaysExpire <=", value, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireIn(List<Integer> values) {
            addCriterion("beforeDaysExpire in", values, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireNotIn(List<Integer> values) {
            addCriterion("beforeDaysExpire not in", values, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireBetween(Integer value1, Integer value2) {
            addCriterion("beforeDaysExpire between", value1, value2, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andBeforeDaysExpireNotBetween(Integer value1, Integer value2) {
            addCriterion("beforeDaysExpire not between", value1, value2, "beforeDaysExpire");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Integer value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Integer value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Integer value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Integer value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Integer value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Integer> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Integer> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Integer value1, Integer value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("modified not between", value1, value2, "modified");
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