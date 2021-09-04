package com.pantofit.workout.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "SALLE-SERVICE")//client-service
public interface SalleRestClient {
}
