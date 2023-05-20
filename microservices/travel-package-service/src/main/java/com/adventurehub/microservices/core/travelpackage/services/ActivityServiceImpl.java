package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.ActivityEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.ActivityMapper;
import com.adventurehub.microservices.core.travelpackage.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.activity.Activity;
import com.adventurehub.api.core.activity.ActivityService;
import com.adventurehub.util.http.ServiceUtil;

import java.util.List;

@RestController
public class ActivityServiceImpl implements ActivityService {

    private static final Logger LOG = LoggerFactory.getLogger(ActivityServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final ActivityRepository repository;

    private final ActivityMapper mapper;

    @Autowired
    public ActivityServiceImpl(ServiceUtil serviceUtil, ActivityRepository repository, ActivityMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Activity> getActivities(Integer itineraryId) {
        LOG.debug("/activity return the found activities for itineraryId={}", itineraryId);
        return null;
    }

    @Override
    public Activity createActivity(Activity body) {

        ActivityEntity entity = mapper.apiToEntity(body);
        ActivityEntity newEntity = repository.save(entity);

        LOG.debug("createActivity: entity created for activity", newEntity.getId() );

        Activity activity = mapper.entityToApi(newEntity);
        activity.setActivityId(newEntity.getId());

        return activity;
    }
}