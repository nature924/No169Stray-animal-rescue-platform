package com.entity.model;

import com.entity.LiulangdongwuJinkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流浪动物近况
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiulangdongwuJinkuangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 流浪动物
     */
    private Integer liulangdongwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 流浪动物近况编号
     */
    private String liulangdongwuJinkuangUuidNumber;


    /**
     * 近况标题
     */
    private String liulangdongwuJinkuangName;


    /**
     * 宠物照片
     */
    private String liulangdongwuJinkuangPhoto;


    /**
     * 记录地点
     */
    private String liulangdongwuJinkuangAddress;


    /**
     * 流浪动物状态
     */
    private Integer liulangdongwuJinkuangTypes;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiluTime;


    /**
     * 近况详情
     */
    private String liulangdongwuJinkuangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
