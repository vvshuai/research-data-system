package com.sau.data.dao;

import com.sau.data.entity.CodeDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    int insert(CodeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    int insertSelective(CodeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    CodeDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    int updateByPrimaryKeySelective(CodeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Fri Dec 18 21:56:50 CST 2020
     */
    int updateByPrimaryKey(CodeDO record);
}