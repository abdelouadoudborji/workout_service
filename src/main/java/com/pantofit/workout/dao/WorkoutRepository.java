package com.pantofit.workout.dao;

import com.pantofit.workout.entities.Workout;
import com.pantofit.workout.model.Abonnement;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource()
public interface WorkoutRepository extends JpaRepository<Workout,Long> {


          ArrayList<Workout> findWorkoutByAbonnementID(Long AbonnementID);
}

