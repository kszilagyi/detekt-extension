package com.kristofszilagyi.detektextensions.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtProperty


class TryAvoidVar(config: Config = Config.empty) : Rule(config) {

	override val defaultRuleIdAliases: Set<String> = setOf("TryAvoidVar")

	override val issue: Issue = Issue("TryAvoidVar",
			Severity.Maintainability,
			"Var declarations should be avoided whenever possible. If you really need it, please suppress.",
			Debt.FIVE_MINS)

	override fun visitProperty(property: KtProperty) {
		if (property.isVar) report(CodeSmell(issue, Entity.from(property), "Try to avoid vars."))
	}
}