package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.mapper.TravelPackageMapper;
import com.adventurehub.microservices.core.travelpackage.entity.TravelPackageEntity;
import com.adventurehub.microservices.core.travelpackage.repository.TravelPackageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.travelpackage.TravelPackage;
import se.magnus.api.core.travelpackage.TravelPackageService;
import se.magnus.util.http.ServiceUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TravelPackageServiceImpl implements TravelPackageService {

    private static final Logger LOG = LoggerFactory.getLogger(TravelPackageServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final TravelPackageRepository repository;

    private final TravelPackageMapper mapper;

    @Autowired
    public TravelPackageServiceImpl(ServiceUtil serviceUtil, TravelPackageRepository repository, TravelPackageMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TravelPackage> getTravelPackages() {

        List<TravelPackage> list = new ArrayList<>();
        Iterable<TravelPackageEntity> entityList = repository.findAll();

        entityList.forEach(entity -> {
            TravelPackage response = mapper.entityToApi(entity);
            response.setTravelPackageId(entity.getId());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            list.add(response);
        });

        LOG.debug("/travelPackages response size: {}", list.size());

        return list;
    }

    @Override
    public TravelPackage createTravelPackage(TravelPackage body) {

        TravelPackageEntity entity = mapper.apiToEntity(body);
        TravelPackageEntity newEntity = repository.save(entity);

        LOG.debug("createTravelPackage: entity created for travelPackageId", newEntity.getId() );

        TravelPackage travelPackage = mapper.entityToApi(newEntity);
        travelPackage.setTravelPackageId(newEntity.getId());

        return travelPackage;
    }
}