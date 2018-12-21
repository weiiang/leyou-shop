package com.leyou.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Order
 * @Description 订单实体类
 * @Author wq
 * @Date 2018/12/21 10:24
 * @Version 1.0.0
 */
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    private Long orderId;
    private Long totalPay;
    private Long actualPay;
    private String promotionIds;
    private Boolean paymentType;
    private Long postFee;
    private Date createTime;
    private String shippingName;
    private String shippingCode;
    private String userId;
    private String buyerMessage;
    private String buyerNick;
    private Boolean buyerRate;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverMobile;
    private String receiverZip;
    private String receiver;
    private Integer invoiceType;
    private Integer sourceType;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Long totalPay) {
        this.totalPay = totalPay;
    }

    public Long getActualPay() {
        return actualPay;
    }

    public void setActualPay(Long actualPay) {
        this.actualPay = actualPay;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    public Boolean getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Boolean paymentType) {
        this.paymentType = paymentType;
    }

    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Boolean getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Boolean buyerRate) {
        this.buyerRate = buyerRate;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
}
