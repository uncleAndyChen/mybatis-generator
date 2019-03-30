package demo.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

public class CrmOrderNotGoodRateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrmOrderNotGoodRateExample() {
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

        public Criteria andOrderNGRIDIsNull() {
            addCriterion("orderNGRID is null");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDIsNotNull() {
            addCriterion("orderNGRID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDEqualTo(Integer value) {
            addCriterion("orderNGRID =", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDNotEqualTo(Integer value) {
            addCriterion("orderNGRID <>", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDGreaterThan(Integer value) {
            addCriterion("orderNGRID >", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNGRID >=", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDLessThan(Integer value) {
            addCriterion("orderNGRID <", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDLessThanOrEqualTo(Integer value) {
            addCriterion("orderNGRID <=", value, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDIn(List<Integer> values) {
            addCriterion("orderNGRID in", values, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDNotIn(List<Integer> values) {
            addCriterion("orderNGRID not in", values, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDBetween(Integer value1, Integer value2) {
            addCriterion("orderNGRID between", value1, value2, "orderNGRID");
            return (Criteria) this;
        }

        public Criteria andOrderNGRIDNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNGRID not between", value1, value2, "orderNGRID");
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNull() {
            addCriterion("numIid is null");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNotNull() {
            addCriterion("numIid is not null");
            return (Criteria) this;
        }

        public Criteria andNumIidEqualTo(Long value) {
            addCriterion("numIid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(Long value) {
            addCriterion("numIid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(Long value) {
            addCriterion("numIid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            addCriterion("numIid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(Long value) {
            addCriterion("numIid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(Long value) {
            addCriterion("numIid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<Long> values) {
            addCriterion("numIid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<Long> values) {
            addCriterion("numIid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(Long value1, Long value2) {
            addCriterion("numIid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(Long value1, Long value2) {
            addCriterion("numIid not between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentIsNull() {
            addCriterion("buyerRateContent is null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentIsNotNull() {
            addCriterion("buyerRateContent is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentEqualTo(String value) {
            addCriterion("buyerRateContent =", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentNotEqualTo(String value) {
            addCriterion("buyerRateContent <>", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentGreaterThan(String value) {
            addCriterion("buyerRateContent >", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentGreaterThanOrEqualTo(String value) {
            addCriterion("buyerRateContent >=", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentLessThan(String value) {
            addCriterion("buyerRateContent <", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentLessThanOrEqualTo(String value) {
            addCriterion("buyerRateContent <=", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentLike(String value) {
            addCriterion("buyerRateContent like", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentNotLike(String value) {
            addCriterion("buyerRateContent not like", value, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentIn(List<String> values) {
            addCriterion("buyerRateContent in", values, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentNotIn(List<String> values) {
            addCriterion("buyerRateContent not in", values, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentBetween(String value1, String value2) {
            addCriterion("buyerRateContent between", value1, value2, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateContentNotBetween(String value1, String value2) {
            addCriterion("buyerRateContent not between", value1, value2, "buyerRateContent");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultIsNull() {
            addCriterion("buyerRateResult is null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultIsNotNull() {
            addCriterion("buyerRateResult is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultEqualTo(Integer value) {
            addCriterion("buyerRateResult =", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultNotEqualTo(Integer value) {
            addCriterion("buyerRateResult <>", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultGreaterThan(Integer value) {
            addCriterion("buyerRateResult >", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyerRateResult >=", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultLessThan(Integer value) {
            addCriterion("buyerRateResult <", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultLessThanOrEqualTo(Integer value) {
            addCriterion("buyerRateResult <=", value, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultIn(List<Integer> values) {
            addCriterion("buyerRateResult in", values, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultNotIn(List<Integer> values) {
            addCriterion("buyerRateResult not in", values, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultBetween(Integer value1, Integer value2) {
            addCriterion("buyerRateResult between", value1, value2, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateResultNotBetween(Integer value1, Integer value2) {
            addCriterion("buyerRateResult not between", value1, value2, "buyerRateResult");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedIsNull() {
            addCriterion("buyerRateCreated is null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedIsNotNull() {
            addCriterion("buyerRateCreated is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedEqualTo(Integer value) {
            addCriterion("buyerRateCreated =", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedNotEqualTo(Integer value) {
            addCriterion("buyerRateCreated <>", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedGreaterThan(Integer value) {
            addCriterion("buyerRateCreated >", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyerRateCreated >=", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedLessThan(Integer value) {
            addCriterion("buyerRateCreated <", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("buyerRateCreated <=", value, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedIn(List<Integer> values) {
            addCriterion("buyerRateCreated in", values, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedNotIn(List<Integer> values) {
            addCriterion("buyerRateCreated not in", values, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedBetween(Integer value1, Integer value2) {
            addCriterion("buyerRateCreated between", value1, value2, "buyerRateCreated");
            return (Criteria) this;
        }

        public Criteria andBuyerRateCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("buyerRateCreated not between", value1, value2, "buyerRateCreated");
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