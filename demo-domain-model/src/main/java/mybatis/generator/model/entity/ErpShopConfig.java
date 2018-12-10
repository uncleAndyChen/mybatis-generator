package mybatis.generator.model.entity;

public class ErpShopConfig {
    private Integer ID;

    private Integer shopID;

    private String mobile;

    private String email;

    private Integer isNotifyBalanceLess;

    private Integer balanceLessValue;

    private Integer isNotifyBeforeExpire;

    private Integer beforeDaysExpire;

    private Integer created;

    private Integer modified;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getIsNotifyBalanceLess() {
        return isNotifyBalanceLess;
    }

    public void setIsNotifyBalanceLess(Integer isNotifyBalanceLess) {
        this.isNotifyBalanceLess = isNotifyBalanceLess;
    }

    public Integer getBalanceLessValue() {
        return balanceLessValue;
    }

    public void setBalanceLessValue(Integer balanceLessValue) {
        this.balanceLessValue = balanceLessValue;
    }

    public Integer getIsNotifyBeforeExpire() {
        return isNotifyBeforeExpire;
    }

    public void setIsNotifyBeforeExpire(Integer isNotifyBeforeExpire) {
        this.isNotifyBeforeExpire = isNotifyBeforeExpire;
    }

    public Integer getBeforeDaysExpire() {
        return beforeDaysExpire;
    }

    public void setBeforeDaysExpire(Integer beforeDaysExpire) {
        this.beforeDaysExpire = beforeDaysExpire;
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
}