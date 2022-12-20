package edu.nextstep.camp.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.History
import edu.nextstep.camp.calculator.domain.HistoryData
import edu.nextstep.camp.calculator.domain.Operator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val historyAdapter = HistoryAdapter()

    private val calculator: Calculator = Calculator()
    private var expression: Expression = Expression.EMPTY
    private val history: History = History()
    private var isHistoryShow = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            expression += 0
            binding.textView.text = expression.toString()
        }
        binding.button1.setOnClickListener {
            expression += 1
            binding.textView.text = expression.toString()
        }
        binding.button2.setOnClickListener {
            expression += 2
            binding.textView.text = expression.toString()
        }
        binding.button3.setOnClickListener {
            expression += 3
            binding.textView.text = expression.toString()
        }
        binding.button4.setOnClickListener {
            expression += 4
            binding.textView.text = expression.toString() }
        binding.button5.setOnClickListener {
            expression += 5
            binding.textView.text = expression.toString()
        }
        binding.button6.setOnClickListener {
            expression += 6
            binding.textView.text = expression.toString()
        }
        binding.button7.setOnClickListener {
            expression += 7
            binding.textView.text = expression.toString()
        }
        binding.button8.setOnClickListener {
            expression += 8
            binding.textView.text = expression.toString()
        }
        binding.button9.setOnClickListener {
            expression += 9
            binding.textView.text = expression.toString()
        }

        binding.buttonPlus.setOnClickListener {
            expression += Operator.Plus
            binding.textView.text = expression.toString()
        }
        binding.buttonMinus.setOnClickListener {
            expression += Operator.Minus
            binding.textView.text = expression.toString()
        }
        binding.buttonMultiply.setOnClickListener {
            expression += Operator.Multiply
            binding.textView.text = expression.toString()
        }
        binding.buttonDivide.setOnClickListener {
            expression += Operator.Divide
            binding.textView.text = expression.toString()
        }

        binding.buttonDelete.setOnClickListener {
            expression = expression.removeLast()
            binding.textView.text = expression.toString()
        }
        binding.buttonEquals.setOnClickListener {
            val result = calculator.calculate(expression.toString())
            if (result == null) {
                Toast.makeText(this, R.string.incomplete_expression, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            history.addHistory(expression, result)
            expression = Expression.EMPTY + result
            binding.textView.text = expression.toString()
        }

        binding.recyclerView.apply {
            adapter = historyAdapter
        }

        binding.buttonMemory.setOnClickListener {
            if (isHistoryShow) {
                isHistoryShow = false

                binding.recyclerView.isVisible = false
                binding.textView.isInvisible = false

            } else {
                isHistoryShow = true

                binding.recyclerView.isVisible = true
                binding.textView.isInvisible = true
                historyAdapter.submitList(history.getHistories())
            }
        }
    }
}
