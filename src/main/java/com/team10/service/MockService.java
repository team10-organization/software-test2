package com.team10.service;
import com.team10.domain.Subject;
import com.team10.repository.MockRepository;

import java.util.List;

public class MockService {
    private final MockRepository mockRepository;

    public MockService(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    public List<Subject> findAllSubjects() {
        return mockRepository.findAll();
    }

    public Subject findSubjectByName(String name) {
        Subject subject = mockRepository.findSubjectByName(name);
        return subject;
    }

    public void addSubject(Subject subject) {
        Subject addSubject = new Subject(subject.getName(), subject.getCode(), subject.getPrerequisiteSubject(), subject.getGrade());
        mockRepository.addSubject(addSubject);
        return;
    }

    public int getGradebySubjectName(String name)
    {

    }
}