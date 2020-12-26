package com.sau.data.controller;

import com.sau.data.entity.OtherFileDO;
import com.sau.data.entity.StudyDO;
import com.sau.data.form.StudyFileForm;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.StudyFileService;
import com.sau.data.utils.Page;
import com.sau.data.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 18:08 2020/12/23
 * @Modified By:
 */
@RestController
@RequestMapping("/study")
public class StudyFileController {

    @Autowired
    StudyFileService studyFileService;

    @PostMapping("/upload")
    public CommonReturnType upload(@RequestParam("fileType") String fileType,
                                   @RequestParam("file") MultipartFile file) {
        boolean result = studyFileService.insertFile(fileType, file);

        if(result == false) {
            return CommonReturnType.error("-1", "文件上传失败");
        }

        return CommonReturnType.success(null);
    }

    @PostMapping("/queryFileList")
    public CommonReturnType queryFileList(StudyFileForm studyFileForm) {
        PageHelper<StudyFileForm> pageHelper = new PageHelper<>();
        int total = studyFileService.getTotal(studyFileForm);

        pageHelper.setTotal(total);

        List<StudyFileForm> rows = studyFileService.getFileList(studyFileForm);

        pageHelper.setRows(rows);

        return CommonReturnType.success(pageHelper);

    }

    @PostMapping(value = "/download")
    public void download(HttpServletResponse response,
                         @RequestParam("id") Integer id) throws UnsupportedEncodingException {
        StudyDO studyDO = studyFileService.selectFile(id);
        if(studyDO == null) {
            return ;
        }
        File file = new File(studyDO.getFileAddress());
        if(!file.exists()) {
            return ;
        }
        System.out.println(file.getName());
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return ;
        }
        return ;
    }

    @PostMapping("/delete")
    public CommonReturnType deleteFile(@RequestParam("id") Integer id) {
        if(id == null) {
            return CommonReturnType.error("-1", "文件不存在");
        }
        boolean result = studyFileService.deleteFile(id);
        if(result == false) {
            return CommonReturnType.error("-1", "删除失败");
        }
        return CommonReturnType.success(null);
    }
}
