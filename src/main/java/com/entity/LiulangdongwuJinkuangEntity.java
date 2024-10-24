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
 * 流浪动物近况
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_jinkuang")
public class LiulangdongwuJinkuangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuJinkuangEntity() {

	}

	public LiulangdongwuJinkuangEntity(T t) {
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
     * 流浪动物近况编号
     */
    @ColumnInfo(comment="流浪动物近况编号",type="varchar(200)")
    @TableField(value = "liulangdongwu_jinkuang_uuid_number")

    private String liulangdongwuJinkuangUuidNumber;


    /**
     * 近况标题
     */
    @ColumnInfo(comment="近况标题",type="varchar(200)")
    @TableField(value = "liulangdongwu_jinkuang_name")

    private String liulangdongwuJinkuangName;


    /**
     * 宠物照片
     */
    @ColumnInfo(comment="宠物照片",type="varchar(200)")
    @TableField(value = "liulangdongwu_jinkuang_photo")

    private String liulangdongwuJinkuangPhoto;


    /**
     * 记录地点
     */
    @ColumnInfo(comment="记录地点",type="varchar(200)")
    @TableField(value = "liulangdongwu_jinkuang_address")

    private String liulangdongwuJinkuangAddress;


    /**
     * 流浪动物状态
     */
    @ColumnInfo(comment="流浪动物状态",type="int(11)")
    @TableField(value = "liulangdongwu_jinkuang_types")

    private Integer liulangdongwuJinkuangTypes;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="记录时间",type="timestamp")
    @TableField(value = "jilu_time")

    private Date jiluTime;


    /**
     * 近况详情
     */
    @ColumnInfo(comment="近况详情",type="longtext")
    @TableField(value = "liulangdongwu_jinkuang_content")

    private String liulangdongwuJinkuangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：流浪动物近况编号
	 */
    public String getLiulangdongwuJinkuangUuidNumber() {
        return liulangdongwuJinkuangUuidNumber;
    }
    /**
	 * 设置：流浪动物近况编号
	 */

    public void setLiulangdongwuJinkuangUuidNumber(String liulangdongwuJinkuangUuidNumber) {
        this.liulangdongwuJinkuangUuidNumber = liulangdongwuJinkuangUuidNumber;
    }
    /**
	 * 获取：近况标题
	 */
    public String getLiulangdongwuJinkuangName() {
        return liulangdongwuJinkuangName;
    }
    /**
	 * 设置：近况标题
	 */

    public void setLiulangdongwuJinkuangName(String liulangdongwuJinkuangName) {
        this.liulangdongwuJinkuangName = liulangdongwuJinkuangName;
    }
    /**
	 * 获取：宠物照片
	 */
    public String getLiulangdongwuJinkuangPhoto() {
        return liulangdongwuJinkuangPhoto;
    }
    /**
	 * 设置：宠物照片
	 */

    public void setLiulangdongwuJinkuangPhoto(String liulangdongwuJinkuangPhoto) {
        this.liulangdongwuJinkuangPhoto = liulangdongwuJinkuangPhoto;
    }
    /**
	 * 获取：记录地点
	 */
    public String getLiulangdongwuJinkuangAddress() {
        return liulangdongwuJinkuangAddress;
    }
    /**
	 * 设置：记录地点
	 */

    public void setLiulangdongwuJinkuangAddress(String liulangdongwuJinkuangAddress) {
        this.liulangdongwuJinkuangAddress = liulangdongwuJinkuangAddress;
    }
    /**
	 * 获取：流浪动物状态
	 */
    public Integer getLiulangdongwuJinkuangTypes() {
        return liulangdongwuJinkuangTypes;
    }
    /**
	 * 设置：流浪动物状态
	 */

    public void setLiulangdongwuJinkuangTypes(Integer liulangdongwuJinkuangTypes) {
        this.liulangdongwuJinkuangTypes = liulangdongwuJinkuangTypes;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }
    /**
	 * 设置：记录时间
	 */

    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 获取：近况详情
	 */
    public String getLiulangdongwuJinkuangContent() {
        return liulangdongwuJinkuangContent;
    }
    /**
	 * 设置：近况详情
	 */

    public void setLiulangdongwuJinkuangContent(String liulangdongwuJinkuangContent) {
        this.liulangdongwuJinkuangContent = liulangdongwuJinkuangContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LiulangdongwuJinkuang{" +
            ", id=" + id +
            ", liulangdongwuId=" + liulangdongwuId +
            ", yonghuId=" + yonghuId +
            ", liulangdongwuJinkuangUuidNumber=" + liulangdongwuJinkuangUuidNumber +
            ", liulangdongwuJinkuangName=" + liulangdongwuJinkuangName +
            ", liulangdongwuJinkuangPhoto=" + liulangdongwuJinkuangPhoto +
            ", liulangdongwuJinkuangAddress=" + liulangdongwuJinkuangAddress +
            ", liulangdongwuJinkuangTypes=" + liulangdongwuJinkuangTypes +
            ", jiluTime=" + DateUtil.convertString(jiluTime,"yyyy-MM-dd") +
            ", liulangdongwuJinkuangContent=" + liulangdongwuJinkuangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
