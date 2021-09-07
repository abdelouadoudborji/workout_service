package com.pantofit.workout.Feign;



import com.pantofit.workout.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping(path="/clients/{id}")
    public Client getCustomerById(@PathVariable(name="id") Long id);
}
