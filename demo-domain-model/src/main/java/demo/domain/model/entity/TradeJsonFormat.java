package demo.domain.model.entity;

public class TradeJsonFormat {
    private Integer tradeJFID;

    private Long tid;

    private Integer shopID;

    private Integer syncTradeType;

    private Long sellerID;

    private String sellerNickname;

    private Integer created;

    private Integer modified;

    private String tradeBody;

    public Integer getTradeJFID() {
        return tradeJFID;
    }

    public void setTradeJFID(Integer tradeJFID) {
        this.tradeJFID = tradeJFID;
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

    public Integer getSyncTradeType() {
        return syncTradeType;
    }

    public void setSyncTradeType(Integer syncTradeType) {
        this.syncTradeType = syncTradeType;
    }

    public Long getSellerID() {
        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    public String getSellerNickname() {
        return sellerNickname;
    }

    public void setSellerNickname(String sellerNickname) {
        this.sellerNickname = sellerNickname == null ? null : sellerNickname.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public String getTradeBody() {
        return tradeBody;
    }

    public void setTradeBody(String tradeBody) {
        this.tradeBody = tradeBody == null ? null : tradeBody.trim();
    }
}