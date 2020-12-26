package com.sau.data.service.impl;

import com.sau.data.constant.PrefixEnum;
import com.sau.data.dao.CodeDOMapper;
import com.sau.data.dao.TagDOMapper;
import com.sau.data.entity.CodeDO;
import com.sau.data.entity.TagDO;
import com.sau.data.exception.SystemException;
import com.sau.data.form.CodeForm;
import com.sau.data.service.CodeService;
import com.sau.data.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:28 2020/12/26
 * @Modified By:
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    TagDOMapper tagDOMapper;

    @Autowired
    CodeDOMapper codeDOMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public List<TagDO> queryTags() {
        return tagDOMapper.selectAllTags();
    }

    @Override
    public boolean insertFile(String codeName, String codeDescription, List<String> tags,
                              MultipartFile codeFile, MultipartFile readmeFile) {
        CodeDO codeDO = new CodeDO();
        // 写入代码文件
        String codeFilePrefix = PrefixEnum.CODE_FILE_PREFIX.getPrefix();
        File folderPath = new File(codeFilePrefix);
        if(!folderPath.exists() && !folderPath.isDirectory()) {
            folderPath.mkdir();
        }

        String codeFilePath = codeFilePrefix + codeFile.getOriginalFilename();
        File filePath = new File(codeFilePath);
        try {
            codeFile.transferTo(filePath);
        } catch (IOException e) {
            throw new SystemException("-1", "上传失败");
        }
        // 写入readMe文件
        String readmeFilePrefix = PrefixEnum.CODE_README_FILE_PREFIX.getPrefix();
        File folderPath1 = new File(readmeFilePrefix);
        if(!folderPath1.exists() && !folderPath1.isDirectory()) {
            folderPath1.mkdir();
        }

        String readmeFilePath = readmeFilePrefix + readmeFile.getOriginalFilename();
        File filePath1 = new File(readmeFilePath);
        try {
            readmeFile.transferTo(filePath1);
        } catch (IOException e) {
            throw new SystemException("-1", "上传失败");
        }

        // 封装标签
        String labels = new String();
        for(String tag : tags) {
            labels += tag;
            labels += ";";
        }
        codeDO.setCodeName(codeName);
        codeDO.setCodeDescription(codeDescription);
        codeDO.setCodeLabel(labels);
        codeDO.setCodeFile(codeFilePath);
        codeDO.setCodeReadme(readmeFilePath);
        codeDO.setCreateTime(new Date());
        codeDO.setUserName(UserUtils.getUserDO().getUserName());

        int i = codeDOMapper.insertSelective(codeDO);

        if(i <= 0) {
            throw new SystemException("-1", "上传失败");
        }

        // 获取插入成功后的id 封装数据到redis中
        Integer id = codeDO.getId();
        for(String tag : tags) {
            String key = PrefixEnum.REDIS_PREFIX.getPrefix() + tag;
            redisTemplate.opsForList().leftPush(key, id);
        }

        return true;
    }

    @Override
    public int getCacheTotal(CodeForm codeForm) {
        TagDO tagDO = tagDOMapper.selectByName(codeForm.getCodeLabel());
        if(tagDO == null) {
            return 0;
        }
        String key = PrefixEnum.REDIS_PREFIX.getPrefix() + tagDO.getId();
        Long size = redisTemplate.opsForList().size(key);
        return size.intValue();
    }

    @Override
    public int getTotal(CodeForm codeForm) {
        return codeDOMapper.getTotal(codeForm);
    }

    @Override
    public List<CodeForm> queryCodeList(CodeForm codeForm) {
        List<CodeDO> list = codeDOMapper.selectFileListPage(codeForm);
        List<CodeForm> ansList = new ArrayList<>();
        for(CodeDO codeDO : list) {
            CodeForm codeForm1 = new CodeForm();
            BeanUtils.copyProperties(codeDO, codeForm1);
            String label = new String();
            String[] ids = codeForm1.getCodeLabel().split(";");
            for(String id : ids) {
                TagDO tagDO = tagDOMapper.selectByPrimaryKey(Integer.parseInt(id));
                label += tagDO.getTagName();
                label += ';';
            }
            codeForm1.setCodeLabel(label);
            ansList.add(codeForm1);
        }
        return ansList;
    }

    @Override
    public List<CodeForm> queryCacheCodeList(CodeForm codeForm) {
        TagDO tagDO = tagDOMapper.selectByName(codeForm.getCodeLabel());
        if(tagDO == null) {
            return null;
        }
        String key = PrefixEnum.REDIS_PREFIX.getPrefix() + String.valueOf(tagDO.getId());
        List<Integer> range = (List<Integer>) redisTemplate.opsForList().range(key, 0, -1);
        List<CodeForm> ansList = new ArrayList<>();
        for(Integer id : range) {
            CodeDO codeDO = codeDOMapper.selectByPrimaryKey(id);
            CodeForm codeForm1 = new CodeForm();
            BeanUtils.copyProperties(codeDO, codeForm1);
            String label = new String();
            String[] ids = codeForm1.getCodeLabel().split(";");
            for(String  id1: ids) {
                tagDO = tagDOMapper.selectByPrimaryKey(Integer.parseInt(id1));
                label += tagDO.getTagName();
                label += ';';
            }
            codeForm1.setCodeLabel(label);
            ansList.add(codeForm1);
        }
        return ansList;
    }
}
