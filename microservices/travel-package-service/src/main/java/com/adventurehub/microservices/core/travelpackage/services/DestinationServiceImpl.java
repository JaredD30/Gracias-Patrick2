package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.DestinationEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.DestinationMapper;
import com.adventurehub.microservices.core.travelpackage.repository.DestinationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.destination.Destination;
import com.adventurehub.api.core.destination.DestinationService;
import com.adventurehub.util.http.ServiceUtil;

import java.util.Optional;

@RestController
public class DestinationServiceImpl implements DestinationService {

    private static final Logger LOG = LoggerFactory.getLogger(DestinationServiceImpl.class);

    private final ServiceUtil serviceUtil;
    private final DestinationMapper mapper;
    private final DestinationRepository repository;

    @Autowired
    public DestinationServiceImpl(ServiceUtil serviceUtil, DestinationRepository repository, DestinationMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Destination getDestination(Integer destinationId) {
        LOG.debug("/destination return the found destination for destinationId={}", destinationId);

        Optional<DestinationEntity> entityDestination = repository.findById(destinationId);

        if(entityDestination.isPresent()){
            Destination response = mapper.entityToApi(entityDestination.get());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            response.setDestinationId(entityDestination.get().getId());
            return response;
        }

        return null;
    }

//    @Override
//    public Destination createDestination(Destination body) {
//        return null;
//    }
}