package com.pantofit.workout.model;

import lombok.Data;

@Data
public class Salle {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String altitude;
    private String longitude;
    private String addressmail;
    private Long VilleID;
}
