package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 流浪动物领养
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_order")
public class LiulangdongwuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuOrderEntity() {

	}

	public LiulangdongwuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 申请领养编号
     */
    @ColumnInfo(comment="申请领养编号",type="varchar(200)")
    @TableField(value = "liulangdongwu_order_uuid_number")

    private String liulangdongwuOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 流浪动物
     */
    @ColumnInfo(comment="流浪动物",type="int(11)")
    @TableField(value = "liulangdongwu_id")

    private Integer liulangdongwuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "liulangdongwu_order_courier_name")

    private String liulangdongwuOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "liulangdongwu_order_courier_number")

    private String liulangdongwuOrderCourierNumber;


    /**
     * 领养状态
     */
    @ColumnInfo(comment="领养状态",type="int(11)")
    @TableField(value = "liulangdongwu_order_types")

    private Integer liulangdongwuOrderTypes;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "liulangdongwu_order_yesno_types")

    private Integer liulangdongwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "liulangdongwu_order_yesno_text")

    private String liulangdongwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "liulangdongwu_order_shenhe_time")

    private Date liulangdongwuOrderShenheTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LiulangdongwuOrder{" +
            ", id=" + id +
            ", liulangdongwuOrderUuidNumber=" + liulangdongwuOrderUuidNumber +
            ", addressId=" + addressId +
            ", liulangdongwuId=" + liulangdongwuId +
            ", yonghuId=" + yonghuId +
            ", liulangdongwuOrderCourierName=" + liulangdongwuOrderCourierName +
            ", liulangdongwuOrderCourierNumber=" + liulangdongwuOrderCourierNumber +
            ", liulangdongwuOrderTypes=" + liulangdongwuOrderTypes +
            ", liulangdongwuOrderYesnoTypes=" + liulangdongwuOrderYesnoTypes +
            ", liulangdongwuOrderYesnoText=" + liulangdongwuOrderYesnoText +
            ", liulangdongwuOrderShenheTime=" + DateUtil.convertString(liulangdongwuOrderShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
