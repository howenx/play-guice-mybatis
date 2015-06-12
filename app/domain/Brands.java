package domain;

import java.sql.Date;

public class Brands {

  private Integer brandId;
  private Integer cateId;
  private String descriptionZh;
  private String descriptionEn;
  private String descriptionKo;
  private String logoUrl;
  private String homePage;
  private Date createDate;
  private String brandNmZh;
  private String brandNmEn;
  private String brandNmKo;
  
  public Integer getBrandId() {
    return brandId;
  }
  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }
  public String getDescriptionZh() {
    return descriptionZh;
  }
  public void setDescriptionZh(String descriptionZh) {
    this.descriptionZh = descriptionZh;
  }
  public String getDescriptionEn() {
    return descriptionEn;
  }
  public void setDescriptionEn(String descriptionEn) {
    this.descriptionEn = descriptionEn;
  }
  public String getDescriptionKo() {
    return descriptionKo;
  }
  public void setDescriptionKo(String descriptionKo) {
    this.descriptionKo = descriptionKo;
  }
  public String getLogoUrl() {
    return logoUrl;
  }
  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }
  public String getHomePage() {
    return homePage;
  }
  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public String getBrandNmZh() {
    return brandNmZh;
  }
  public void setBrandNmZh(String brandNmZh) {
    this.brandNmZh = brandNmZh;
  }
  public String getBrandNmEn() {
    return brandNmEn;
  }
  public void setBrandNmEn(String brandNmEn) {
    this.brandNmEn = brandNmEn;
  }
  public String getBrandNmKo() {
    return brandNmKo;
  }
  public void setBrandNmKo(String brandNmKo) {
    this.brandNmKo = brandNmKo;
  }
  public Integer getCateId() {
    return cateId;
  }
  public void setCateId(Integer cateId) {
    this.cateId = cateId;
  }
  
  

}
