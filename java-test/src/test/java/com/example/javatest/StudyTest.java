package com.example.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
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