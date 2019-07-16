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

    @Test
    public void 과목명을_입력하면_클래스를_리턴() {
        Subject subject = mock(Subject.class);
        when(mockService.findSubjectByName("실전코딩")).thenReturn(new Subject("실전코딩", "X230",
                "객체지향프로그래밍", 3));
        assertThat(mockService.findSubjectByName("실전코딩"), instanceOf(Subject.class));
    } // 과목명으로 검색하면 Subject 객체를 리턴하는지 테스트하는 코드 changed by 마성호

    @Test
    public void 과목명을_입력하면_선수과목을_리턴() {
        Subject subject = mock(Subject.class);
        when(mockService.findSubjectByName("실전코딩")).thenReturn(new Subject("실전코딩", "X230",
                "객체지향프로그래밍", 3));
        assertThat(mockService.findSubjectByName("실전코딩").getPrerequsiteSubject(), is("객체지향프로그래밍"));
        mockService.findSubjectByName("실전코딩");
        verify(mockRepository, times(2)).findSubjectByName(anyString());
    } /* 과목명으로 검색하면 선수과목명을 리턴하는지 테스트하고
     findSubjectByName가 2번 호출됐는지 확인하는 코드 changed by 마성호 */
}
