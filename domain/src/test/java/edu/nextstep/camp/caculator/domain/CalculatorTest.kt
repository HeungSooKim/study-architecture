package edu.nextstep.camp.caculator.domain

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {

    @Test
    fun `양의수 테스트`() {
        // When
        val calculator = Calculator()
        val expression = Expression()
        expression.addExpression("1")
        expression.addExpression("+")
        expression.addExpression("1")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `음의수 테스트`() {
        // When
        val calculator = Calculator()
        val expression = Expression()
        expression.addExpression("1")
        expression.addExpression("-")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(-1)
    }
}