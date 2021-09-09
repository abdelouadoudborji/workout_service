package com.pantofit.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pantofit.workout.model.Abonnement;
import com.pantofit.workout.model.Salle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data

public class Workout {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    private Long id;
    private Date date_workout;
    private Long abonnementID;
    private Long SalleID;
    @Transient
    private Abonnement abonnement;
    @Transient
    private Salle salle;



}
