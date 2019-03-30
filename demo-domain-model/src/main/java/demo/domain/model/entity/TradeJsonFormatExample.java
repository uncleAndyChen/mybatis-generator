package demo.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TradeJsonFormatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeJsonFormatExample() {
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

        public Criteria andTradeJFIDIsNull() {
            addCriterion("tradeJFID is null");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDIsNotNull() {
            addCriterion("tradeJFID is not null");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDEqualTo(Integer value) {
            addCriterion("tradeJFID =", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDNotEqualTo(Integer value) {
            addCriterion("tradeJFID <>", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDGreaterThan(Integer value) {
            addCriterion("tradeJFID >", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("tradeJFID >=", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDLessThan(Integer value) {
            addCriterion("tradeJFID <", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDLessThanOrEqualTo(Integer value) {
            addCriterion("tradeJFID <=", value, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDIn(List<Integer> values) {
            addCriterion("tradeJFID in", values, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDNotIn(List<Integer> values) {
            addCriterion("tradeJFID not in", values, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDBetween(Integer value1, Integer value2) {
            addCriterion("tradeJFID between", value1, value2, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTradeJFIDNotBetween(Integer value1, Integer value2) {
            addCriterion("tradeJFID not between", value1, value2, "tradeJFID");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
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

        public Criteria andSyncTradeTypeIsNull() {
            addCriterion("syncTradeType is null");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeIsNotNull() {
            addCriterion("syncTradeType is not null");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeEqualTo(Integer value) {
            addCriterion("syncTradeType =", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeNotEqualTo(Integer value) {
            addCriterion("syncTradeType <>", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeGreaterThan(Integer value) {
            addCriterion("syncTradeType >", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("syncTradeType >=", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeLessThan(Integer value) {
            addCriterion("syncTradeType <", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("syncTradeType <=", value, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeIn(List<Integer> values) {
            addCriterion("syncTradeType in", values, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeNotIn(List<Integer> values) {
            addCriterion("syncTradeType not in", values, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeBetween(Integer value1, Integer value2) {
            addCriterion("syncTradeType between", value1, value2, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSyncTradeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("syncTradeType not between", value1, value2, "syncTradeType");
            return (Criteria) this;
        }

        public Criteria andSellerIDIsNull() {
            addCriterion("sellerID is null");
            return (Criteria) this;
        }

        public Criteria andSellerIDIsNotNull() {
            addCriterion("sellerID is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIDEqualTo(Long value) {
            addCriterion("sellerID =", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDNotEqualTo(Long value) {
            addCriterion("sellerID <>", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDGreaterThan(Long value) {
            addCriterion("sellerID >", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDGreaterThanOrEqualTo(Long value) {
            addCriterion("sellerID >=", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDLessThan(Long value) {
            addCriterion("sellerID <", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDLessThanOrEqualTo(Long value) {
            addCriterion("sellerID <=", value, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDIn(List<Long> values) {
            addCriterion("sellerID in", values, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDNotIn(List<Long> values) {
            addCriterion("sellerID not in", values, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDBetween(Long value1, Long value2) {
            addCriterion("sellerID between", value1, value2, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerIDNotBetween(Long value1, Long value2) {
            addCriterion("sellerID not between", value1, value2, "sellerID");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameIsNull() {
            addCriterion("sellerNickname is null");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameIsNotNull() {
            addCriterion("sellerNickname is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameEqualTo(String value) {
            addCriterion("sellerNickname =", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameNotEqualTo(String value) {
            addCriterion("sellerNickname <>", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameGreaterThan(String value) {
            addCriterion("sellerNickname >", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("sellerNickname >=", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameLessThan(String value) {
            addCriterion("sellerNickname <", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameLessThanOrEqualTo(String value) {
            addCriterion("sellerNickname <=", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameLike(String value) {
            addCriterion("sellerNickname like", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameNotLike(String value) {
            addCriterion("sellerNickname not like", value, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameIn(List<String> values) {
            addCriterion("sellerNickname in", values, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameNotIn(List<String> values) {
            addCriterion("sellerNickname not in", values, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameBetween(String value1, String value2) {
            addCriterion("sellerNickname between", value1, value2, "sellerNickname");
            return (Criteria) this;
        }

        public Criteria andSellerNicknameNotBetween(String value1, String value2) {
            addCriterion("sellerNickname not between", value1, value2, "sellerNickname");
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