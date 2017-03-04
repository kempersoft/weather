package org.kempersoft.weather_parser.domain.weather.remarks;

public class RemarkRecord {

	public RemarkRecord() {
		super();
	}
	
	public RemarkRecord(String remarkType, String remark) {
		this.remarkType = remarkType;
		this.remark = remark;
	}
	
	public String getRemarkType() {
		return remarkType;
	}
	public void setRemarkType(String remarkType) {
		this.remarkType = remarkType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remarkType;
	private String remark;
}
