package com.example.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    int value = 1;

    @Test
    @EnabledOnOs(OS.MAC)
    @Tag("fast")
    void create() {
        System.out.println(value++);
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Order(2)
    @DisplayName("테스트 반복하기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatedTest(RepetitionInfo info) {
        System.out.println(value++);
        Study study  = new Study();
        assertNotNull(study);
        System.out.println("RepeatedTest" + info.getCurrentRepetition());
    }

    @Order(1)
    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있습니다."})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @Test
    @DisplayName("스터디 만들기 ")
    @Disabled
    void creat1(){
        System.out.println("create1");
    }

    @Test
    void create_new_study() {
        Study study = new Study();

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."),
                () ->assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0 보다 커야 합니다.")
        );
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }
}