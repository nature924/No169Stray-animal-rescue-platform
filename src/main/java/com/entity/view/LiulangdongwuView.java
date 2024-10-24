package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiulangdongwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 流浪动物
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liulangdongwu")
public class LiulangdongwuView extends LiulangdongwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 动物类型的值
	*/
	@ColumnInfo(comment="动物类型的字典表值",type="varchar(200)")
	private String liulangdongwuValue;
	/**
	* 详细类型的值
	*/
	@ColumnInfo(comment="详细类型的字典表值",type="varchar(200)")
	private String liulangdongwuErjiValue;
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String xingbieValue;
	/**
	* 动物状态的值
	*/
	@ColumnInfo(comment="动物状态的字典表值",type="varchar(200)")
	private String dongwuZhuangtaiValue;




	public LiulangdongwuView() {

	}

	public LiulangdongwuView(LiulangdongwuEntity liulangdongwuEntity) {
		try {
			BeanUtils.copyProperties(this, liulangdongwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 动物类型的值
	*/
	public String getLiulangdongwuValue() {
		return liulangdongwuValue;
	}
	/**
	* 设置： 动物类型的值
	*/
	public void setLiulangdongwuValue(String liulangdongwuValue) {
		this.liulangdongwuValue = liulangdongwuValue;
	}
	//当前表的
	/**
	* 获取： 详细类型的值
	*/
	public String getLiulangdongwuErjiValue() {
		return liulangdongwuErjiValue;
	}
	/**
	* 设置： 详细类型的值
	*/
	public void setLiulangdongwuErjiValue(String liulangdongwuErjiValue) {
		this.liulangdongwuErjiValue = liulangdongwuErjiValue;
	}
	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getXingbieValue() {
		return xingbieValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setXingbieValue(String xingbieValue) {
		this.xingbieValue = xingbieValue;
	}
	//当前表的
	/**
	* 获取： 动物状态的值
	*/
	public String getDongwuZhuangtaiValue() {
		return dongwuZhuangtaiValue;
	}
	/**
	* 设置： 动物状态的值
	*/
	public void setDongwuZhuangtaiValue(String dongwuZhuangtaiValue) {
		this.dongwuZhuangtaiValue = dongwuZhuangtaiValue;
	}




	@Override
	public String toString() {
		return "LiulangdongwuView{" +
			", liulangdongwuValue=" + liulangdongwuValue +
			", liulangdongwuErjiValue=" + liulangdongwuErjiValue +
			", xingbieValue=" + xingbieValue +
			", dongwuZhuangtaiValue=" + dongwuZhuangtaiValue +
			"} " + super.toString();
	}
}
