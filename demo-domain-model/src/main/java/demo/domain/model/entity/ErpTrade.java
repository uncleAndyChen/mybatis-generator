package demo.domain.model.entity;

public class ErpTrade {
    private Integer tradeID;

    private Long tid;

    private Integer shopID;

    private Long memberID;

    private String buyerNick;

    private Long sellerID;

    public Integer getTradeID() {
        return tradeID;
    }

    public void setTradeID(Integer tradeID) {
        this.tradeID = tradeID;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }
}