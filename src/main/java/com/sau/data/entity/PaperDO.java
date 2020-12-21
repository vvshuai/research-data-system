package com.sau.data.entity;

import java.util.Date;

public class PaperDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.paper_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String paperName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.paper_year
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String paperYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.paper_meeting
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String paperMeeting;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.paper_writer
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private String paperWriter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper_info.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.id
     *
     * @return the value of paper_info.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.id
     *
     * @param id the value for paper_info.id
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.paper_name
     *
     * @return the value of paper_info.paper_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.paper_name
     *
     * @param paperName the value for paper_info.paper_name
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.paper_year
     *
     * @return the value of paper_info.paper_year
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getPaperYear() {
        return paperYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.paper_year
     *
     * @param paperYear the value for paper_info.paper_year
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setPaperYear(String paperYear) {
        this.paperYear = paperYear == null ? null : paperYear.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.paper_meeting
     *
     * @return the value of paper_info.paper_meeting
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getPaperMeeting() {
        return paperMeeting;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.paper_meeting
     *
     * @param paperMeeting the value for paper_info.paper_meeting
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setPaperMeeting(String paperMeeting) {
        this.paperMeeting = paperMeeting == null ? null : paperMeeting.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.paper_writer
     *
     * @return the value of paper_info.paper_writer
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public String getPaperWriter() {
        return paperWriter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.paper_writer
     *
     * @param paperWriter the value for paper_info.paper_writer
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setPaperWriter(String paperWriter) {
        this.paperWriter = paperWriter == null ? null : paperWriter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper_info.create_time
     *
     * @return the value of paper_info.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper_info.create_time
     *
     * @param createTime the value for paper_info.create_time
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}