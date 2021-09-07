package com.pantofit.workout.web;

import com.pantofit.workout.Feign.AbonnementRestClient;
import com.pantofit.workout.Feign.ClientRestClient;
import com.pantofit.workout.Feign.SalleRestClient;
import com.pantofit.workout.dao.WorkoutRepository;
import com.pantofit.workout.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WorkoutController {

    private WorkoutRepository workoutRepository;
    private AbonnementRestClient abonnementRestClient;
    private SalleRestClient     salleRestClient;
    private ClientRestClient clientRestClient;
    private KeycloakRestTemplate keycloakRestTemplate;


    public WorkoutController(WorkoutRepository workoutRepository,AbonnementRestClient abonnementRestClient,SalleRestClient  salleRestClient,ClientRestClient clientRestClient){
this.abonnementRestClient=abonnementRestClient;
this.clientRestClient=clientRestClient;
this.salleRestClient=salleRestClient;
this.workoutRepository=workoutRepository;

    }


   @AllArgsConstructor
    @NoArgsConstructor
    @Data @ToString
class historique{
        String sallenom;
        Date date;

}
 @GetMapping("/clients")
    public historique historiquetraining(String username){
Client client=keycloakRestTemplate.getForObject("https://client-api-service.herokuapp.com/clients/65",Client.class);
System.out.println(client.getId());
       return null;
    }
}
