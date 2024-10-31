package headout.detekt.rules
import io.gitlab.arturbosch.detekt.api.*
import io.gitlab.arturbosch.detekt.api.internal.ActiveByDefault
import org.jetbrains.kotlin.psi.KtCallExpression

@ActiveByDefault(since = "1.0.0")
class BigDecimalRule(config: Config) : Rule(config) {

    override val issue: Issue = Issue(
        id = "AvoidNewBigDecimalWithConstant",
        severity = Severity.Performance,
        description = "Avoid creating a new BigDecimal with 100; use BIG_DECIMAL_HUNDRED instead.",
        debt = Debt.FIVE_MINS
    )

    companion object {
        private const val BIG_DECIMAL = "BigDecimal"
        private const val VALUE_100 = "100"
        private const val MESSAGE = "Creating a new BigDecimal with 100 is inefficient." +
                " Use BIG_DECIMAL_HUNDRED instead."
    }

    override fun visitCallExpression(expression: KtCallExpression) {
        super.visitCallExpression(expression)

        val calleeExpression = expression.calleeExpression?.text
        val valueArgument = expression.valueArguments.firstOrNull()?.getArgumentExpression()?.text
        println("HelloHello")
        if (calleeExpression == BIG_DECIMAL && valueArgument == VALUE_100) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(expression),
                    MESSAGE
                )
            )
        }
    }
}
