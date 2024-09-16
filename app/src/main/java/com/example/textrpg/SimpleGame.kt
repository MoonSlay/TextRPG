package com.example.textrpg

import kotlin.random.Random

class SimpleGame(val hero: Hero, val enemy: Enemy) : GameInterface {

    override fun startGame() {
        println("Welcome to the RPG!")
        var turn = 1
        while (hero.stats.hp > 0 && enemy.stats.hp > 0) {
            println("\n--- Turn $turn ---")

            val heroAction = Random.nextInt(3)
            val enemyAction = Random.nextInt(3)

            resolveActions(hero, heroAction, enemy, enemyAction)

            println("Hero HP: ${hero.stats.hp}, Enemy HP: ${enemy.stats.hp}")

            turn++
        }
        endGame(if (hero.stats.hp > 0) hero else enemy)
    }

    private fun resolveActions(hero: Hero, heroAction: Int, enemy: Enemy, enemyAction: Int) {
        if (heroAction == 0 && enemyAction != 1) {
            hero.attack(enemy)
        }
        else if (heroAction == 0 && enemyAction == 1) { // Hero attacks enemy defends
            println("${enemy.name} defended an attack from ${hero.name}!")
        }

        if (enemyAction == 0 && heroAction != 1) {
            enemy.attack(hero)
        } else if (enemyAction == 0 && heroAction == 1) { // Enemy attacks hero defends
            println("${hero.name} defended an attack from ${enemy.name}!")
        }

        if (heroAction == 1 && enemyAction != 0) {
            hero.defend()
        }
        if (enemyAction == 1 && heroAction != 0) {
            enemy.defend()
        }

        if (heroAction == 2) {
            hero.heal()
        }
        if (enemyAction == 2) {
            enemy.heal()
        }

    }

    override fun endGame(winner: Character?) {
        if (winner == null) {
            println("It's a draw!")
        }
        else {
            println("${winner.name} wins!")
        }
    }
}