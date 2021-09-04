package com.pantofit.workout.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ABONNEMENT-SERVICE")//client-service
public interface AbonnementRestClient {
}
