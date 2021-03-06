package org.assertj.vavr.api;

import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

class TryAssert_containsSame_Test {

    @Test
    void should_fail_when_try_is_null() {
        assertThatThrownBy(
                () -> assertThat((Try<String>) null).containsSame("")
        )
                .isInstanceOf(AssertionError.class)
                .hasMessage(actualIsNull());
    }

    @Test
    void should_fail_when_expected_value_is_null() {
        assertThatThrownBy(
                () -> assertThat(Try.success("some value")).containsSame(null)
        )
                .isInstanceOf(AssertionError.class)
                .hasMessage("\nExpecting:\n  <Success(some value)>\nto contain the instance (i.e. compared with ==):\n  <null>\nbut did not.");
    }

    @Test
    void should_pass_when_null_success_try_checked_on_containing_same_value() {
        assertThat(Try.success(null)).containsSame(null);
    }

    @Test
    void should_fail_when_success_try_contains_not_the_same_value() {
        final String actual = "OK";
        final String expected = new String(actual);
        assertThatThrownBy(
                () -> assertThat(Try.success(actual)).containsSame(expected)
        )
                .isInstanceOf(AssertionError.class)
                .hasMessage("\nExpecting:\n  <Success(OK)>\nto contain the instance (i.e. compared with ==):\n  <\"OK\">\nbut did not.");
    }

    @Test
    void should_fail_when_success_try_contains_different_value() {
        final String actual = "OK";
        final String expected = "different";
        assertThatThrownBy(
                () -> assertThat(Try.success(actual)).containsSame(expected)
        )
                .isInstanceOf(AssertionError.class)
                .hasMessage("\nExpecting:\n  <Success(OK)>\nto contain the instance (i.e. compared with ==):\n  <\"different\">\nbut did not.");
    }

    @Test
    void should_pass_when_success_try_contains_the_same_value() {
        final String value = "OK";
        assertThat(Try.success(value)).containsSame(value);
    }

    @Test
    void should_fail_when_try_is_a_failure() {
        final NullPointerException exception = new NullPointerException();
        assertThatThrownBy(
                () -> assertThat(Try.failure(exception)).containsSame(exception)
        )
                .isInstanceOf(AssertionError.class)
                .hasMessage("\nExpecting Try to contain:\n  <java.lang.NullPointerException>\nbut was empty.");
    }
}