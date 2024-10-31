package headout.detekt.rules

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtClass

class NoDummyClassRule(config: Config) : Rule(config) {
    override val issue = Issue(
        id = "NoDummyClass",
        severity = Severity.Style,
        description = "Classes should not be named 'Dummy'.",
        debt = Debt.FIVE_MINS
    )

    override fun visitClass(klass: KtClass) {
        if (klass.name == "Dummy") {
            report(
                CodeSmell(
                    issue,
                    Entity.from(klass),
                    message = "Class name 'Dummy' is not allowed."
                )
            )
        }
        super.visitClass(klass)
    }
}
