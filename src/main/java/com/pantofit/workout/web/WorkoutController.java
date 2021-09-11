package com.pantofit.workout.web;

import com.pantofit.workout.Feign.AbonnementRestClient;
import com.pantofit.workout.Feign.ClientRestClient;
import com.pantofit.workout.Feign.SalleRestClient;
import com.pantofit.workout.dao.WorkoutRepository;
import com.pantofit.workout.entities.Workout;
import com.pantofit.workout.model.Abonnement;
import com.pantofit.workout.model.Client;
import com.pantofit.workout.model.Salle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

@RestController
public class WorkoutController {

    private WorkoutRepository workoutRepository;
    private AbonnementRestClient abonnementRestClient;
    private SalleRestClient     salleRestClient;
    private ClientRestClient clientRestClient;
    private KeycloakRestTemplate keycloakRestTemplate;


    public WorkoutController(WorkoutRepository workoutRepository,KeycloakRestTemplate keycloakRestTemplate,AbonnementRestClient abonnementRestClient,SalleRestClient  salleRestClient,ClientRestClient clientRestClient){
this.abonnementRestClient=abonnementRestClient;
this.clientRestClient=clientRestClient;
this.salleRestClient=salleRestClient;
this.workoutRepository=workoutRepository;
this.keycloakRestTemplate=keycloakRestTemplate;

    }


   @AllArgsConstructor
    @NoArgsConstructor
    @Data @ToString
class historique{
        String sallenom;
        Date date;

}
 @GetMapping(path="/clients/{id}")
    public ArrayList<historique> historiquetraining(@PathVariable(name="id") Long id){
     ArrayList<historique> listhistorique=new ArrayList<>();
     Long Abonnementid=keycloakRestTemplate.getForObject("https://abonnement-api-service.herokuapp.com/getAbonnement/"+id,Long.class);

     ArrayList<Workout> workouts= this.workoutRepository.findWorkoutByAbonnementID(Abonnementid);
     workouts.forEach(workout -> workout.setSalle(keycloakRestTemplate.getForObject("https://salle-api-service.herokuapp.com/salles/"+workout.getSalleID(),Salle.class)));
     workouts.forEach(workout -> System.out.println(workout));
     workouts.forEach(workout -> listhistorique.add(new historique(workout.getSalle().getNom(),workout.getDate_workout())));
       return listhistorique;
    }
    @GetMapping(path="/workoutcheck/{id}/{code}")
    public boolean checkworkout(@PathVariable(name="id") Long id,@PathVariable(name="code") String code){
boolean check=keycloakRestTemplate.getForObject("https://abonnement-api-service.herokuapp.com/workout/"+id,Boolean.class);
if(check){
    Long SalleID=keycloakRestTemplate.getForObject("https://salle-api-service.herokuapp.com/getSalleCode/"+code,Long.class);
    if(SalleID >1){
    Long Abonnementid=keycloakRestTemplate.getForObject("https://abonnement-api-service.herokuapp.com/getAbonnement/"+id,Long.class);
Workout workout=new Workout();
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
workout.setDate_workout(date);
workout.setAbonnementID(Abonnementid);
workout.setSalleID(SalleID);
workoutRepository.save(workout);
return true;
    }
    return false;

}

        return false;
    }
}
