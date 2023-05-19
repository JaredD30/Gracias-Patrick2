package com.adventurehub.microservices.core.travelpackage.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.activity.Activity;
import se.magnus.api.core.activity.ActivityService;
import se.magnus.util.http.ServiceUtil;

import java.util.List;

@RestController
public class ActivityServiceImpl implements ActivityService {

    private static final Logger LOG = LoggerFactory.getLogger(ActivityServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ActivityServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Activity> getActivities(Integer itineraryId) {
        LOG.debug("/activity return the found activities for itineraryId={}", itineraryId);
        return null;
    }

    @Override
    public Activity createActivity(Activity body) {
        return null;
    }
}