package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.TravelPackageDetailsEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.TravelPackageDetailsMapper;
import com.adventurehub.microservices.core.travelpackage.repository.TravelPackageDetailsRepository;
import com.adventurehub.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetails;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetailsService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TravelPackageDetailsServiceImpl implements TravelPackageDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(TravelPackageDetailsServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final TravelPackageDetailsRepository repository;

    private final TravelPackageDetailsMapper mapper;

    @Autowired
    public TravelPackageDetailsServiceImpl(ServiceUtil serviceUtil, TravelPackageDetailsRepository repository, TravelPackageDetailsMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TravelPackageDetails> getTravelPackageDetails(Integer travelPackageId) {

        List<TravelPackageDetails> list = new ArrayList<>();
        Iterable<TravelPackageDetailsEntity> entityList = repository.findAll();

        entityList.forEach(entity -> {
            TravelPackageDetails response = mapper.entityToApi(entity);
            response.setTravelPackageDetailsId(entity.getId());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            list.add(response);
        });

        LOG.debug("/travelPackages response size: {}", list.size());

        return list;
    }

    @Override
    public TravelPackageDetails createTravelPackageDetails(TravelPackageDetails body) {

        TravelPackageDetailsEntity entity = mapper.apiToEntity(body);
        TravelPackageDetailsEntity newEntity = repository.save(entity);

        LOG.debug("createTravelPackageDetails: entity created for travelPackageDetailsId", newEntity.getId() );

        TravelPackageDetails travelPackageDetails = mapper.entityToApi(newEntity);
        travelPackageDetails.setTravelPackageDetailsId(newEntity.getId());

        return travelPackageDetails;
    }
}