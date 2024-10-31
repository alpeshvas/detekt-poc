package headout.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NoDummyClassRuleTest {
    private val rule = NoDummyClassRule(Config.empty)

    @Test
    fun `reports class named Dummy`() {
        val code = """
            class Dummy {
            }
        """.trimIndent()

        val findings = rule.compileAndLint(code)
        Assertions.assertEquals(1, findings.size)
        Assertions.assertEquals(
            "Class name 'Dummy' is not allowed.",
            findings[0].message
        )
    }

    @Test
    fun `does not report class with other names`() {
        val code = """
            class NotDummy {
            }
        """.trimIndent()

        val findings = rule.compileAndLint(code)
        Assertions.assertEquals(0, findings.size)
    }
}
