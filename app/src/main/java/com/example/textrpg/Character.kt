package com.example.textrpg

import kotlin.random.Random

interface CharacterActions {
    fun attack(target: Character)
    fun defend()
    fun heal()
}

data class Stats(var hp: Int, var def: Int, var atk: Int)

open class Character(val name: String, var stats: Stats) : CharacterActions {

    override fun attack(target: Character) {
        val crit = Random.nextInt(1, 11)
        val damage = stats.atk - target.stats.def + crit
        target.stats.hp -= if (damage > 0) damage else 0
        println("$name attacks ${target.name} for $damage damage!")
    }

    override fun defend() {
        println("$name defends!")
    }

    override fun heal() {
        val healAmount = Random.nextInt(2, 6)
        val healedHP = if (stats.hp + healAmount > 50) {
            50 - stats.hp
        }
        else {
            healAmount
        }
        stats.hp += healedHP
        println("$name heals for $healedHP HP!")
    }
}