package mybatis.generator.model.entity;

import java.util.ArrayList;
import java.util.List;

public class erpTradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public erpTradeExample() {
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

        public Criteria andTradeIDIsNull() {
            addCriterion("tradeID is null");
            return (Criteria) this;
        }

        public Criteria andTradeIDIsNotNull() {
            addCriterion("tradeID is not null");
            return (Criteria) this;
        }

        public Criteria andTradeIDEqualTo(Integer value) {
            addCriterion("tradeID =", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDNotEqualTo(Integer value) {
            addCriterion("tradeID <>", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDGreaterThan(Integer value) {
            addCriterion("tradeID >", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("tradeID >=", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDLessThan(Integer value) {
            addCriterion("tradeID <", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDLessThanOrEqualTo(Integer value) {
            addCriterion("tradeID <=", value, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDIn(List<Integer> values) {
            addCriterion("tradeID in", values, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDNotIn(List<Integer> values) {
            addCriterion("tradeID not in", values, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDBetween(Integer value1, Integer value2) {
            addCriterion("tradeID between", value1, value2, "tradeID");
            return (Criteria) this;
        }

        public Criteria andTradeIDNotBetween(Integer value1, Integer value2) {
            addCriterion("tradeID not between", value1, value2, "tradeID");
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

        public Criteria andMemberIDIsNull() {
            addCriterion("memberID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIDIsNotNull() {
            addCriterion("memberID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIDEqualTo(Long value) {
            addCriterion("memberID =", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDNotEqualTo(Long value) {
            addCriterion("memberID <>", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDGreaterThan(Long value) {
            addCriterion("memberID >", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDGreaterThanOrEqualTo(Long value) {
            addCriterion("memberID >=", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDLessThan(Long value) {
            addCriterion("memberID <", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDLessThanOrEqualTo(Long value) {
            addCriterion("memberID <=", value, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDIn(List<Long> values) {
            addCriterion("memberID in", values, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDNotIn(List<Long> values) {
            addCriterion("memberID not in", values, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDBetween(Long value1, Long value2) {
            addCriterion("memberID between", value1, value2, "memberID");
            return (Criteria) this;
        }

        public Criteria andMemberIDNotBetween(Long value1, Long value2) {
            addCriterion("memberID not between", value1, value2, "memberID");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNull() {
            addCriterion("buyerNick is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNotNull() {
            addCriterion("buyerNick is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickEqualTo(String value) {
            addCriterion("buyerNick =", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotEqualTo(String value) {
            addCriterion("buyerNick <>", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThan(String value) {
            addCriterion("buyerNick >", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("buyerNick >=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThan(String value) {
            addCriterion("buyerNick <", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("buyerNick <=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLike(String value) {
            addCriterion("buyerNick like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotLike(String value) {
            addCriterion("buyerNick not like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIn(List<String> values) {
            addCriterion("buyerNick in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotIn(List<String> values) {
            addCriterion("buyerNick not in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickBetween(String value1, String value2) {
            addCriterion("buyerNick between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotBetween(String value1, String value2) {
            addCriterion("buyerNick not between", value1, value2, "buyerNick");
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