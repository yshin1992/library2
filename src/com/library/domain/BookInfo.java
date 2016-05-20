package com.library.domain;

/**
 * 图书信息实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
public class BookInfo implements AbstractModel {
	private static final long serialVersionUID = 7292841809173905401L;

	/**
	 * 图书编号
	 */
	private String ISBN;

	/**
	 * 类别编号
	 */
	private int typeId;

	/**
	 * 图书名称
	 */
	private String bookname;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 译者
	 */
	private String translator;

	/**
	 * 出版社
	 */
	private String publisher;

	/**
	 * 出版日期
	 */
	private java.util.Date date;

	/**
	 * 书籍价格
	 */
	private float price;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}