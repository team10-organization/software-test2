package com.team10.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
    private String name;
    private String code;
    private String prerequisiteSubject;
    private int grade;
}