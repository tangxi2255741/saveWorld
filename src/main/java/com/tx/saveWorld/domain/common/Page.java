/*
 * Copyright (c) 2014 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都云平台所有,未经许可不得任意复制与传播.
 */
package com.tx.saveWorld.domain.common;

import java.util.List;

/**
 * 分页对象
 * @author J-ONE
 * @since 2014-09-19
 * @param <T> 实体
 */
public class Page<T> {

    public static final Page EMPTY = new Page(0,20);
	//初始化size
	private final static int INIT_SIZE = 20;
	private int pageSize = INIT_SIZE;
	private int totalCount;
	private int currentPage;

    /**分页导出excel添加 */
    private int endPage;
	private List<T> data;

	public Page() {
		// 默认构造器
	}

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public Page(int currentPage) {
		this.currentPage = currentPage;
	}

	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	/**
	 * 获取开始索引
	 * @return
	 */
	public int getStartIndex() {
		return (getCurrentPage() - 1) * this.pageSize;
	}

	/**
	 * 获取结束索引
	 * @return
	 */
	public int getEndIndex() {
		return getCurrentPage() * this.pageSize;
	}

	/**
	 * 是否第一页
	 * @return
	 */
	public boolean isFirstPage() {
		return getCurrentPage() <= 1;
	}

	/**
	 * 是否末页
	 * @return
	 */
	public boolean isLastPage() {
		return getCurrentPage() >= getPageCount();
	}

	/**
	 * 获取下一页页码
	 * @return
	 */
	public int getNextPage() {
		if (isLastPage()) {
			return getCurrentPage();
		} 
		return getCurrentPage() + 1;
	}

	/**
	 * 获取上一页页码
	 * @return
	 */
	public int getPreviousPage() {
		if (isFirstPage()) {
			return 1;
		}
		return getCurrentPage() - 1;
	}

	/**
	 * 获取当前页页码
	 * @return
	 */
	public int getCurrentPage() {
		if (currentPage == 0) {
			currentPage = 1;
		}
		return currentPage;
	}

	/**
	 * 取得总页数
	 * @return
	 */
	public int getPageCount() {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		} else {
			return totalCount / pageSize + 1;
		}
	}

	/**
	 * 取总记录数.
	 * @return
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 设置当前页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取每页数据容量.
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 该页是否有下一页.
	 * @return
	 */
	public boolean hasNextPage() {
		return getCurrentPage() < getPageCount();
	}

	/**
	 * 该页是否有上一页.
	 * @return
	 */
	public boolean hasPreviousPage() {
		return getCurrentPage() > 1;
	}

	/**
	 * 获取数据集
	 * @return
	 */
	public List<T> getResult() {
		return data;
	}

	/**
	 * 设置数据集
	 * @param data
	 */
	public void setResult(List<T> data) {
		this.data = data;
	}

	/**
	 * 设置总记录条数
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	//==============扩展字段===============//
	private String unit = "条";//单位
	private String extInfo;//扩展信息
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	public String getExtInfo() {
		return extInfo;
	}

    public int size() {
        return data != null ? data.size() : 0;
    }
}
