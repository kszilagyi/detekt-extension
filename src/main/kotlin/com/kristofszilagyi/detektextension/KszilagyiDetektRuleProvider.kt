package com.kristofszilagyi.detektextension

import com.kristofszilagyi.detektextensions.rules.TryAvoidVar
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider


class KszilagyiDetektRuleProvider : RuleSetProvider {
	override val ruleSetId: String = "kszilagyi-extensions"

	override fun instance(config: Config): RuleSet {
		return RuleSet(ruleSetId, listOf(
				TryAvoidVar()
		))
	}
}