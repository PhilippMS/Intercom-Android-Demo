package com.example.philippintercomdemo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//Imported based on Intercom.initialize
import io.intercom.android.sdk.Intercom
//Imported based on Registration.create()
import io.intercom.android.sdk.identity.Registration
//Imported based on Button Usage
import android.widget.Button
//Imported based on SwitchMaterial Usage / alternatively you could use SwitchCompat / or outdated Switch
//import android.widget.Switch
import com.google.android.material.switchmaterial.SwitchMaterial


//Intercom (Custom Class to initialize Intercom)
class IntercomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Intercom.initialize(this, getString(R.string.intercom_api_key), getString(R.string.intercom_app_id))
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Intercom (Registration):
        val registration = Registration.create().withEmail(getString(R.string.intercom_user_email))
        Intercom.client().registerIdentifiedUser(registration)

        //Custom (Messenger Button)
        // get reference to button
        val buttonMessenger = findViewById<Button>(R.id.buttonMessenger)
        // set on-click listener
        buttonMessenger.setOnClickListener {
            // your code to perform when the user clicks on the button
            Intercom.client().displayMessenger()
        }

        //Custom (Carousel Button)
        val buttonCarousel = findViewById<Button>(R.id.buttonCarousel)
        buttonCarousel.setOnClickListener {
            Intercom.client().displayCarousel(getString(R.string.intercom_carousel_id))
        }

        //Custom (Launcher Switch)
        val switchLauncher = findViewById<SwitchMaterial>(R.id.switchLauncher)
        switchLauncher.setOnClickListener {
            if (switchLauncher.isChecked) {
                Intercom.client().setLauncherVisibility(Intercom.Visibility.VISIBLE)
            }
            else {
                Intercom.client().setLauncherVisibility(Intercom.Visibility.GONE)
            }
        }

    }
}