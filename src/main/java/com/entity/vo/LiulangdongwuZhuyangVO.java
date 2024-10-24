package com.entity.vo;

import com.entity.LiulangdongwuZhuyangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物助养
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu_zhuyang")
public class LiulangdongwuZhuyangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 流浪动物
     */

    @TableField(value = "liulangdongwu_id")
    private Integer liulangdongwuId;


    /**
     * 助养金额
     */

    @TableField(value = "liulangdongwu_zhuyang_money")
    private Double liulangdongwuZhuyangMoney;


    /**
     * 助养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：流浪动物
	 */
    public Integer getLiulangdongwuId() {
        return liulangdongwuId;
    }


    /**
	 * 获取：流浪动物
	 */

    public void setLiulangdongwuId(Integer liulangdongwuId) {
        this.liulangdongwuId = liulangdongwuId;
    }
    /**
	 * 设置：助养金额
	 */
    public Double getLiulangdongwuZhuyangMoney() {
        return liulangdongwuZhuyangMoney;
    }


    /**
	 * 获取：助养金额
	 */

    public void setLiulangdongwuZhuyangMoney(Double liulangdongwuZhuyangMoney) {
        this.liulangdongwuZhuyangMoney = liulangdongwuZhuyangMoney;
    }
    /**
	 * 设置：助养时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：助养时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
