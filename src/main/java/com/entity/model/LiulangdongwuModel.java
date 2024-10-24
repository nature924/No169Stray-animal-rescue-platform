package com.entity.model;

import com.entity.LiulangdongwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流浪动物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiulangdongwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 流浪动物名称
     */
    private String liulangdongwuName;


    /**
     * 流浪动物照片
     */
    private String liulangdongwuPhoto;


    /**
     * 动物类型
     */
    private Integer liulangdongwuTypes;


    /**
     * 详细类型
     */
    private Integer liulangdongwuErjiTypes;


    /**
     * 流浪动物年龄
     */
    private Integer liulangdongwuAge;


    /**
     * 疫苗接种
     */
    private String liulangdongwuJiezhong;


    /**
     * 性别
     */
    private Integer xingbieTypes;


    /**
     * 助养金
     */
    private Double liulangdongwuZuyangjin;


    /**
     * 动物介绍
     */
    private String liulangdongwuContent;


    /**
     * 动物状态
     */
    private Integer dongwuZhuangtaiTypes;


    /**
     * 逻辑删除
     */
    private Integer liulangdongwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
