package demo.domain.model.entity;

public class CrmOrderNotGoodRate {
    private Integer orderNGRID;

    private Integer shopID;

    private Long sellerID;

    private Long memberID;

    private Long tid;

    private Long oid;

    private Long numIid;

    private String buyerRateContent;

    private Integer buyerRateResult;

    private Integer buyerRateCreated;

    private Integer created;

    public Integer getOrderNGRID() {
        return orderNGRID;
    }

    public void setOrderNGRID(Integer orderNGRID) {
        this.orderNGRID = orderNGRID;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getBuyerRateContent() {
        return buyerRateContent;
    }

    public void setBuyerRateContent(String buyerRateContent) {
        this.buyerRateContent = buyerRateContent == null ? null : buyerRateContent.trim();
    }

    public Integer getBuyerRateResult() {
        return buyerRateResult;
    }

    public void setBuyerRateResult(Integer buyerRateResult) {
        this.buyerRateResult = buyerRateResult;
    }

    public Integer getBuyerRateCreated() {
        return buyerRateCreated;
    }

    public void setBuyerRateCreated(Integer buyerRateCreated) {
        this.buyerRateCreated = buyerRateCreated;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}