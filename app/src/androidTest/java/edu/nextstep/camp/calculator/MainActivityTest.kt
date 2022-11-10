package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

/*
## **기능 요구 사항**

- **입력된 피연산자가 없을 때**, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    - -> 1 클릭 -> **`1`**
    - **`5 +`** -> 1 클릭 -> **`5 + 1`**
- **입력된 피연산자가 있을 때**, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다. 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다.
    - **`8`** -> 9 클릭 -> **`89`**
- **입력된 피연산자가 없을 때**, 사용자가 연산자 **`+`**, **``**, **`×`**, **`÷`** 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    - -> + 클릭 ->
- **입력된 피연산자가 있을 때**, 사용자가 연산자 **`+`**, **``**, **`×`**, **`÷`** 버튼을 누르면 해당 기호가 화면에 보여야 한다.
    - **`1`** -> + 클릭 -> **`1 +`**
    - **`1 +`** -> - 클릭 -> **`1 -`**
- **입력된 수식이 없을 때**, 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    - -> 지우기 클릭 ->
- **입력된 수식이 있을 때**, 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다.
    - **`32 + 1`** -> 지우기 클릭 -> **`32 +`** -> 지우기 클릭 -> **`32`** -> 지우기 클릭 -> **`3`** -> 지우기 클릭 ->  -> 지우기 클릭 ->
- **입력된 수신이 완전할 때**, 사용자가 **`=`** 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다.
    - **`3 + 2`** -> **`=`** 클릭 -> **`5`**
- **입력된 수식이 완전하지 않을 때**, 사용자가 **`=`** 버튼을 눌렀을 때 **완성되지 않은 수식입니다** 토스트 메세지가 화면에 보여야 한다.
    - **`3 +`** -> **`=`** 클릭 -> **완성되지 않은 수식입니다**

## **프로그래밍 요구사항**

- 모든 기능 요구 사항에 대한 UI 테스트를 구현한다.
    - 단, 토스트 메세지에 대한 테스트는 제외한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
 */
class MainActivityTest {

    @get:Rule
    var actiityScanrioRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `사용자가_피연산자0_버튼을_누르면_화면에_해당_숫자가_화면에_보여야_한다`() {
        // When
        onView(withId(R.id.button0)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }
}