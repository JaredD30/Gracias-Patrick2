package com.adventurehub.api.core.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReservationService {
    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param reservationId
     * @return the reservation, if found, else null
     */
    @GetMapping(
            value    = "/reservation/{reservationId}",
            produces = "application/json")
    Reservation getReservation(@PathVariable Integer reservationId);

}
