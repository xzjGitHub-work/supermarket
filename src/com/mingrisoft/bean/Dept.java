package com.mingrisoft.bean;

public class Dept {
	private int id;
	private String dName;
	private String principal;
	private String bewrite;
	private int indexNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getBewrite() {
		return bewrite;
	}
	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	@Override
	public String toString() {
		return "Dept{" +
				"id=" + id +
				", dName='" + dName + '\'' +
				", principal='" + principal + '\'' +
				", bewrite='" + bewrite + '\'' +
				", indexNumber=" + indexNumber +
				'}';
	}
}
