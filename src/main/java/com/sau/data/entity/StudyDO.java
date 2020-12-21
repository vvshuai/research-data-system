package com.sau.data.entity;

import java.util.Date;

public class StudyDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.file_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.file_type
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.file_address
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String fileAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.user_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column study_file.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.id
     *
     * @return the value of study_file.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.id
     *
     * @param id the value for study_file.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.file_name
     *
     * @return the value of study_file.file_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.file_name
     *
     * @param fileName the value for study_file.file_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.file_type
     *
     * @return the value of study_file.file_type
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.file_type
     *
     * @param fileType the value for study_file.file_type
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.file_address
     *
     * @return the value of study_file.file_address
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getFileAddress() {
        return fileAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.file_address
     *
     * @param fileAddress the value for study_file.file_address
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress == null ? null : fileAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.user_name
     *
     * @return the value of study_file.user_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.user_name
     *
     * @param userName the value for study_file.user_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column study_file.create_time
     *
     * @return the value of study_file.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column study_file.create_time
     *
     * @param createTime the value for study_file.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}