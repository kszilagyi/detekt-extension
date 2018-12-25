package com.kristofszilagyi.detektextensions.rules

import io.gitlab.arturbosch.detekt.test.lint
import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.specs.StringSpec

class TryAvoidVarSpec : StringSpec() {

	val rule = TryAvoidVar()

	init {
		"declarations in functions" {
			val code = """
			fun test() {
				var a = 1
			}
			"""
			rule.lint(code) shouldHaveSize 1
		}

		"declarations in classes" {
			val code = """
			class Test {
				var a = 1
			}
			"""
			rule.lint(code) shouldHaveSize 1
		}

		"multiple declarations classes" {
			val code = """
			class Test {
				var a = 1
				var b = 1
				fun x() {
					var c = 1
				}
			}
			"""
			rule.lint(code) shouldHaveSize 3
		}

		"supression works" {
			val code = """
			class Test {
				@Suppress("TryAvoidVar")
				var a = 1
			}
			"""
			rule.lint(code) shouldHaveSize 0
		}
	}
}
