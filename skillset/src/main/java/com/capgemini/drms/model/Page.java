/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.model;

import java.util.List;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Mar 6, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */

public class Page {
private int pageNo;
private int totalPage;
private int totalRecords;
private int pageRecordSize=10;
private List<Object> list;
public int getPageNo() {
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
//返回总页数
public int getTotalPage() {
	return list.size()/pageRecordSize;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
//返回总记录数
public int getTotalRecords() {
	return list.size();
}
public void setTotalRecords(int totalRecords) {
	this.totalRecords = totalRecords;
}
//返回数据集合
public List<Object> getList() {
	return list;
}
public void setList(List<Object> list) {
	this.list = list;
}
//判断是否是第一页
public boolean isFirstPage(){
	if (pageNo>1) {
		return false;
	}
	return true;
}
//判断是否最后一页
public boolean isLastPage(){
	if (pageNo<totalPage) {
		return false;
	}
	return true;
}
//返回每页最初记录的下标
public int startIndex(){
	return (pageNo-1)*pageRecordSize;
}
//返回每页结尾记录的下标
public int endIndex(){
	return pageNo*pageRecordSize-1;
}
@Override
public String toString() {
	return "Page [pageNo=" + pageNo + ", totalPage=" + totalPage
			+ ", totalRecords=" + totalRecords + ", pageRecordSize="
			+ pageRecordSize + ", list=" + list + "]";
}

}
