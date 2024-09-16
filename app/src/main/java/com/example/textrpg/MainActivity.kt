package com.example.textrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hero = Hero("Angelo", Stats(hp = 50, def = 10, atk = 15))
        val enemy = Enemy("Paper Bag", Stats(hp = 50, def = 5, atk = 12))
        val game = SimpleGame(hero, enemy)
        game.startGame()
    }
}