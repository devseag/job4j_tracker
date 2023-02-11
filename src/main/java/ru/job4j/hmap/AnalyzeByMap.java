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
        List<Label> labelList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : getMapLabels(pupils).entrySet()) {
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
        List<Label> labelList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : getMapLabels(pupils).entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Map<String, Integer> getMapLabels(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
//                if (map.containsKey(subject.name())) {
//                    map.replace(subject.name(), subject.score() + map.get(subject.name()));
//                } else {
//                    map.put(subject.name(), subject.score() + map.get(subject.name()));
//                }
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        return map;
    }
}