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
 * 流浪动物花费
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_huafei")
public class LiulangdongwuHuafeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuHuafeiEntity() {

	}

	public LiulangdongwuHuafeiEntity(T t) {
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
     * 流浪动物花费编号
     */
    @ColumnInfo(comment="流浪动物花费编号",type="varchar(200)")
    @TableField(value = "liulangdongwu_huafei_uuid_number")

    private String liulangdongwuHuafeiUuidNumber;


    /**
     * 花费标题
     */
    @ColumnInfo(comment="花费标题",type="varchar(200)")
    @TableField(value = "liulangdongwu_huafei_name")

    private String liulangdongwuHuafeiName;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "liulangdongwu_huafei_file")

    private String liulangdongwuHuafeiFile;


    /**
     * 花费金额
     */
    @ColumnInfo(comment="花费金额",type="decimal(10,2)")
    @TableField(value = "liulangdongwu_huafei_money")

    private Double liulangdongwuHuafeiMoney;


    /**
     * 消费类型
     */
    @ColumnInfo(comment="消费类型",type="int(11)")
    @TableField(value = "liulangdongwu_huafei_types")

    private Integer liulangdongwuHuafeiTypes;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="花费时间",type="timestamp")
    @TableField(value = "huafei_time")

    private Date huafeiTime;


    /**
     * 花费缘由
     */
    @ColumnInfo(comment="花费缘由",type="longtext")
    @TableField(value = "liulangdongwu_huafei_content")

    private String liulangdongwuHuafeiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：流浪动物花费编号
	 */
    public String getLiulangdongwuHuafeiUuidNumber() {
        return liulangdongwuHuafeiUuidNumber;
    }
    /**
	 * 设置：流浪动物花费编号
	 */

    public void setLiulangdongwuHuafeiUuidNumber(String liulangdongwuHuafeiUuidNumber) {
        this.liulangdongwuHuafeiUuidNumber = liulangdongwuHuafeiUuidNumber;
    }
    /**
	 * 获取：花费标题
	 */
    public String getLiulangdongwuHuafeiName() {
        return liulangdongwuHuafeiName;
    }
    /**
	 * 设置：花费标题
	 */

    public void setLiulangdongwuHuafeiName(String liulangdongwuHuafeiName) {
        this.liulangdongwuHuafeiName = liulangdongwuHuafeiName;
    }
    /**
	 * 获取：附件
	 */
    public String getLiulangdongwuHuafeiFile() {
        return liulangdongwuHuafeiFile;
    }
    /**
	 * 设置：附件
	 */

    public void setLiulangdongwuHuafeiFile(String liulangdongwuHuafeiFile) {
        this.liulangdongwuHuafeiFile = liulangdongwuHuafeiFile;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getLiulangdongwuHuafeiMoney() {
        return liulangdongwuHuafeiMoney;
    }
    /**
	 * 设置：花费金额
	 */

    public void setLiulangdongwuHuafeiMoney(Double liulangdongwuHuafeiMoney) {
        this.liulangdongwuHuafeiMoney = liulangdongwuHuafeiMoney;
    }
    /**
	 * 获取：消费类型
	 */
    public Integer getLiulangdongwuHuafeiTypes() {
        return liulangdongwuHuafeiTypes;
    }
    /**
	 * 设置：消费类型
	 */

    public void setLiulangdongwuHuafeiTypes(Integer liulangdongwuHuafeiTypes) {
        this.liulangdongwuHuafeiTypes = liulangdongwuHuafeiTypes;
    }
    /**
	 * 获取：花费时间
	 */
    public Date getHuafeiTime() {
        return huafeiTime;
    }
    /**
	 * 设置：花费时间
	 */

    public void setHuafeiTime(Date huafeiTime) {
        this.huafeiTime = huafeiTime;
    }
    /**
	 * 获取：花费缘由
	 */
    public String getLiulangdongwuHuafeiContent() {
        return liulangdongwuHuafeiContent;
    }
    /**
	 * 设置：花费缘由
	 */

    public void setLiulangdongwuHuafeiContent(String liulangdongwuHuafeiContent) {
        this.liulangdongwuHuafeiContent = liulangdongwuHuafeiContent;
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
        return "LiulangdongwuHuafei{" +
            ", id=" + id +
            ", liulangdongwuId=" + liulangdongwuId +
            ", liulangdongwuHuafeiUuidNumber=" + liulangdongwuHuafeiUuidNumber +
            ", liulangdongwuHuafeiName=" + liulangdongwuHuafeiName +
            ", liulangdongwuHuafeiFile=" + liulangdongwuHuafeiFile +
            ", liulangdongwuHuafeiMoney=" + liulangdongwuHuafeiMoney +
            ", liulangdongwuHuafeiTypes=" + liulangdongwuHuafeiTypes +
            ", huafeiTime=" + DateUtil.convertString(huafeiTime,"yyyy-MM-dd") +
            ", liulangdongwuHuafeiContent=" + liulangdongwuHuafeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
