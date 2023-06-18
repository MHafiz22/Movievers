package com.example.movieverse.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.movieverse.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : Fragment() {

    private lateinit var sharedPref: SharedPreferences
    private lateinit var buttonSwitch: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        buttonSwitch = view.findViewById(R.id.buttonSwitch)
        if (isNightModeEnabled()) {
            buttonSwitch.setImageResource(R.drawable.ic_light)
        } else {
            buttonSwitch.setImageResource(R.drawable.ic_dark)
        }

        updateSwitchModeButton()

        buttonSwitch.setOnClickListener {
            val nightModeEnabled = isNightModeEnabled()
            toggleNightMode(!nightModeEnabled)
            updateSwitchModeButton()
        }
    }

    private fun isNightModeEnabled(): Boolean {
        return sharedPref.getBoolean("night_mode_enabled", false)
    }

    private fun toggleNightMode(enableNightMode: Boolean) {
        sharedPref.edit().putBoolean("night_mode_enabled", enableNightMode).apply()
        AppCompatDelegate.setDefaultNightMode(if (enableNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun updateSwitchModeButton() {
        if (isNightModeEnabled()) {
            buttonSwitch.contentDescription = "Dark Mode"
        } else {
            buttonSwitch.contentDescription = "Light Mode"
        }
    }
}
