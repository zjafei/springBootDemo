package com.spring.l05_web_admin.implement;

import com.spring.l05_web_admin.mapper.HelpTopicMapper;
import com.spring.l05_web_admin.model.HelpTopic;
import com.spring.l05_web_admin.service.HelpTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpTopicServiceImpl implements HelpTopicService {
    @Autowired
    HelpTopicMapper helpTopicmMapper;

    public HelpTopic getHelpTopic(Long helpTopicId) {
        return helpTopicmMapper.getHelpTopic(helpTopicId);
    }

}
