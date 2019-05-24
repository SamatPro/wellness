package com.sera.wellness.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentForm {
    private String text;
    private Long articleId;
}
