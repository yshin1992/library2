
package com.library.domain;

/**
 * 读者信箱实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
public class Reader implements AbstractModel {
	private static final long serialVersionUID = -3210732976696220496L;

	/**
	 * 读者ISBN
	 */
	private String ISBN;

	/**
	 * 读者姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 年龄
	 */
	private int age;

	/**
	 * 证件ID
	 */
	private String idCard;

	/**
	 * 注册日期
	 */
	private java.util.Date regDate;

	/**
	 * 可借的最大数量
	 */
	private int maxNum;

	/**
	 * 联系电话
	 */
	private String telphone;

	/**
	 * 押金
	 */
	private float keepMoney;

	/**
	 * 证件类型 0:学生证 1:身份证
	 */
	private int cardType;

	/**
	 * 职业
	 */
	private String job;

	/**
	 * 证件有效期
	 */
	private java.util.Date validDate;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public java.util.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public float getKeepMoney() {
		return keepMoney;
	}

	public void setKeepMoney(float keepMoney) {
		this.keepMoney = keepMoney;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public java.util.Date getValidDate() {
		return validDate;
	}

	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}

	@Override
	public String toString() {
		return "Reader [ISBN=" + ISBN + ", name=" + name + ", sex=" + sex + ", age=" + age + ", idCard=" + idCard
				+ ", regDate=" + regDate + ", maxNum=" + maxNum + ", telphone=" + telphone + ", keepMoney=" + keepMoney
				+ ", cardType=" + cardType + ", job=" + job + ", validDate=" + validDate + "]";
	}

}
