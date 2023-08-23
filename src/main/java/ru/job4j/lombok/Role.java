package ru.job4j.lombok;

import lombok.*;

import java.util.List;

/**
 * Shablon Builder pozvoljaet izbavit' sintaksis ot get set prefiksov, chto delaet kod chishhe.
 * Kljuch builderMethodName zadaet imja metoda sozdanija ob#ekta kontejnera.
 * Po umolchaniju on nazyvaetsja builder().
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Role {

    private int id;
    private String name;

    /**
     * Annotacija @Singular pozvoljaet akkumulirovat' otdel'nye jelementy kollekcii.
     * Esli ee ubrat', to metod accessBy dolzhen prinimat' spisok.
     */
    @Singular("accessBy")
    private List<String> accessBy;

    public static void main(String[] args) {
        var role = Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);
    }
}