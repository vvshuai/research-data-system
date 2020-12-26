package com.sau.data.service.impl;

import com.sau.data.constant.PrefixEnum;
import com.sau.data.dao.StudyDOMapper;
import com.sau.data.entity.StudyDO;
import com.sau.data.entity.UserDO;
import com.sau.data.exception.SystemException;
import com.sau.data.form.StudyFileForm;
import com.sau.data.service.StudyFileService;
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
 * @Date: Created in 18:11 2020/12/23
 * @Modified By:
 */
@Service
public class StudyFileServiceImpl implements StudyFileService {

    @Autowired
    StudyDOMapper studyDOMapper;

    @Override
    public boolean insertFile(String fileType, MultipartFile file) {
        String testPath = PrefixEnum.STUDY_FILE_PREFIX.getPrefix();
        // 判断路径是否存在
        File folderPath = new File(testPath);

        if(!folderPath.exists() && !folderPath.isDirectory()){
            folderPath.mkdir();
        }

        String path = testPath + file.getOriginalFilename();
        File filePath = new File(path);
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new SystemException("-1", "上传失败");
        }

        StudyDO studyDO = new StudyDO();
        studyDO.setCreateTime(new Date());
        studyDO.setFileAddress(path);
        studyDO.setFileName(file.getOriginalFilename());
        studyDO.setFileType(fileType);
        studyDO.setUserName(UserUtils.getUserDO().getUserName());

        int i = studyDOMapper.insertSelective(studyDO);
        if(i <= 0 ) {
            throw new SystemException("-1", "上传失败");
        }

        return true;
    }

    @Override
    public int getTotal(StudyFileForm studyFileForm) {
        int total = studyDOMapper.getTotal(studyFileForm);
        return total;
    }

    @Override
    public List<StudyFileForm> getFileList(StudyFileForm studyFileForm) {
        List<StudyDO> list = studyDOMapper.selectFileListPage(studyFileForm);
        List<StudyFileForm> ansList = new ArrayList<>();
        for(StudyDO studyDO : list) {
            StudyFileForm curForm = new StudyFileForm();
            BeanUtils.copyProperties(studyDO, curForm);
            ansList.add(curForm);
        }
        return ansList;
    }

    @Override
    public StudyDO selectFile(Integer id) {
        return studyDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteFile(Integer id) {
        StudyDO studyDO = studyDOMapper.selectByPrimaryKey(id);
        if(studyDO == null) {
            throw new SystemException("-1", "文件不存在");
        }
        UserDO userDO = UserUtils.getUserDO();
        if(!userDO.getUserName().equals(studyDO.getUserName())) {
            throw new SystemException("-1", "只能删除自己上传的文件");
        }
        File file = new File(studyDO.getFileAddress());
        boolean result = file.delete();
        int i = studyDOMapper.deleteByPrimaryKey(id);

        // 本地删除成功 && 数据库删除成功
        return result && (i > 0);
    }
}
