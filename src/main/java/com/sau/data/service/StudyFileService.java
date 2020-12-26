package com.sau.data.service;

import com.sau.data.entity.OtherFileDO;
import com.sau.data.entity.StudyDO;
import com.sau.data.form.StudyFileForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 18:10 2020/12/23
 * @Modified By:
 */
public interface StudyFileService {

    /**
     * @Description: 插入文件
     * @return: boolean
     */
    boolean insertFile(String fileType, MultipartFile file);

    int getTotal(StudyFileForm studyFileForm);

    List<StudyFileForm> getFileList(StudyFileForm studyFileForm);

    StudyDO selectFile(Integer id);

    boolean deleteFile(Integer id);
}
