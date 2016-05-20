
package com.library.domain;

/**
 * 借阅信息实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
public class BorrowInfo implements AbstractModel {
	private static final long serialVersionUID = 7382131008032055820L;

	/**
	 * 自增主键ID
	 */
	private long aiid;

	/**
	 * 图书ISBN
	 */
	private String bookISBN;

	/**
	 * 管理员ID
	 */
	private String managerId;

	/**
	 * 读者ISBN
	 */
	private String readerISBN;

	/**
	 * 是否归还
	 */
	private boolean isback;

	/**
	 * 借出日期
	 */
	private java.util.Date borrowDate;

	/**
	 * 归还日期
	 */
	private java.util.Date backDate;

	public long getAiid() {
		return aiid;
	}

	public void setAiid(long aiid) {
		this.aiid = aiid;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getReaderISBN() {
		return readerISBN;
	}

	public void setReaderISBN(String readerISBN) {
		this.readerISBN = readerISBN;
	}

	public boolean isIsback() {
		return isback;
	}

	public void setIsback(boolean isback) {
		this.isback = isback;
	}

	public java.util.Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(java.util.Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public java.util.Date getBackDate() {
		return backDate;
	}

	public void setBackDate(java.util.Date backDate) {
		this.backDate = backDate;
	}

	@Override
	public String toString() {
		return "BrrowInfo [aiid=" + aiid + ", bookISBN=" + bookISBN + ", managerId=" + managerId + ", readerISBN="
				+ readerISBN + ", isback=" + isback + ", borrowDate=" + borrowDate + ", backDate=" + backDate + "]";
	}

}
