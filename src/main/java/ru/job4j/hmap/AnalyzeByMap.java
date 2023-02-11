package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double cntElements = 0D;
        double sumSubjectScore = 0D;
        for (Pupil pupil : pupils) {
            cntElements += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumSubjectScore += subject.score();
            }
        }
        return sumSubjectScore / cntElements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        double sumSubjectScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScore += subject.score();
            }
            labelList.add(new Label(pupil.name(), sumSubjectScore / pupil.subjects().size()));
            sumSubjectScore = 0D;
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> mapScoreBySubject = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        int sumSubjectScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (mapScoreBySubject.containsKey(subject.name())) {
                    sumSubjectScore += subject.score() + mapScoreBySubject.get(subject.name());
                    mapScoreBySubject.put(subject.name(), sumSubjectScore);
                    sumSubjectScore = 0;
                } else {
                    mapScoreBySubject.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : mapScoreBySubject.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        double sumSubjectScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScore += subject.score();
            }
            labelList.add(new Label(pupil.name(), sumSubjectScore));
            sumSubjectScore = 0D;
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> mapBestSubject = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        int sumSubjectScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (mapBestSubject.containsKey(subject.name())) {
                    sumSubjectScore += subject.score() + mapBestSubject.get(subject.name());
                    mapBestSubject.put(subject.name(), sumSubjectScore);
                    sumSubjectScore = 0;
                } else {
                    mapBestSubject.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : mapBestSubject.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}