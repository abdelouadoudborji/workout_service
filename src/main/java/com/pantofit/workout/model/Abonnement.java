package com.pantofit.workout.model;

import com.pantofit.workout.entities.Workout;
import lombok.Data;
import java.util.List;


@Data
public class Abonnement {

    private Long id;

    private String Code;
    private Long PlanIDs;
    private int nbrseancerestants;
    private boolean courant;
    private Long ClientID;
    private String qrcode;
    private List<Workout> WorkoutList ;



}
