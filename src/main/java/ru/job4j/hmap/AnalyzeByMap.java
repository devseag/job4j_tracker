package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double cntElements = 0D;
        double sumSubjectScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScore += subject.score();
                cntElements++;
            }
        }
        return sumSubjectScore / cntElements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        double sumSubjectScore = 0D;
        double sumSubjectName = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScore += subject.score();
                sumSubjectName++;
            }
            Label labels = new Label(pupil.name(), sumSubjectScore / sumSubjectName);
            labelList.add(labels);
            sumSubjectScore = 0D;
            sumSubjectName = 0D;
        }

        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> mapScoreBySubject = new LinkedHashMap<>();
        double sumSubject = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubject += subject.score();
                mapScoreBySubject.put(subject.name(), (int) sumSubject);
            }

        }
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}