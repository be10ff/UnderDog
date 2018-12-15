package ru.abelov.underdog.presentation.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.abelov.underdog.R
import ru.abelov.underdog.presentation.view.fragment.RoundFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if(savedInstanceState == null) {
            changeFragment(RoundFragment())
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        if(cleanStack) {
            clearBackStack()
        }

//        ft.setCustomAnimations()

        ft.replace(R.id.container, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = supportFragmentManager
        if(manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fm = supportFragmentManager
        if(fm.backStackEntryCount > 1) {
            fm.popBackStack()
        } else {
            finish()
        }
    }
}
