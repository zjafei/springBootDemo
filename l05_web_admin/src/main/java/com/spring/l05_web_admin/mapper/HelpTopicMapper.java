package com.spring.l05_web_admin.mapper;

import com.spring.l05_web_admin.model.HelpTopic;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelpTopicMapper {
    public HelpTopic getHelpTopic(Long helpTopicId);
}
