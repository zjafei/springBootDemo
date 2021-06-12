package com.spring.l05_web_admin.service;

import com.spring.l05_web_admin.mapper.HelpTopicMapper;
import com.spring.l05_web_admin.model.HelpTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpTopicService {
    @Autowired
    HelpTopicMapper helpTopicmMapper;

    public HelpTopic getHelpTopic(Long helpTopicId) {
        return helpTopicmMapper.getHelpTopic(helpTopicId);
    }

}
