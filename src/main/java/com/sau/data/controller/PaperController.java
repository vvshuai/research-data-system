package com.sau.data.controller;

import com.sau.data.entity.PaperDO;
import com.sau.data.entity.StudyDO;
import com.sau.data.form.PaperForm;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.PaperService;
import com.sau.data.utils.PageHelper;
import com.sau.data.utils.ZipUtils;
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
import java.util.zip.ZipOutputStream;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 17:28 2020/12/25
 * @Modified By:
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @PostMapping("/upload")
    public CommonReturnType upload(@RequestParam("paperName") String paperName,
                                   @RequestParam("paperWriter") String paperWriter,
                                   @RequestParam("paperYear") String paperYear,
                                   @RequestParam("paperMeeting") String paperMeeting,
                                   @RequestParam("paperFile") MultipartFile paperFile,
                                   @RequestParam(value = "pptFile", required = false) MultipartFile pptFile) {

        boolean result = paperService.upload(paperName, paperWriter, paperYear, paperMeeting, paperFile, pptFile);

        if(result == false){
            return CommonReturnType.error("-1", "上传失败");
        }

        return CommonReturnType.success(null);
    }

    @PostMapping("/queryFileList")
    public CommonReturnType queryFileList(PaperForm paperForm){
        PageHelper<PaperForm> pageHelper = new PageHelper<>();
        int total = paperService.getTotal(paperForm);
        pageHelper.setTotal(total);

        List<PaperForm> rows = paperService.selectFileListPage(paperForm);
        pageHelper.setRows(rows);

        return CommonReturnType.success(pageHelper);
    }

    @PostMapping("/delete")
    public CommonReturnType deleteFile(@RequestParam("id") Integer id) {
        if(id == null) {
            return CommonReturnType.error("-1", "文件不存在");
        }
        boolean result = paperService.deleteFile(id);
        if(result == false) {
            return CommonReturnType.error("-1", "删除失败");
        }
        return CommonReturnType.success(null);
    }

    @PostMapping(value = "/download")
    public void download(HttpServletResponse response,
                         @RequestParam("id") Integer id) throws UnsupportedEncodingException {
        PaperDO paperDO = paperService.selectFile(id);

        if(paperDO == null) {
            return ;
        }
        File file = new File(paperDO.getPaperAddress());
        if(!file.exists()) {
            return ;
        }
        // 设置返回请求头
        response.reset();
        response.setContentType("application/octet-stream"); // 通用二进制返回
        response.setCharacterEncoding("utf-8"); // 设置编码
        // 判断单文件还是多文件返回
        if(paperDO.getPptAddress() == null) {
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
        } else {
            String zipName = java.net.URLEncoder.encode("论文压缩包.zip", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipName);
            List<String> paths = new ArrayList<>();
            paths.add(paperDO.getPaperAddress());
            paths.add(paperDO.getPptAddress());
            try {
                ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
                ZipUtils.zipFile(paths, zos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ;
    }


}
