package com.adventurehub.microservices.composite.travelpackage.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.adventurehub.api.core.activity.Activity;
import com.adventurehub.api.core.activity.ActivityService;
import com.adventurehub.api.core.category.Category;
import com.adventurehub.api.core.category.CategoryService;
import com.adventurehub.api.core.destination.Destination;
import com.adventurehub.api.core.destination.DestinationService;
import com.adventurehub.api.core.itinerary.Itinerary;
import com.adventurehub.api.core.itinerary.ItineraryService;
import com.adventurehub.api.core.season.Season;
import com.adventurehub.api.core.season.SeasonService;
import com.adventurehub.api.core.travelpackage.TravelPackage;
import com.adventurehub.api.core.travelpackage.TravelPackageService;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetails;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetailsService;
import com.adventurehub.util.exceptions.InvalidInputException;
import com.adventurehub.util.exceptions.NotFoundException;
import com.adventurehub.util.http.HttpErrorInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class TravelPackageCompositeIntegration implements
        TravelPackageService,
        ItineraryService,
        TravelPackageDetailsService,
        DestinationService,
        SeasonService,
        CategoryService,
        ActivityService
{

    private static final Logger LOG = LoggerFactory.getLogger(TravelPackageCompositeIntegration.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String travelPackageServiceUrl;

    @Autowired
    public TravelPackageCompositeIntegration(
        RestTemplate restTemplate,
        ObjectMapper mapper,

        @Value("${app.travel-package-service.host}") String travelPackageServiceHost,
        @Value("${app.travel-package-service.port}") int    travelPackageServicePort
    ) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        travelPackageServiceUrl    = "http://" + travelPackageServiceHost + ":" + travelPackageServicePort;
    }

    @Override
    public TravelPackage createTravelPackage(TravelPackage body) {
        try {
            String url = travelPackageServiceUrl + "/travelPackage";
            LOG.debug("Will post a new travelPackage to URL: {}", url);

            TravelPackage travelPackage = restTemplate.postForObject(url, body, TravelPackage.class);
            LOG.debug("Created a travelPackage with id: {}", travelPackage.getTravelPackageId());

            return travelPackage;

        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {

                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY :
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    @Override
    public List<TravelPackage> getTravelPackages() {

        try {

            String url = travelPackageServiceUrl + "/travelPackage";

            LOG.debug("Will call getTravelPackages API on URL: {}", url);

            List<TravelPackage> travelPackages = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<TravelPackage>>() {}).getBody();
            LOG.debug("Found {} travelPackages", travelPackages.size());

            return travelPackages;

        } catch (HttpClientErrorException ex) {

            switch (ex.getStatusCode()) {

            case NOT_FOUND:
                throw new NotFoundException(getErrorMessage(ex));

            case UNPROCESSABLE_ENTITY :
                throw new InvalidInputException(getErrorMessage(ex));

            default:
                LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                throw ex;
            }
        }
    }

    @Override
    public TravelPackage getTravelPackageById(Integer travelPackageId){

            try {
                String url = travelPackageServiceUrl + "/travelPackage/" + travelPackageId;
                LOG.debug("Will call getTravelPackageById API on URL: {}", url);

                TravelPackage travelPackage = restTemplate.getForObject(url, TravelPackage.class);
                LOG.debug("Found a travelPackage with id: {}", travelPackage.getTravelPackageId());

                return travelPackage;

            } catch (HttpClientErrorException ex) {
                switch (ex.getStatusCode()) {

                    case NOT_FOUND:
                        throw new NotFoundException(getErrorMessage(ex));

                    case UNPROCESSABLE_ENTITY :
                        throw new InvalidInputException(getErrorMessage(ex));

                    default:
                        LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                        LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                        throw ex;
                }
            }
    }

    @Override
    public List<Itinerary> getItineraries(Integer travelPackageId){
        try {
            String url = travelPackageServiceUrl + "itinerary?travelPackageId=" + travelPackageId;
            LOG.debug("Will call getItineraries API on URL: {}", url);
            List<Itinerary> itineraries = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Itinerary>>() {}).getBody();

            LOG.debug("Found {} itineraries for a travelPackage with id: {}", itineraries.size(), travelPackageId);
            return itineraries;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting itineraries, return zero itineraries: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Itinerary createItinerary(Itinerary body) {
        try {
            String url = travelPackageServiceUrl + "/itinerary";
            LOG.debug("Will post a new travelPackageDetails to URL: {}", url);

            Itinerary itinerary = restTemplate.postForObject(url, body, Itinerary.class);
            LOG.debug("Created a itinerary with id: {}", itinerary.getItineraryId());

            return itinerary;

        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {

                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY :
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    @Override
    public List<Activity> getActivities(Integer itineraryId){
        try {
            String url = travelPackageServiceUrl + "activity?itineraryId=" + itineraryId;
            LOG.debug("Will call getActivities API on URL: {}", url);
            List<Activity> activities = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Activity>>() {}).getBody();

            LOG.debug("Found {} activities for a travelPackage with id: {}", activities.size(), itineraryId);
            return activities;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting activities, return zero itineraries: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Activity createActivity(Activity body){
        try {
            String url = travelPackageServiceUrl + "/activity";
            LOG.debug("Will post a new activity to URL: {}", url);

            Activity activity = restTemplate.postForObject(url, body, Activity.class);
            LOG.debug("Created a activity with id: {}", activity.getActivityId());

            return activity;

        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {

                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY :
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }


    @Override
    public List<TravelPackageDetails> getTravelPackageDetails(Integer travelPackageId){
        try {
            String url = travelPackageServiceUrl + "travelPackageDetails?travelPackageId=" + travelPackageId;
            LOG.debug("Will call getTravelPackageDetails API on URL: {}", url);
            List<TravelPackageDetails> travelPackageDetails = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<TravelPackageDetails>>() {}).getBody();

            LOG.debug("Found {} travelPackageDetails for a travelPackage with id: {}", travelPackageDetails.size(), travelPackageId);
            return travelPackageDetails;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting travelPackageDetails, return zero travelPackageDetails: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public TravelPackageDetails createTravelPackageDetails(TravelPackageDetails body) {
        try {
            String url = travelPackageServiceUrl + "/travelPackageDetails";
            LOG.debug("Will post a new travelPackageDetails to URL: {}", url);

            TravelPackageDetails travelPackageDetails = restTemplate.postForObject(url, body, TravelPackageDetails.class);
            LOG.debug("Created a travelPackageDetails with id: {}", travelPackageDetails.getTravelPackageDetailsId());

            return travelPackageDetails;

        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {

                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY :
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    @Override
    public Destination getDestination(Integer destinationId) {
        try {
            String url = travelPackageServiceUrl + "/destination/" + destinationId;
            LOG.debug("Will call getDestination API on URL: {}", url);

            Destination destination = restTemplate.getForObject(url, Destination.class);

            LOG.debug("Found destination for a destination with id: {}", destinationId);
            return destination;
        } catch(Exception ex) {
            LOG.warn("Got an exception while requesting destination, return zero destination: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Category getCategory(Integer categoryId) {
        try {
            String url = travelPackageServiceUrl + "/category/" + categoryId;
            LOG.debug("Will call getCategory API on URL: {}", url);

            Category category = restTemplate.getForObject(url, Category.class);

            LOG.debug("Found category for a category with id: {}", categoryId);
            return category;
        } catch(Exception ex) {
            LOG.warn("Got an exception while requesting category, return zero category: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Season getSeason(Integer seasonId) {
        try {
            String url = travelPackageServiceUrl + "/season/" + seasonId;
            LOG.debug("Will call getSeason API on URL: {}", url);

            Season season = restTemplate.getForObject(url, Season.class);

            LOG.debug("Found season for a season with id: {}", seasonId);
            return season;
        } catch(Exception ex) {
            LOG.warn("Got an exception while requesting season, return zero season: {}", ex.getMessage());
            return null;
        }
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }
}
