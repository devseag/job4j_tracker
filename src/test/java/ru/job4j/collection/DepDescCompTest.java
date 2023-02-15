package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DepDescCompTest {
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenUpKGoDesc() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenAsc() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K1/SK1/SSK2"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenDesc() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK1",
                "K2/SK1"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSecondDepartmentGoDesc() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK1",
                "K1/SK1"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSecondDepartmentGoAsc() {
        int rsl = new DepDescComp().compare(
                "K1/SK1",
                "K1/SK1/SSK1"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenFirstDepartmentGoAsc() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K1/SK1/SSK2"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenFirstDepartmentGoDesc() {
        int rsl = new DepDescComp().compare(
                "K1/SK2",
                "K1/SK1/SSK1"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSecondOnlyDepartmentGoDesc() {
        int rsl = new DepDescComp().compare(
                "K1/SK2",
                "K1/SK1/SSK2"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSecondODepartmentGoDesc() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        );
        assertThat(rsl).isGreaterThan(0);
    }
}