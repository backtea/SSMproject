package com.gxa.p2p.business.domain;

import com.alibaba.fastjson.JSONObject;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bidrequest {

    private Long id;
    private Integer version = 1;//对象版本信息（用作乐观锁）
    private Byte bidrequesttype = SysConstant.BIDREQUEST_TYPE_NORMAL;//借款类型，在我们项目中，就是信用借款
    private Long bidrequeststate = 1l;//标的的状态，因为标的在一个时间只可能处于一种状态
    private BigDecimal bidrequestamount;//这个借款的金额
    private BigDecimal currentrate;//这个借款的利率
    private Byte monthes2return;//借款期限，就是这个借款的还款时间，单位是月，一般可供1~18选择
    private Integer bidcount = 0;//已经投标的次数
    private BigDecimal totalrewardamount = SysConstant.Totalrewardamount;// 总回报金额(总利息)
    private BigDecimal currentsum = SysConstant.ZERO;//当前已投标总金额
    private String title;
    private String description;
    private String note;//风控评审意见
    private Date disabledate;//招标截止日期
    private Long createuserId;//借款人id
    private Byte disabledays;//招标天数
    private BigDecimal minbidamount;//这个借款允许的最小的投标金额，默认是50；
    private Date applytime;//招标申请日期
    private Date publishtime;//发标时间
    private Byte returntype;
    private Logininfo createUser;//借款人
    Logininfo loginInfoToid = UserContext.getLoginInfo();

    public String getJsonString() {
        Map<String, Object> json = new HashMap<>();
        json.put("id", id);
        json.put("username", createUser.getUsername());
        json.put("title", title);
        json.put("bidRequestAmount", bidrequestamount);
        json.put("currentRate", currentrate);
        json.put("monthes2Return", monthes2return);
        json.put("returnType", getReturntype());
        json.put("totalRewardAmount", totalrewardamount);
        return JSONObject.toJSONString(json);
    }

    public Logininfo getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Logininfo createUser) {
        this.createUser = createUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Byte getBidrequesttype() {
        return bidrequesttype;
    }

    public void setBidrequesttype(Byte bidrequesttype) {
        this.bidrequesttype = bidrequesttype;
    }

    public Long getBidrequeststate() {
        return bidrequeststate;
    }

    public void setBidrequeststate(Long bidrequeststate) {
        this.bidrequeststate = bidrequeststate;
    }

    public BigDecimal getBidrequestamount() {
        return bidrequestamount;
    }

    public void setBidrequestamount(BigDecimal bidrequestamount) {
        this.bidrequestamount = bidrequestamount;
    }

    public BigDecimal getCurrentrate() {
        return currentrate;
    }

    public void setCurrentrate(BigDecimal currentrate) {
        this.currentrate = currentrate;
    }

    public Byte getMonthes2return() {
        return monthes2return;
    }

    public void setMonthes2return(Byte monthes2return) {
        this.monthes2return = monthes2return;
    }

    public Integer getBidcount() {
        return bidcount;
    }

    public void setBidcount(Integer bidcount) {
        this.bidcount = bidcount;
    }

    public BigDecimal getTotalrewardamount() {
        return totalrewardamount;
    }

    public void setTotalrewardamount(BigDecimal totalrewardamount) {
        this.totalrewardamount = totalrewardamount;
    }

    public BigDecimal getCurrentsum() {
        return currentsum;
    }

    public void setCurrentsum(BigDecimal currentsum) {
        this.currentsum = currentsum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getDisabledate() {
        return disabledate;
    }

    public void setDisabledate(Date disabledate) {
        this.disabledate = disabledate;
    }

    public Long getCreateuserId() {
        return loginInfoToid.getId();
    }

    public void setCreateuserId(Long createuserId) {
        this.createuserId = createuserId;
    }

    public Byte getDisabledays() {
        return disabledays;
    }

    public void setDisabledays(Byte disabledays) {
        this.disabledays = disabledays;
    }

    public BigDecimal getMinbidamount() {
        return minbidamount;
    }

    public void setMinbidamount(BigDecimal minbidamount) {
        this.minbidamount = minbidamount;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Byte getReturntype() {
        return returntype;
    }

    public void setReturntype(Byte returntype) {
        this.returntype = returntype;
    }
}