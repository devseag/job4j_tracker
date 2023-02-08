package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMTheSamePerson() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenSecond = new Citizen("2f44a", "John Kran");
        Citizen citizenThird = new Citizen("2f44a", "Jeremy Naba");
        Citizen citizenFourth = new Citizen("2f44a", "Kris Seras");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizenSecond);
        office.add(citizenThird);
        office.add(citizenFourth);
        assertThat(office.add(citizenSecond)).isFalse();
    }
}