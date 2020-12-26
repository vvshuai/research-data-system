package com.sau.data.service;

import com.sau.data.entity.PaperDO;
import com.sau.data.form.PaperForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 17:32 2020/12/25
 * @Modified By:
 */
public interface PaperService {

    boolean upload(String paperName, String paperWriter, String paperYear, String paperMeeting, MultipartFile paperFile, MultipartFile pptFile);

    int getTotal(PaperForm paperForm);

    List<PaperForm> selectFileListPage(PaperForm paperForm);

    boolean deleteFile(Integer id);

    PaperDO selectFile(Integer id);
}
