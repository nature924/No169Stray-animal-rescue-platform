package com.entity.vo;

import com.entity.LiulangdongwuHuafeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物花费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu_huafei")
public class LiulangdongwuHuafeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 流浪动物
     */

    @TableField(value = "liulangdongwu_id")
    private Integer liulangdongwuId;


    /**
     * 流浪动物花费编号
     */

    @TableField(value = "liulangdongwu_huafei_uuid_number")
    private String liulangdongwuHuafeiUuidNumber;


    /**
     * 花费标题
     */

    @TableField(value = "liulangdongwu_huafei_name")
    private String liulangdongwuHuafeiName;


    /**
     * 附件
     */

    @TableField(value = "liulangdongwu_huafei_file")
    private String liulangdongwuHuafeiFile;


    /**
     * 消费类型
     */

    @TableField(value = "liulangdongwu_huafei_types")
    private Integer liulangdongwuHuafeiTypes;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huafei_time")
    private Date huafeiTime;


    /**
     * 花费缘由
     */

    @TableField(value = "liulangdongwu_huafei_content")
    private String liulangdongwuHuafeiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：流浪动物花费编号
	 */
    public String getLiulangdongwuHuafeiUuidNumber() {
        return liulangdongwuHuafeiUuidNumber;
    }


    /**
	 * 获取：流浪动物花费编号
	 */

    public void setLiulangdongwuHuafeiUuidNumber(String liulangdongwuHuafeiUuidNumber) {
        this.liulangdongwuHuafeiUuidNumber = liulangdongwuHuafeiUuidNumber;
    }
    /**
	 * 设置：花费标题
	 */
    public String getLiulangdongwuHuafeiName() {
        return liulangdongwuHuafeiName;
    }


    /**
	 * 获取：花费标题
	 */

    public void setLiulangdongwuHuafeiName(String liulangdongwuHuafeiName) {
        this.liulangdongwuHuafeiName = liulangdongwuHuafeiName;
    }
    /**
	 * 设置：附件
	 */
    public String getLiulangdongwuHuafeiFile() {
        return liulangdongwuHuafeiFile;
    }


    /**
	 * 获取：附件
	 */

    public void setLiulangdongwuHuafeiFile(String liulangdongwuHuafeiFile) {
        this.liulangdongwuHuafeiFile = liulangdongwuHuafeiFile;
    }
    /**
	 * 设置：消费类型
	 */
    public Integer getLiulangdongwuHuafeiTypes() {
        return liulangdongwuHuafeiTypes;
    }


    /**
	 * 获取：消费类型
	 */

    public void setLiulangdongwuHuafeiTypes(Integer liulangdongwuHuafeiTypes) {
        this.liulangdongwuHuafeiTypes = liulangdongwuHuafeiTypes;
    }
    /**
	 * 设置：花费时间
	 */
    public Date getHuafeiTime() {
        return huafeiTime;
    }


    /**
	 * 获取：花费时间
	 */

    public void setHuafeiTime(Date huafeiTime) {
        this.huafeiTime = huafeiTime;
    }
    /**
	 * 设置：花费缘由
	 */
    public String getLiulangdongwuHuafeiContent() {
        return liulangdongwuHuafeiContent;
    }


    /**
	 * 获取：花费缘由
	 */

    public void setLiulangdongwuHuafeiContent(String liulangdongwuHuafeiContent) {
        this.liulangdongwuHuafeiContent = liulangdongwuHuafeiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
