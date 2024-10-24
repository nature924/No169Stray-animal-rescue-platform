package com.entity.vo;

import com.entity.LiulangdongwuJinkuangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物近况
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu_jinkuang")
public class LiulangdongwuJinkuangVO implements Serializable {
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
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 流浪动物近况编号
     */

    @TableField(value = "liulangdongwu_jinkuang_uuid_number")
    private String liulangdongwuJinkuangUuidNumber;


    /**
     * 近况标题
     */

    @TableField(value = "liulangdongwu_jinkuang_name")
    private String liulangdongwuJinkuangName;


    /**
     * 宠物照片
     */

    @TableField(value = "liulangdongwu_jinkuang_photo")
    private String liulangdongwuJinkuangPhoto;


    /**
     * 记录地点
     */

    @TableField(value = "liulangdongwu_jinkuang_address")
    private String liulangdongwuJinkuangAddress;


    /**
     * 流浪动物状态
     */

    @TableField(value = "liulangdongwu_jinkuang_types")
    private Integer liulangdongwuJinkuangTypes;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jilu_time")
    private Date jiluTime;


    /**
     * 近况详情
     */

    @TableField(value = "liulangdongwu_jinkuang_content")
    private String liulangdongwuJinkuangContent;


    /**
     * 录入时间
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
	 * 设置：流浪动物近况编号
	 */
    public String getLiulangdongwuJinkuangUuidNumber() {
        return liulangdongwuJinkuangUuidNumber;
    }


    /**
	 * 获取：流浪动物近况编号
	 */

    public void setLiulangdongwuJinkuangUuidNumber(String liulangdongwuJinkuangUuidNumber) {
        this.liulangdongwuJinkuangUuidNumber = liulangdongwuJinkuangUuidNumber;
    }
    /**
	 * 设置：近况标题
	 */
    public String getLiulangdongwuJinkuangName() {
        return liulangdongwuJinkuangName;
    }


    /**
	 * 获取：近况标题
	 */

    public void setLiulangdongwuJinkuangName(String liulangdongwuJinkuangName) {
        this.liulangdongwuJinkuangName = liulangdongwuJinkuangName;
    }
    /**
	 * 设置：宠物照片
	 */
    public String getLiulangdongwuJinkuangPhoto() {
        return liulangdongwuJinkuangPhoto;
    }


    /**
	 * 获取：宠物照片
	 */

    public void setLiulangdongwuJinkuangPhoto(String liulangdongwuJinkuangPhoto) {
        this.liulangdongwuJinkuangPhoto = liulangdongwuJinkuangPhoto;
    }
    /**
	 * 设置：记录地点
	 */
    public String getLiulangdongwuJinkuangAddress() {
        return liulangdongwuJinkuangAddress;
    }


    /**
	 * 获取：记录地点
	 */

    public void setLiulangdongwuJinkuangAddress(String liulangdongwuJinkuangAddress) {
        this.liulangdongwuJinkuangAddress = liulangdongwuJinkuangAddress;
    }
    /**
	 * 设置：流浪动物状态
	 */
    public Integer getLiulangdongwuJinkuangTypes() {
        return liulangdongwuJinkuangTypes;
    }


    /**
	 * 获取：流浪动物状态
	 */

    public void setLiulangdongwuJinkuangTypes(Integer liulangdongwuJinkuangTypes) {
        this.liulangdongwuJinkuangTypes = liulangdongwuJinkuangTypes;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getJiluTime() {
        return jiluTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setJiluTime(Date jiluTime) {
        this.jiluTime = jiluTime;
    }
    /**
	 * 设置：近况详情
	 */
    public String getLiulangdongwuJinkuangContent() {
        return liulangdongwuJinkuangContent;
    }


    /**
	 * 获取：近况详情
	 */

    public void setLiulangdongwuJinkuangContent(String liulangdongwuJinkuangContent) {
        this.liulangdongwuJinkuangContent = liulangdongwuJinkuangContent;
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
