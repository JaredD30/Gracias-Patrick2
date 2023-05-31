package com.adventurehub.microservices.core.payment.mapper;

import com.adventurehub.api.core.payment.Payment;
import com.adventurehub.api.core.payment.PaymentService;
import com.adventurehub.microservices.core.payment.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "paymentId", ignore = true)
    })
    Payment entityToApi(PaymentEntity payment);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    PaymentEntity apiToEntity(Payment api);
}

