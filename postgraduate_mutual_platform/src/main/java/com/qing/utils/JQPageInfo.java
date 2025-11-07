package com.qing.utils;

/**
 * 分页工具类,用于存储分页信息
 */
public class JQPageInfo {

	private Integer page;	//当前页
	
	private Integer limit;	//每页显示数量
	
	private String sidx;	//排序的属性列
	
	private String order;	//排序规则
	
	private  Integer offset;	//

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}
