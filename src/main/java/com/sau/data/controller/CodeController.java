package com.sau.data.controller;

import com.sau.data.entity.CodeDO;
import com.sau.data.entity.TagDO;
import com.sau.data.form.CodeForm;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.CodeService;
import com.sau.data.utils.PageHelper;
import com.sau.data.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:27 2020/12/26
 * @Modified By:
 */
@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/queryTags")
    public CommonReturnType queryTags(){
        List<TagDO> list = codeService.queryTags();
        return CommonReturnType.success(list);
    }

    @PostMapping("/upload")
    public CommonReturnType upload(@RequestParam("codeName") String codeName,
                                   @RequestParam("codeDescription") String codeDescription,
                                   @RequestParam("tags") List<String> tags,
                                   @RequestParam("codeFile")MultipartFile codeFile,
                                   @RequestParam("readmeFile") MultipartFile readmeFile) {

        boolean result = codeService.insertFile(codeName, codeDescription, tags, codeFile, readmeFile);

        return CommonReturnType.success(null);
    }

    @PostMapping("/queryFileList")
    public CommonReturnType queryFileList(CodeForm codeForm){
        PageHelper<CodeForm> pageHelper = new PageHelper<>();

        if(codeForm.getCodeLabel() != null) {
            int total = codeService.getCacheTotal(codeForm);
            pageHelper.setTotal(total);
            List<CodeForm> list = codeService.queryCacheCodeList(codeForm);
            pageHelper.setRows(list);
        } else {
            int total = codeService.getTotal(codeForm);
            pageHelper.setTotal(total);
            List<CodeForm> list = codeService.queryCodeList(codeForm);
            pageHelper.setRows(list);
        }

        return CommonReturnType.success(pageHelper);
    }

    @PostMapping("/delete")
    public CommonReturnType delete(@RequestParam("id") Integer id) {
        if(id == null) {
            return CommonReturnType.error("-1", "文件不存在");
        }
        boolean result = codeService.deleteFile(id);
        if(result == false) {
            return CommonReturnType.error("-1", "删除失败");
        }
        return CommonReturnType.success(null);
    }

    @PostMapping(value = "/download")
    public void download(HttpServletResponse response,
                         @RequestParam("id") Integer id) throws UnsupportedEncodingException {
        CodeDO codeDO = codeService.getCodeDO(id);

        if(codeDO == null) {
            return ;
        }
        // 设置返回请求头
        response.reset();
        response.setContentType("application/octet-stream"); // 通用二进制返回
        response.setCharacterEncoding("utf-8"); // 设置编码
        String zipName = java.net.URLEncoder.encode("论文压缩包.zip", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + zipName);
        List<String> paths = new ArrayList<>();
        paths.add(codeDO.getCodeFile());
        paths.add(codeDO.getCodeReadme());
        try {
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            ZipUtils.zipFile(paths, zos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
