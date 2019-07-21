package com.team10.service;

import com.team10.domain.Subject;
import com.team10.repository.MockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
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

    // by 정상현, 존재하지 않는 과목명을 이름으로 설정하면 오류가 발생하게 테스트.
    @Test(expected = IllegalArgumentException.class)
    public void 존재하지_않는_과목명을_설정하면_오류를_발생(){
        Subject subject = mock(Subject.class);
        doThrow(new IllegalArgumentException()).when(subject).setName("실전코딩2");
        subject.setName("실전코딩2");
    }
    //by 정상현, 제한된 시간내에 실행되는지에 대한 테스트.
    @Test(timeout = 2000)
    public void 제한_시간내에_실행되는지_테스트() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("제한된 시간 내에 수행되면 테스트 passed!");
    }

    @Test
    public void 과목명으로_검색하면_해당_과목이_나오고_Service에서_메소드를_호출하는지_테스트(){
        when(mockService.findSubjectByName("실전코딩1")).thenReturn(new Subject("실전코딩1", "X470", "객체지향프로그래밍",3));
        String subjectName = mockService.findSubjectByName("실전코딩1").getName();
        assertThat(subjectName, is("실전코딩1"));
        verify(mockRepository, times(1)).findSubjectByName(any(String.class));
    }


    @Test
    public void 과목명을_입력하면_학점을_리턴하는_테스트()//by윤준성 통과!!
    {
        Subject subject = mock(Subject.class);
        when(mockService.getGradebySubjectName(anyString())).thenReturn(3);
        assertThat(mockService.getGradebySubjectName("실전코딩"), is(3));
        verify(mockRepository, times(1)).getGradebySubjectName(anyString());
    }


    @Test
    public void 과목명을_넣어서_클래스를만들면_과목명이_잘들어갔는지_확인하는_테스트()//by 윤준성 통과!
    {
        when(mockService.createSubjectbyName("실전코딩")).thenReturn(new Subject("실전코딩", null, null, 3));
        Subject subject = mockService.createSubjectbyName("실전코딩");
        assertThat(subject.getName(), is("실전코딩"));
        verify(mockRepository, times(1)).createSubjectbyName(anyString());


    }

    @Test
    public void 과목명을_입력하면_클래스를_리턴() {
        Subject subject = mock(Subject.class);
        when(mockService.findSubjectByName("실전코딩")).thenReturn(new Subject("실전코딩", "X230",
                "객체지향프로그래밍", 3));
        assertThat(mockService.findSubjectByName("실전코딩"), instanceOf(Subject.class));
    } // 과목명으로 검색하면 Subject 객체를 리턴하는지 테스트하는 코드 changed by 마성호
}
