package com.adventurehub.microservices.core.travelpackage.seed;

import com.adventurehub.microservices.core.travelpackage.entity.DestinationEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.DestinationMapper;
import com.adventurehub.microservices.core.travelpackage.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.magnus.api.core.destination.Destination;

@Service
public class DestinationSeed {

    @Autowired
    private  DestinationRepository repository;
    @Autowired
    private  DestinationMapper mapper;

    public DestinationSeed(DestinationRepository repository, DestinationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void seed() {
        DestinationEntity[] destinations = new DestinationEntity[]{
                mapper.apiToEntity(new Destination("Machu Picchu","An Incan citadel set high in the Andes Mountains in Peru, above the Urubamba River valley.")),
                mapper.apiToEntity(new Destination("Amazon Rainforest","The Amazon Rainforest is the largest tropical rainforest in the world, located in South America.")),
                mapper.apiToEntity(new Destination("Nazca Lines","A series of ancient geoglyphs located in the Nazca Desert in southern Peru.")),
                mapper.apiToEntity(new Destination("Colca Canyon","A canyon located in the Andes Mountains, known for its hiking trails and birdwatching opportunities.")),
                mapper.apiToEntity(new Destination("Lake Titicaca","The highest navigable lake in the world, located on the border of Peru and Bolivia.")),
                mapper.apiToEntity(new Destination("Huacachina","An oasis in the desert of southwestern Peru, known for its sand dunes and opportunities for sandboarding and dune buggy rides."))
        };

        for (DestinationEntity destination : destinations) {
            if(!repository.existsByName(destination.getName())) {
                repository.save(destination);
            }
        }
    }
}
