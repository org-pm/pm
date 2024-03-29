package com.practice.management.controller;

import com.alibaba.fastjson.JSON;
import com.practice.management.bean.dto.AddEnpFileUploadDto;
import com.practice.management.bean.dto.UpdEnpFileUploadDto;
import com.practice.management.bean.entity.FileUpload;
import com.practice.management.bean.model.QueryEnpFileUploadModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.EnpFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enp/file")
public class EnpFileUploadController extends BaseController {

    @Autowired
    private EnpFileUploadService uploadService;


    /**
     * 上传文件
     * 角色：企业负责人/老师
     *
     * @param json 上传的文件对象
     * @param  file 上传的文件
     * @return 上传文件的结果信息
     */
    @PostMapping("/add")
    public ResultModel<FileUpload> uploadFile(@RequestParam("data") String json, MultipartFile file) {
        if (file == null)
            throw new RuntimeException("上传的文件不能为空");

        AddEnpFileUploadDto dto = JSON.parseObject(json, AddEnpFileUploadDto.class);
        dto.setFile(file);
        FileUpload fileUpload = uploadService.add(dto);

        return success("上传成功", fileUpload);
    }


    /**
     * 修改上传文件
     * 角色：企业负责人/老师
     *
     * @param json 上传的文件对象
     * @param  file 上传的文件
     * @return 修改文件的结果信息
     */
    @PutMapping("/upd")
    public ResultModel<FileUpload> updateFile(@RequestParam("data") String json, MultipartFile file) {
        UpdEnpFileUploadDto dto = JSON.parseObject(json, UpdEnpFileUploadDto.class);
        dto.setFile(file);
        FileUpload fileUpload = uploadService.update(dto);

        return success("修改成功", fileUpload);
    }

    /**
     * 删除上传的文件
     * 角色：企业负责人/老师
     *
     * @param erId   企业负责人/老师id
     * @param fileId 删除的文件id
     * @return 删除文件的结果信息
     */
    @DeleteMapping("/delete/{erId:\\d+}/{fileId:\\d+}")
    public ResultModel<FileUpload> updateFile(
            @PathVariable("erId") Long erId, @PathVariable("fileId") Long fileId) {
        FileUpload fileUpload = uploadService.delete(erId, fileId);

        return success("删除成功", fileUpload);
    }

    /**
     * 查询上传文件
     * 角色：企业负责人/老师、学校负责人/老师
     *
     * @param queryCondition 查询条件
     * @return 查询的文件列表
     */
    @PostMapping("/query")
    public ResultModel<List<FileUpload>> updateFile(@Valid @RequestBody QueryEnpFileUploadModel queryCondition) {
        List<FileUpload> fileUploadList = uploadService.query(queryCondition);

        return success("查询完成", fileUploadList);
    }

}
