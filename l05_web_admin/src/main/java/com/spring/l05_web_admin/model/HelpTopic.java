package com.spring.l05_web_admin.model;

import lombok.Data;

@Data
public class HelpTopic {
    private Long helpTopicId;
    private String name;
    private Integer helpCategoryId;
    private String description;
    private String example;
    private String url;
}
