package edu.nextstep.camp.caculator

import com.google.common.truth.Truth.*
import edu.nextstep.camp.caculator.domain.Calculator
import edu.nextstep.camp.caculator.domain.Expression
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `덧셈 연산 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")
        expression.addExpression("3")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `뺄셈 연산 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("9")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(-7)
    }

    @Test
    fun `나누기 연산 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("8")
        expression.addExpression("/")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `곱하기 연산 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("8")
        expression.addExpression("*")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(16)
    }

    @Test
    fun `복합 연산자 연산자 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("2")
        expression.addExpression("*")
        expression.addExpression("2")
        expression.addExpression("/")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `양수 결과 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("3")
        expression.addExpression("-")
        expression.addExpression("3")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(20)
    }

    @Test
    fun `음수 결과 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("-")
        expression.addExpression("9")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(-7)
    }


    @Test
    fun `priority 테스트`() {
        // When
        val expression = Expression()
        expression.addExpression("2")
        expression.addExpression("+")
        expression.addExpression("3")
        expression.addExpression("*")
        expression.addExpression("4")
        expression.addExpression("/")
        expression.addExpression("2")
        val actual = calculator.calculate(expression)

        // Then
        assertThat(actual).isEqualTo(8)
    }
}