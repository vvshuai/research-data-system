package com.sau.data.dao;

import com.sau.data.entity.PaperDO;
import com.sau.data.form.PaperForm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    int insert(PaperDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    int insertSelective(PaperDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    PaperDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    int updateByPrimaryKeySelective(PaperDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_info
     *
     * @mbg.generated Fri Dec 25 21:58:23 CST 2020
     */
    int updateByPrimaryKey(PaperDO record);

    /**
     * @Description: 获得所有值
     * @return:
     */
    int getTotal(PaperForm paperForm);

    /**
     * @Description: 分页查询
     * @return:
     */
    List<PaperDO> selectFileListPage(PaperForm paperForm);
}