package com.sau.data.service.impl;

import com.sau.data.constant.PrefixEnum;
import com.sau.data.dao.PaperDOMapper;
import com.sau.data.entity.PaperDO;
import com.sau.data.entity.UserDO;
import com.sau.data.exception.SystemException;
import com.sau.data.form.PaperForm;
import com.sau.data.service.PaperService;
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
 * @Date: Created in 17:32 2020/12/25
 * @Modified By:
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDOMapper paperDOMapper;

    @Override
    public boolean upload(String paperName, String paperWriter, String paperYear, String paperMeeting,
                          MultipartFile paperFile, MultipartFile pptFile) {
        PaperDO paperDO = new PaperDO();

        // 封装ppt数据
        if(pptFile != null) {
            String testPath = PrefixEnum.PAPER_PPT_PREFIX.getPrefix();
            File folderPath = new File(testPath);
            if(!folderPath.exists() && !folderPath.isDirectory()){
                folderPath.mkdir();
            }
            String path = testPath + pptFile.getOriginalFilename();
            File filePath = new File(path);
            try {
                pptFile.transferTo(filePath);
            } catch (IOException e) {
                throw new SystemException("-1", "上传失败");
            }
            paperDO.setPptAddress(path);
        }

        String paperPerFix = PrefixEnum.PAPER_FILE_PREFIX.getPrefix();
        File paperPerFixPath = new File(paperPerFix);
        if(!paperPerFixPath.exists() && !paperPerFixPath.isDirectory()) {
            paperPerFixPath.mkdir();
        }
        String paperPath = paperPerFixPath + paperFile.getOriginalFilename();
        File paperFilePath = new File(paperPath);
        try {
            paperFile.transferTo(paperFilePath);
        } catch (IOException e) {
            throw new SystemException("-1", "上传失败");
        }

        // 封装数据
        paperDO.setPaperName(paperName);
        paperDO.setPaperMeeting(paperMeeting);
        paperDO.setCreateTime(new Date());
        paperDO.setPaperWriter(paperWriter);
        paperDO.setPaperYear(paperYear);
        paperDO.setPaperAddress(paperPath);
        paperDO.setUserName(UserUtils.getUserDO().getUserName());

        int i = paperDOMapper.insertSelective(paperDO);
        if(i <= 0) {
            throw new SystemException("-1", "上传失败");
        }

        return true;
    }

    @Override
    public int getTotal(PaperForm paperForm) {
        return paperDOMapper.getTotal(paperForm);
    }

    @Override
    public List<PaperForm> selectFileListPage(PaperForm paperForm) {
        List<PaperDO> list = paperDOMapper.selectFileListPage(paperForm);
        List<PaperForm> list1 = new ArrayList<>();
        for(PaperDO paperDO : list) {
            PaperForm paperForm1 = new PaperForm();
            BeanUtils.copyProperties(paperDO, paperForm1);
            if(paperDO.getPptAddress() == null) {
                paperForm1.setPptName("无");
            } else {
                paperForm1.setPptName("有ppt文件");
            }
            list1.add(paperForm1);
        }
        return list1;
    }

    @Override
    public boolean deleteFile(Integer id) {
        PaperDO paperDO = paperDOMapper.selectByPrimaryKey(id);
        if(paperDO == null) {
            throw new SystemException("-1", "文件不存在");
        }
        UserDO userDO = UserUtils.getUserDO();
        if(!userDO.getUserName().equals(paperDO.getUserName())) {
            throw new SystemException("-1", "只能删除自己上传的文件");
        }
        File file1 = new File(paperDO.getPaperAddress());
        boolean result = file1.delete();
        boolean result2 = true;
        if(paperDO.getPptAddress() != null) {
            File file2 = new File(paperDO.getPptAddress());
            result2 = file2.delete();
        }
        int i = paperDOMapper.deleteByPrimaryKey(id);

        // 本地删除成功 && 数据库删除成功
        return result && (i > 0) && result2;
    }

    @Override
    public PaperDO selectFile(Integer id) {
        return paperDOMapper.selectByPrimaryKey(id);
    }
}
