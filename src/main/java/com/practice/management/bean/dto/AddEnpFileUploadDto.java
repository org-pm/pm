package com.practice.management.bean.dto;

import com.practice.management.bean.entity.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class AddEnpFileUploadDto extends FileUpload {

    /**
     * 企业负责人/老师id
     */
    @NotNull(message = "企业负责人id不能为空")
    private Long erId;

    private MultipartFile file;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
