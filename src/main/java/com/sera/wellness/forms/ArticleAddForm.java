package com.sera.wellness.forms;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ArticleAddForm {
    private String title;
    private String text;
    private MultipartFile file;
}
