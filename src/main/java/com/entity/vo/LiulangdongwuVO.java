package com.entity.vo;

import com.entity.LiulangdongwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu")
public class LiulangdongwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 流浪动物名称
     */

    @TableField(value = "liulangdongwu_name")
    private String liulangdongwuName;


    /**
     * 流浪动物照片
     */

    @TableField(value = "liulangdongwu_photo")
    private String liulangdongwuPhoto;


    /**
     * 动物类型
     */

    @TableField(value = "liulangdongwu_types")
    private Integer liulangdongwuTypes;


    /**
     * 详细类型
     */

    @TableField(value = "liulangdongwu_erji_types")
    private Integer liulangdongwuErjiTypes;


    /**
     * 流浪动物年龄
     */

    @TableField(value = "liulangdongwu_age")
    private Integer liulangdongwuAge;


    /**
     * 疫苗接种
     */

    @TableField(value = "liulangdongwu_jiezhong")
    private String liulangdongwuJiezhong;


    /**
     * 性别
     */

    @TableField(value = "xingbie_types")
    private Integer xingbieTypes;


    /**
     * 助养金
     */

    @TableField(value = "liulangdongwu_zuyangjin")
    private Double liulangdongwuZuyangjin;


    /**
     * 动物介绍
     */

    @TableField(value = "liulangdongwu_content")
    private String liulangdongwuContent;


    /**
     * 动物状态
     */

    @TableField(value = "dongwu_zhuangtai_types")
    private Integer dongwuZhuangtaiTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "liulangdongwu_delete")
    private Integer liulangdongwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：流浪动物名称
	 */
    public String getLiulangdongwuName() {
        return liulangdongwuName;
    }


    /**
	 * 获取：流浪动物名称
	 */

    public void setLiulangdongwuName(String liulangdongwuName) {
        this.liulangdongwuName = liulangdongwuName;
    }
    /**
	 * 设置：流浪动物照片
	 */
    public String getLiulangdongwuPhoto() {
        return liulangdongwuPhoto;
    }


    /**
	 * 获取：流浪动物照片
	 */

    public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
        this.liulangdongwuPhoto = liulangdongwuPhoto;
    }
    /**
	 * 设置：动物类型
	 */
    public Integer getLiulangdongwuTypes() {
        return liulangdongwuTypes;
    }


    /**
	 * 获取：动物类型
	 */

    public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
        this.liulangdongwuTypes = liulangdongwuTypes;
    }
    /**
	 * 设置：详细类型
	 */
    public Integer getLiulangdongwuErjiTypes() {
        return liulangdongwuErjiTypes;
    }


    /**
	 * 获取：详细类型
	 */

    public void setLiulangdongwuErjiTypes(Integer liulangdongwuErjiTypes) {
        this.liulangdongwuErjiTypes = liulangdongwuErjiTypes;
    }
    /**
	 * 设置：流浪动物年龄
	 */
    public Integer getLiulangdongwuAge() {
        return liulangdongwuAge;
    }


    /**
	 * 获取：流浪动物年龄
	 */

    public void setLiulangdongwuAge(Integer liulangdongwuAge) {
        this.liulangdongwuAge = liulangdongwuAge;
    }
    /**
	 * 设置：疫苗接种
	 */
    public String getLiulangdongwuJiezhong() {
        return liulangdongwuJiezhong;
    }


    /**
	 * 获取：疫苗接种
	 */

    public void setLiulangdongwuJiezhong(String liulangdongwuJiezhong) {
        this.liulangdongwuJiezhong = liulangdongwuJiezhong;
    }
    /**
	 * 设置：性别
	 */
    public Integer getXingbieTypes() {
        return xingbieTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setXingbieTypes(Integer xingbieTypes) {
        this.xingbieTypes = xingbieTypes;
    }
    /**
	 * 设置：助养金
	 */
    public Double getLiulangdongwuZuyangjin() {
        return liulangdongwuZuyangjin;
    }


    /**
	 * 获取：助养金
	 */

    public void setLiulangdongwuZuyangjin(Double liulangdongwuZuyangjin) {
        this.liulangdongwuZuyangjin = liulangdongwuZuyangjin;
    }
    /**
	 * 设置：动物介绍
	 */
    public String getLiulangdongwuContent() {
        return liulangdongwuContent;
    }


    /**
	 * 获取：动物介绍
	 */

    public void setLiulangdongwuContent(String liulangdongwuContent) {
        this.liulangdongwuContent = liulangdongwuContent;
    }
    /**
	 * 设置：动物状态
	 */
    public Integer getDongwuZhuangtaiTypes() {
        return dongwuZhuangtaiTypes;
    }


    /**
	 * 获取：动物状态
	 */

    public void setDongwuZhuangtaiTypes(Integer dongwuZhuangtaiTypes) {
        this.dongwuZhuangtaiTypes = dongwuZhuangtaiTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLiulangdongwuDelete() {
        return liulangdongwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
        this.liulangdongwuDelete = liulangdongwuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
