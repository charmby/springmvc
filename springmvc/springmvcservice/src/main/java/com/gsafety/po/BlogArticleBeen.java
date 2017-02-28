package com.gsafety.po;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BlogArticleBeen {
	 private Long id;
	    private String name; //标题
	    private String mainPhoto; //封面图片
	    private String sketch; //简述
	    private String content; //详细描述
	    private String contentMd; //详细描述 markdown
	    private Boolean ifTop; //是否置顶
	    private String sources; //来源
	    private String staticCode; //静态码
	    private BigDecimal sorter;
	    private Boolean status; //状态
	    @ApiModelProperty(hidden = true)
	    private String creater;
	    @ApiModelProperty(dataType = "java.util.Date")
	    private Timestamp lastUpdateTime;
	    @ApiModelProperty(dataType = "java.util.Date")
	    private Timestamp creatTime;
	    
		private String columnNamesCache;
	    private String columnIdsCache;
	    private String labelIdsCache;
	    private String labelNamesCache;
	   
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMainPhoto() {
			return mainPhoto;
		}
		public void setMainPhoto(String mainPhoto) {
			this.mainPhoto = mainPhoto;
		}
		public String getSketch() {
			return sketch;
		}
		public void setSketch(String sketch) {
			this.sketch = sketch;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getContentMd() {
			return contentMd;
		}
		public void setContentMd(String contentMd) {
			this.contentMd = contentMd;
		}
		public Boolean getIfTop() {
			return ifTop;
		}
		public void setIfTop(Boolean ifTop) {
			this.ifTop = ifTop;
		}
		public String getSources() {
			return sources;
		}
		public void setSources(String sources) {
			this.sources = sources;
		}
		public String getStaticCode() {
			return staticCode;
		}
		public void setStaticCode(String staticCode) {
			this.staticCode = staticCode;
		}
		public BigDecimal getSorter() {
			return sorter;
		}
		public void setSorter(BigDecimal sorter) {
			this.sorter = sorter;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public String getCreater() {
			return creater;
		}
		public void setCreater(String creater) {
			this.creater = creater;
		}
		public Timestamp getLastUpdateTime() {
			return lastUpdateTime;
		}
		public void setLastUpdateTime(Timestamp lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		}
		public Timestamp getCreatTime() {
			return creatTime;
		}
		public void setCreatTime(Timestamp creatTime) {
			this.creatTime = creatTime;
		}
		public String getColumnNamesCache() {
			return columnNamesCache;
		}
		public void setColumnNamesCache(String columnNamesCache) {
			this.columnNamesCache = columnNamesCache;
		}
		public String getColumnIdsCache() {
			return columnIdsCache;
		}
		public void setColumnIdsCache(String columnIdsCache) {
			this.columnIdsCache = columnIdsCache;
		}
		public String getLabelIdsCache() {
			return labelIdsCache;
		}
		public void setLabelIdsCache(String labelIdsCache) {
			this.labelIdsCache = labelIdsCache;
		}
		public String getLabelNamesCache() {
			return labelNamesCache;
		}
		public void setLabelNamesCache(String labelNamesCache) {
			this.labelNamesCache = labelNamesCache;
		}

}
