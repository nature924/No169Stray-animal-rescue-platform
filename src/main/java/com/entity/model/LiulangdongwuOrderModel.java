package com.entity.model;

import com.entity.LiulangdongwuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流浪动物领养
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiulangdongwuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请领养编号
     */
    private String liulangdongwuOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 流浪动物
     */
    private Integer liulangdongwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 快递公司
     */
    private String liulangdongwuOrderCourierName;


    /**
     * 快递单号
     */
    private String liulangdongwuOrderCourierNumber;


    /**
     * 领养状态
     */
    private Integer liulangdongwuOrderTypes;


    /**
     * 申请状态
     */
    private Integer liulangdongwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String liulangdongwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date liulangdongwuOrderShenheTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：申请领养编号
	 */
    public String getLiulangdongwuOrderUuidNumber() {
        return liulangdongwuOrderUuidNumber;
    }


    /**
	 * 设置：申请领养编号
	 */
    public void setLiulangdongwuOrderUuidNumber(String liulangdongwuOrderUuidNumber) {
        this.liulangdongwuOrderUuidNumber = liulangdongwuOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：流浪动物
	 */
    public Integer getLiulangdongwuId() {
        return liulangdongwuId;
    }


    /**
	 * 设置：流浪动物
	 */
    public void setLiulangdongwuId(Integer liulangdongwuId) {
        this.liulangdongwuId = liulangdongwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：快递公司
	 */
    public String getLiulangdongwuOrderCourierName() {
        return liulangdongwuOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setLiulangdongwuOrderCourierName(String liulangdongwuOrderCourierName) {
        this.liulangdongwuOrderCourierName = liulangdongwuOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getLiulangdongwuOrderCourierNumber() {
        return liulangdongwuOrderCourierNumber;
    }


    /**
	 * 设置：快递单号
	 */
    public void setLiulangdongwuOrderCourierNumber(String liulangdongwuOrderCourierNumber) {
        this.liulangdongwuOrderCourierNumber = liulangdongwuOrderCourierNumber;
    }
    /**
	 * 获取：领养状态
	 */
    public Integer getLiulangdongwuOrderTypes() {
        return liulangdongwuOrderTypes;
    }


    /**
	 * 设置：领养状态
	 */
    public void setLiulangdongwuOrderTypes(Integer liulangdongwuOrderTypes) {
        this.liulangdongwuOrderTypes = liulangdongwuOrderTypes;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getLiulangdongwuOrderYesnoTypes() {
        return liulangdongwuOrderYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setLiulangdongwuOrderYesnoTypes(Integer liulangdongwuOrderYesnoTypes) {
        this.liulangdongwuOrderYesnoTypes = liulangdongwuOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getLiulangdongwuOrderYesnoText() {
        return liulangdongwuOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setLiulangdongwuOrderYesnoText(String liulangdongwuOrderYesnoText) {
        this.liulangdongwuOrderYesnoText = liulangdongwuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLiulangdongwuOrderShenheTime() {
        return liulangdongwuOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setLiulangdongwuOrderShenheTime(Date liulangdongwuOrderShenheTime) {
        this.liulangdongwuOrderShenheTime = liulangdongwuOrderShenheTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
