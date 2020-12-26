package com.sau.data.service.impl;

import com.sau.data.constant.PrefixEnum;
import com.sau.data.dao.OtherFileDOMapper;
import com.sau.data.entity.OtherFileDO;
import com.sau.data.entity.UserDO;
import com.sau.data.exception.SystemException;
import com.sau.data.form.OtherFileForm;
import com.sau.data.service.OtherFileService;
import com.sau.data.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date: Created in 22:58 2020/12/19
 * @Modified By:
 */
@Service
public class OtherFileServiceImpl implements OtherFileService {

    @Autowired
    private OtherFileDOMapper otherFileDOMapper;

    @Override
    public boolean insertFile(String otherFileName, String otherFileText, MultipartFile otherFile) {

        // 获取路径(校验文件是否存在) + 上传到本地
        String testPath = PrefixEnum.OTHER_FILE_PREFIX.getPrefix();
        File folderPath = new File(testPath);

        if(!folderPath.exists() && !folderPath.isDirectory()){
            folderPath.mkdir();
        }

        String path = testPath + otherFile.getOriginalFilename();
        File filePath = new File(path);
        try {
            otherFile.transferTo(filePath);
        } catch (IOException e) {
            throw new SystemException("-1", "上传失败");
        }

        // 封装数据
        OtherFileDO otherFileDO = new OtherFileDO();
        otherFileDO.setFileName(otherFileName);
        otherFileDO.setCreateTime(new Date());
        otherFileDO.setFileAddress(path);
        otherFileDO.setFileDescription(otherFileText);
        otherFileDO.setUserName(UserUtils.getUserDO().getUserName());

        // 插入数据库
        int i = otherFileDOMapper.insertSelective(otherFileDO);
        if(i < 1) {
            throw new SystemException("-1", "上传失败");
        }
        return true;
    }

    @Override
    public Integer getTotal(OtherFileForm otherFileForm) {
        return otherFileDOMapper.getTotal(otherFileForm);
    }

    @Override
    public List<OtherFileForm> selectFileListPage(OtherFileForm otherFileForm) {
        List<OtherFileDO> list = otherFileDOMapper.selectFileListPage(otherFileForm);
        List<OtherFileForm> resList = new ArrayList<>();
        // 转为前端需要的类型
        for(OtherFileDO otherFileDO : list) {
            OtherFileForm otherFileForm1 = new OtherFileForm();
            BeanUtils.copyProperties(otherFileDO, otherFileForm1);
            resList.add(otherFileForm1);
        }
        return resList;
    }

    @Override
    public OtherFileDO selectFile(Integer id) {
        return otherFileDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteFile(Integer id) {
        OtherFileDO otherFileDO = otherFileDOMapper.selectByPrimaryKey(id);
        if(otherFileDO == null) {
            throw new SystemException("-1", "文件不存在");
        }
        UserDO userDO = UserUtils.getUserDO();
        if(!userDO.getUserName().equals(otherFileDO.getUserName())) {
            throw new SystemException("-1", "只能删除自己上传的文件");
        }
        File file = new File(otherFileDO.getFileAddress());
        boolean result = file.delete();
        int i = otherFileDOMapper.deleteByPrimaryKey(id);

        // 本地删除成功 && 数据库删除成功
        return result && (i > 0);
    }

}
