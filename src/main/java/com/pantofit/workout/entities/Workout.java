package com.pantofit.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private Date date_workout;
    private Long AbonnementID;
    private Long SalleID;
   /* @ManyToOne
    private Abonnement abonnement;
    @ManyToOne
    private Salle salle;
   */
@Transient
    private Abonnement abonnement;
    @Transient
    private Salle salle;


}
