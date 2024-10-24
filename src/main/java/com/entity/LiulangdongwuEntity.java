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
 * 流浪动物
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu")
public class LiulangdongwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuEntity() {

	}

	public LiulangdongwuEntity(T t) {
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
     * 流浪动物名称
     */
    @ColumnInfo(comment="流浪动物名称",type="varchar(200)")
    @TableField(value = "liulangdongwu_name")

    private String liulangdongwuName;


    /**
     * 流浪动物照片
     */
    @ColumnInfo(comment="流浪动物照片",type="varchar(200)")
    @TableField(value = "liulangdongwu_photo")

    private String liulangdongwuPhoto;


    /**
     * 动物类型
     */
    @ColumnInfo(comment="动物类型",type="int(11)")
    @TableField(value = "liulangdongwu_types")

    private Integer liulangdongwuTypes;


    /**
     * 详细类型
     */
    @ColumnInfo(comment="详细类型",type="int(11)")
    @TableField(value = "liulangdongwu_erji_types")

    private Integer liulangdongwuErjiTypes;


    /**
     * 流浪动物年龄
     */
    @ColumnInfo(comment="流浪动物年龄",type="int(11)")
    @TableField(value = "liulangdongwu_age")

    private Integer liulangdongwuAge;


    /**
     * 疫苗接种
     */
    @ColumnInfo(comment="疫苗接种",type="varchar(11)")
    @TableField(value = "liulangdongwu_jiezhong")

    private String liulangdongwuJiezhong;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "xingbie_types")

    private Integer xingbieTypes;


    /**
     * 助养金
     */
    @ColumnInfo(comment="助养金",type="decimal(10,2)")
    @TableField(value = "liulangdongwu_zuyangjin")

    private Double liulangdongwuZuyangjin;


    /**
     * 动物介绍
     */
    @ColumnInfo(comment="动物介绍",type="text")
    @TableField(value = "liulangdongwu_content")

    private String liulangdongwuContent;


    /**
     * 动物状态
     */
    @ColumnInfo(comment="动物状态",type="int(11)")
    @TableField(value = "dongwu_zhuangtai_types")

    private Integer dongwuZhuangtaiTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "liulangdongwu_delete")

    private Integer liulangdongwuDelete;


    /**
     * 创建时间
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
	 * 获取：流浪动物名称
	 */
    public String getLiulangdongwuName() {
        return liulangdongwuName;
    }
    /**
	 * 设置：流浪动物名称
	 */

    public void setLiulangdongwuName(String liulangdongwuName) {
        this.liulangdongwuName = liulangdongwuName;
    }
    /**
	 * 获取：流浪动物照片
	 */
    public String getLiulangdongwuPhoto() {
        return liulangdongwuPhoto;
    }
    /**
	 * 设置：流浪动物照片
	 */

    public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
        this.liulangdongwuPhoto = liulangdongwuPhoto;
    }
    /**
	 * 获取：动物类型
	 */
    public Integer getLiulangdongwuTypes() {
        return liulangdongwuTypes;
    }
    /**
	 * 设置：动物类型
	 */

    public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
        this.liulangdongwuTypes = liulangdongwuTypes;
    }
    /**
	 * 获取：详细类型
	 */
    public Integer getLiulangdongwuErjiTypes() {
        return liulangdongwuErjiTypes;
    }
    /**
	 * 设置：详细类型
	 */

    public void setLiulangdongwuErjiTypes(Integer liulangdongwuErjiTypes) {
        this.liulangdongwuErjiTypes = liulangdongwuErjiTypes;
    }
    /**
	 * 获取：流浪动物年龄
	 */
    public Integer getLiulangdongwuAge() {
        return liulangdongwuAge;
    }
    /**
	 * 设置：流浪动物年龄
	 */

    public void setLiulangdongwuAge(Integer liulangdongwuAge) {
        this.liulangdongwuAge = liulangdongwuAge;
    }
    /**
	 * 获取：疫苗接种
	 */
    public String getLiulangdongwuJiezhong() {
        return liulangdongwuJiezhong;
    }
    /**
	 * 设置：疫苗接种
	 */

    public void setLiulangdongwuJiezhong(String liulangdongwuJiezhong) {
        this.liulangdongwuJiezhong = liulangdongwuJiezhong;
    }
    /**
	 * 获取：性别
	 */
    public Integer getXingbieTypes() {
        return xingbieTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setXingbieTypes(Integer xingbieTypes) {
        this.xingbieTypes = xingbieTypes;
    }
    /**
	 * 获取：助养金
	 */
    public Double getLiulangdongwuZuyangjin() {
        return liulangdongwuZuyangjin;
    }
    /**
	 * 设置：助养金
	 */

    public void setLiulangdongwuZuyangjin(Double liulangdongwuZuyangjin) {
        this.liulangdongwuZuyangjin = liulangdongwuZuyangjin;
    }
    /**
	 * 获取：动物介绍
	 */
    public String getLiulangdongwuContent() {
        return liulangdongwuContent;
    }
    /**
	 * 设置：动物介绍
	 */

    public void setLiulangdongwuContent(String liulangdongwuContent) {
        this.liulangdongwuContent = liulangdongwuContent;
    }
    /**
	 * 获取：动物状态
	 */
    public Integer getDongwuZhuangtaiTypes() {
        return dongwuZhuangtaiTypes;
    }
    /**
	 * 设置：动物状态
	 */

    public void setDongwuZhuangtaiTypes(Integer dongwuZhuangtaiTypes) {
        this.dongwuZhuangtaiTypes = dongwuZhuangtaiTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLiulangdongwuDelete() {
        return liulangdongwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
        this.liulangdongwuDelete = liulangdongwuDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Liulangdongwu{" +
            ", id=" + id +
            ", liulangdongwuName=" + liulangdongwuName +
            ", liulangdongwuPhoto=" + liulangdongwuPhoto +
            ", liulangdongwuTypes=" + liulangdongwuTypes +
            ", liulangdongwuErjiTypes=" + liulangdongwuErjiTypes +
            ", liulangdongwuAge=" + liulangdongwuAge +
            ", liulangdongwuJiezhong=" + liulangdongwuJiezhong +
            ", xingbieTypes=" + xingbieTypes +
            ", liulangdongwuZuyangjin=" + liulangdongwuZuyangjin +
            ", liulangdongwuContent=" + liulangdongwuContent +
            ", dongwuZhuangtaiTypes=" + dongwuZhuangtaiTypes +
            ", liulangdongwuDelete=" + liulangdongwuDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
