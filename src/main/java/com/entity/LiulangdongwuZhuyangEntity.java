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
 * 流浪动物助养
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_zhuyang")
public class LiulangdongwuZhuyangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuZhuyangEntity() {

	}

	public LiulangdongwuZhuyangEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 流浪动物
     */
    @ColumnInfo(comment="流浪动物",type="int(11)")
    @TableField(value = "liulangdongwu_id")

    private Integer liulangdongwuId;


    /**
     * 助养金额
     */
    @ColumnInfo(comment="助养金额",type="decimal(10,2)")
    @TableField(value = "liulangdongwu_zhuyang_money")

    private Double liulangdongwuZhuyangMoney;


    /**
     * 助养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="助养时间",type="timestamp")
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
	 * 获取：助养金额
	 */
    public Double getLiulangdongwuZhuyangMoney() {
        return liulangdongwuZhuyangMoney;
    }
    /**
	 * 设置：助养金额
	 */

    public void setLiulangdongwuZhuyangMoney(Double liulangdongwuZhuyangMoney) {
        this.liulangdongwuZhuyangMoney = liulangdongwuZhuyangMoney;
    }
    /**
	 * 获取：助养时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：助养时间
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
        return "LiulangdongwuZhuyang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", liulangdongwuId=" + liulangdongwuId +
            ", liulangdongwuZhuyangMoney=" + liulangdongwuZhuyangMoney +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
