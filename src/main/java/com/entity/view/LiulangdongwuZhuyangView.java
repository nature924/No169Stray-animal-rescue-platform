package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiulangdongwuZhuyangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 流浪动物助养
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liulangdongwu_zhuyang")
public class LiulangdongwuZhuyangView extends LiulangdongwuZhuyangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 流浪动物
		/**
		* 流浪动物名称
		*/

		@ColumnInfo(comment="流浪动物名称",type="varchar(200)")
		private String liulangdongwuName;
		/**
		* 流浪动物照片
		*/

		@ColumnInfo(comment="流浪动物照片",type="varchar(200)")
		private String liulangdongwuPhoto;
		/**
		* 动物类型
		*/
		@ColumnInfo(comment="动物类型",type="int(11)")
		private Integer liulangdongwuTypes;
			/**
			* 动物类型的值
			*/
			@ColumnInfo(comment="动物类型的字典表值",type="varchar(200)")
			private String liulangdongwuValue;
		/**
		* 详细类型
		*/
		@ColumnInfo(comment="详细类型",type="int(11)")
		private Integer liulangdongwuErjiTypes;
			/**
			* 详细类型的值
			*/
			@ColumnInfo(comment="详细类型的字典表值",type="varchar(200)")
			private String liulangdongwuErjiValue;
		/**
		* 流浪动物年龄
		*/

		@ColumnInfo(comment="流浪动物年龄",type="int(11)")
		private Integer liulangdongwuAge;
		/**
		* 疫苗接种
		*/

		@ColumnInfo(comment="疫苗接种",type="varchar(11)")
		private String liulangdongwuJiezhong;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer xingbieTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String xingbieValue;
		/**
		* 助养金
		*/
		@ColumnInfo(comment="助养金",type="decimal(10,2)")
		private Double liulangdongwuZuyangjin;
		/**
		* 动物介绍
		*/

		@ColumnInfo(comment="动物介绍",type="text")
		private String liulangdongwuContent;
		/**
		* 动物状态
		*/
		@ColumnInfo(comment="动物状态",type="int(11)")
		private Integer dongwuZhuangtaiTypes;
			/**
			* 动物状态的值
			*/
			@ColumnInfo(comment="动物状态的字典表值",type="varchar(200)")
			private String dongwuZhuangtaiValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer liulangdongwuDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public LiulangdongwuZhuyangView() {

	}

	public LiulangdongwuZhuyangView(LiulangdongwuZhuyangEntity liulangdongwuZhuyangEntity) {
		try {
			BeanUtils.copyProperties(this, liulangdongwuZhuyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 流浪动物

		/**
		* 获取： 流浪动物名称
		*/
		public String getLiulangdongwuName() {
			return liulangdongwuName;
		}
		/**
		* 设置： 流浪动物名称
		*/
		public void setLiulangdongwuName(String liulangdongwuName) {
			this.liulangdongwuName = liulangdongwuName;
		}

		/**
		* 获取： 流浪动物照片
		*/
		public String getLiulangdongwuPhoto() {
			return liulangdongwuPhoto;
		}
		/**
		* 设置： 流浪动物照片
		*/
		public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
			this.liulangdongwuPhoto = liulangdongwuPhoto;
		}
		/**
		* 获取： 动物类型
		*/
		public Integer getLiulangdongwuTypes() {
			return liulangdongwuTypes;
		}
		/**
		* 设置： 动物类型
		*/
		public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
			this.liulangdongwuTypes = liulangdongwuTypes;
		}


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
		/**
		* 获取： 详细类型
		*/
		public Integer getLiulangdongwuErjiTypes() {
			return liulangdongwuErjiTypes;
		}
		/**
		* 设置： 详细类型
		*/
		public void setLiulangdongwuErjiTypes(Integer liulangdongwuErjiTypes) {
			this.liulangdongwuErjiTypes = liulangdongwuErjiTypes;
		}


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

		/**
		* 获取： 流浪动物年龄
		*/
		public Integer getLiulangdongwuAge() {
			return liulangdongwuAge;
		}
		/**
		* 设置： 流浪动物年龄
		*/
		public void setLiulangdongwuAge(Integer liulangdongwuAge) {
			this.liulangdongwuAge = liulangdongwuAge;
		}

		/**
		* 获取： 疫苗接种
		*/
		public String getLiulangdongwuJiezhong() {
			return liulangdongwuJiezhong;
		}
		/**
		* 设置： 疫苗接种
		*/
		public void setLiulangdongwuJiezhong(String liulangdongwuJiezhong) {
			this.liulangdongwuJiezhong = liulangdongwuJiezhong;
		}
		/**
		* 获取： 性别
		*/
		public Integer getXingbieTypes() {
			return xingbieTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setXingbieTypes(Integer xingbieTypes) {
			this.xingbieTypes = xingbieTypes;
		}


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

		/**
		* 获取： 助养金
		*/
		public Double getLiulangdongwuZuyangjin() {
			return liulangdongwuZuyangjin;
		}
		/**
		* 设置： 助养金
		*/
		public void setLiulangdongwuZuyangjin(Double liulangdongwuZuyangjin) {
			this.liulangdongwuZuyangjin = liulangdongwuZuyangjin;
		}

		/**
		* 获取： 动物介绍
		*/
		public String getLiulangdongwuContent() {
			return liulangdongwuContent;
		}
		/**
		* 设置： 动物介绍
		*/
		public void setLiulangdongwuContent(String liulangdongwuContent) {
			this.liulangdongwuContent = liulangdongwuContent;
		}
		/**
		* 获取： 动物状态
		*/
		public Integer getDongwuZhuangtaiTypes() {
			return dongwuZhuangtaiTypes;
		}
		/**
		* 设置： 动物状态
		*/
		public void setDongwuZhuangtaiTypes(Integer dongwuZhuangtaiTypes) {
			this.dongwuZhuangtaiTypes = dongwuZhuangtaiTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getLiulangdongwuDelete() {
			return liulangdongwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
			this.liulangdongwuDelete = liulangdongwuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "LiulangdongwuZhuyangView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", liulangdongwuName=" + liulangdongwuName +
			", liulangdongwuPhoto=" + liulangdongwuPhoto +
			", liulangdongwuAge=" + liulangdongwuAge +
			", liulangdongwuJiezhong=" + liulangdongwuJiezhong +
			", liulangdongwuZuyangjin=" + liulangdongwuZuyangjin +
			", liulangdongwuContent=" + liulangdongwuContent +
			", liulangdongwuDelete=" + liulangdongwuDelete +
			"} " + super.toString();
	}
}
