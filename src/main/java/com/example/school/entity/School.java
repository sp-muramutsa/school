package com.example.school.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name= "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private String name;
    private String location;
    private String principalName;

}
