package com.library.domain;

/**
 * 订书信息实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
public class OrderInfo implements AbstractModel {
	private static final long serialVersionUID = 5858464836840032842L;

	/**
	 * 自增id
	 */
	private long aiid;

	/**
	 * 图书ISBN
	 */
	private String ISBN;

	/**
	 * 订购日期
	 */
	private java.util.Date orderDate;

	/**
	 * 图书类型ID
	 */
	private int typeId;

	/**
	 * 订购数量
	 */
	private int number;

	/**
	 * 订购的管理员ID
	 */
	private String managerId;

	/**
	 * 是否验收
	 */
	private boolean checkAccept;

	/**
	 * 订书的折扣
	 */
	private float discount;

	public long getAiid() {
		return aiid;
	}

	public void setAiid(long aiid) {
		this.aiid = aiid;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public boolean isCheckAccept() {
		return checkAccept;
	}

	public void setCheckAccept(boolean checkAccept) {
		this.checkAccept = checkAccept;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderInfo [aiid=" + aiid + ", ISBN=" + ISBN + ", orderDate=" + orderDate + ", typeId=" + typeId
				+ ", number=" + number + ", managerId=" + managerId + ", checkAccept=" + checkAccept + ", discount="
				+ discount + "]";
	}
}
