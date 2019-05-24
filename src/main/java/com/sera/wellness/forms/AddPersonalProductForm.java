package com.sera.wellness.forms;

import com.sera.wellness.models.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class AddPersonalProductForm {
    private String name;
    private MultipartFile img;
    private Float protein;
    private Float fats;
    private Float carbohydrates;
    private Float calories;
    private Boolean type;
    //private User user;
}
