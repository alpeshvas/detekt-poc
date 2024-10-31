package headout.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

open class CommonRulesProvider : RuleSetProvider {
    override val ruleSetId: String = "headout-common-detekt-rules"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                BigDecimalRule(config),
                NoDummyClassRule(config)
            )
        )
    }
}
