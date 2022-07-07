package com.gaoh.mybatis.model;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件实体类
 * </p>
 *
 * @author gaoh
 * @since 2019-09-16
 */
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String objId;//文件对象的Id 合同对象的Id或者UUid
    private String objType;//文件对象的类型  经营  外包
    private String fileName;//文件名称
    private String fileType;//文件类型(01 图片 02 PDF)
    private Integer fileSize;//文件大小  KB
    private String fileUrl;//文件路径  相对路径
    private String filePath;//所在文件夹
    private String suffixName;//后缀名 pdf jpg
    private Date createDate;//创建日期

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getObjId() {
    return objId;
  }

  public void setObjId(String objId) {
    this.objId = objId;
  }

  public String getObjType() {
    return objType;
  }

  public void setObjType(String objType) {
    this.objType = objType;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getSuffixName() {
    return suffixName;
  }

  public void setSuffixName(String suffixName) {
    this.suffixName = suffixName;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "Paper{" +
      "id=" + id +
      ", objId='" + objId + '\'' +
      ", objType='" + objType + '\'' +
      ", fileName='" + fileName + '\'' +
      ", fileType='" + fileType + '\'' +
      ", fileSize=" + fileSize +
      ", fileUrl='" + fileUrl + '\'' +
      ", filePath='" + filePath + '\'' +
      ", suffixName='" + suffixName + '\'' +
      ", createDate=" + createDate +
      '}';
  }
}
