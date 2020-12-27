package com.sau.data.service;

import com.sau.data.entity.CodeDO;
import com.sau.data.entity.TagDO;
import com.sau.data.form.CodeForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:28 2020/12/26
 * @Modified By:
 */
public interface CodeService {

    /**
     * @Description: 查询所有标签
     * @return: java.util.List<com.sau.data.entity.TagDO>
     */
    List<TagDO> queryTags();

    boolean insertFile(String codeName, String codeDescription, List<String> tags, MultipartFile codeFile, MultipartFile readmeFile);

    int getCacheTotal(CodeForm codeForm);

    int getTotal(CodeForm codeForm);

    List<CodeForm> queryCodeList(CodeForm codeForm);

    List<CodeForm> queryCacheCodeList(CodeForm codeForm);

    boolean deleteFile(Integer id);

    CodeDO getCodeDO(Integer id);
}
