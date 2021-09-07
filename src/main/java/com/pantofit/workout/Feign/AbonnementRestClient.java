package com.pantofit.workout.Feign;

import com.pantofit.workout.model.Abonnement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ABONNEMENT-SERVICE")//client-service
public interface AbonnementRestClient {
    @GetMapping(path="/abonnements/{id}")
    public Abonnement getAbonnemnetById(@PathVariable(name="id") Long id);
}
