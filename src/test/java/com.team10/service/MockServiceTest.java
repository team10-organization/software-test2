package com.team10.service;

import com.team10.domain.Subject;
import com.team10.repository.MockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class MockServiceTest {

    @Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;

    //By오세훈, 실전코딩이라는 과목명으로 검색하면 그 과목명의 코드와 함께 가짜 객체를 리턴받고, 과목코드가 X470이 맞는지를 테스트하세요
    @Test
    public void 실전코딩이라는과목명으로_검색하면_과목명의코드와가짜객체를_리턴받고_과목코드가X470이_맞는지_테스트(){
        when(mockService.findSubjectByName("실전코딩")).thenReturn(new Subject("실전코딩", "X470", "객체지향프로그래밍",3));
        assertThat(mockService.findSubjectByName("실전코딩").getCode(), is("X470"));
    }

    //By오세훈, Subject 객체에서 과목코드를 가져오는 로직이 최소 3번 이상 실행되면 Pass 하는 로직입니다
    @Test
    public void Subject객체에서_최소3번이상_과목코드를가져오면_통과하는_테스트(){
        Subject subject = mock(Subject.class);
        subject.getCode();
        subject.getCode();
        subject.getCode();
        verify(subject, atLeast(3)).getCode();
    }
}
