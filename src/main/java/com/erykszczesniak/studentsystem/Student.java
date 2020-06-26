package com.erykszczesniak.studentsystem;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    Long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String subject;

    @Column
    int grade;




}
