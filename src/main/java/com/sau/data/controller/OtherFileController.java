package com.sau.data.controller;

import com.sau.data.entity.OtherFileDO;
import com.sau.data.form.OtherFileForm;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.OtherFileService;
import com.sau.data.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 23:54 2020/12/18
 * @Modified By:
 */
@RestController
@RequestMapping("/other")
public class OtherFileController {

    @Autowired
    OtherFileService otherFileService;

    @PostMapping(value = "/upload")
    public CommonReturnType upload(@RequestParam("otherFileName") String otherFileName,
                                   @RequestParam("otherFileText") String otherFileText,
                                   @RequestParam("otherFile") MultipartFile otherFile){
        boolean b = otherFileService.insertFile(otherFileName, otherFileText, otherFile);
        if(b == false) {
            return CommonReturnType.error("-1", "上传失败");
        }
        return CommonReturnType.success(null);
    }

    @GetMapping(value = "/queryFileList")
    public CommonReturnType queryFileList(OtherFileForm otherFileForm) {
        PageHelper<OtherFileForm> pageHelper = new PageHelper<>();
        Integer total = otherFileService.getTotal(otherFileForm);

        pageHelper.setTotal(total);

        List<OtherFileForm> list = otherFileService.selectFileListPage(otherFileForm);

        pageHelper.setRows(list);

        return CommonReturnType.success(pageHelper);
    }

    @PostMapping(value = "/download")
    public void download(HttpServletResponse response,
                         @RequestParam("id") Integer id) throws UnsupportedEncodingException {
        OtherFileDO otherFileDO = otherFileService.selectFile(id);
        if(otherFileDO == null) {
            return ;
        }
        File file = new File(otherFileDO.getFileAddress());
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
}
