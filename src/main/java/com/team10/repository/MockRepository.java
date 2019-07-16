package com.team10.repository;

import com.team10.domain.Subject;

import java.util.List;

public interface MockRepository {
    public List<Subject> findAll();

    public Subject findSubjectByName(String name);

    public void addSubject(Subject subject);
}