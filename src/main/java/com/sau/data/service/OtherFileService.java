package com.sau.data.service;

import com.sau.data.entity.OtherFileDO;
import com.sau.data.form.OtherFileForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 22:58 2020/12/19
 * @Modified By:
 */
public interface OtherFileService {

    boolean insertFile(String otherFileName, String otherFileText, MultipartFile otherFile);

    Integer getTotal(OtherFileForm otherFileForm);

    List<OtherFileForm> selectFileListPage(OtherFileForm otherFileForm);

    OtherFileDO selectFile(Integer id);

    boolean deleteFile(Integer id);
}
