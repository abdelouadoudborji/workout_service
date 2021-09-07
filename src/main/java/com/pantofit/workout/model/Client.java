package com.pantofit.workout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Client {
   
    private String Code;

    private String first_name;

    private String last_name;
    private Date birthday;

    private String email;
    private String phonenumber;

    private String address;
    private String photo;
}
