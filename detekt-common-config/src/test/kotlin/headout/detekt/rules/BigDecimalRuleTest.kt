package headout.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BigDecimalRuleTest {
    private val rule = BigDecimalRule(Config.empty)

    @Test
    fun `reports BigDecimal with 100`() {
        val code = """
            import java.math.BigDecimal

            fun example() {
                val bd = BigDecimal(100)
            }
        """.trimIndent()

        val findings = rule.compileAndLint(code)
        Assertions.assertEquals(1, findings.size)
        Assertions.assertEquals(
            "Creating a new BigDecimal with 100 is inefficient. Use BIG_DECIMAL_HUNDRED instead.",
            findings[0].message
        )
    }

    @Test
    fun `does not report BigDecimal with other values`() {
        val code = """
            import java.math.BigDecimal

            fun example() {
                val bd = BigDecimal(200)
            }
        """.trimIndent()

        val findings = rule.compileAndLint(code)
        Assertions.assertEquals(0, findings.size)
    }
}
