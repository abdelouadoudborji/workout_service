package com.pantofit.workout.dao;

import com.pantofit.workout.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}

