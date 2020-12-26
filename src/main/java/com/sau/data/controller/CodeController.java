package com.sau.data.controller;

import com.sau.data.entity.TagDO;
import com.sau.data.form.CodeForm;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.CodeService;
import com.sau.data.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
}
