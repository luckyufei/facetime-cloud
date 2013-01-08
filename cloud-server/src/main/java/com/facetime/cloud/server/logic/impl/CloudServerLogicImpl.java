package com.facetime.cloud.server.logic.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facetime.cloud.server.logic.CloudServerLogic;
import com.facetime.spring.logic.LogicImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CloudServerLogicImpl extends LogicImpl implements CloudServerLogic {

}
