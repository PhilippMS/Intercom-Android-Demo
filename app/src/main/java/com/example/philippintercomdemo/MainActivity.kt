package com.example.philippintercomdemo

//Imported based on Intercom.initialize
//Imported based on Registration.create()
//Imported based on Button Usage
//Imported based on SwitchMaterial Usage / alternatively you could use SwitchCompat / or outdated Switch
//import android.widget.Switch

//import android.R
import android.app.Application
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.TextView
//import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.IntercomContent
import io.intercom.android.sdk.identity.Registration
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
//import java.util.TimeZone


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
        //val registration = Registration.create().withEmail(getString(R.string.intercom_user_email))
        //Intercom.client().registerIdentifiedUser(registration)

        //Intercom (Registration):
        val userRegistration = Registration.create().withUserId(getString(R.string.intercom_user_id))
        Intercom.client().loginIdentifiedUser(userRegistration)

        //Custom (Messenger Counter)
        val messageCounter = findViewById<TextView>(R.id.unreadCounter)
        Intercom.client().addUnreadConversationCountListener {
            messageCounter.text = "$it"
        }

        //Custom (Messenger Button)
        // get reference to button
        val buttonMessenger = findViewById<Button>(R.id.buttonMessenger)
        // set on-click listener
        buttonMessenger.setOnClickListener {
            // your code to perform when the user clicks on the button
            Intercom.client().present()
        }

        //Custom (Carousel Button)
        val buttonCarousel = findViewById<Button>(R.id.buttonCarousel)
        buttonCarousel.setOnClickListener {
            Intercom.client().presentContent(IntercomContent.Carousel(getString(R.string.intercom_carousel_id)))
        }

        //Custom (Survey Button)
        val buttonSurvey = findViewById<Button>(R.id.buttonSurvey)
        buttonSurvey.setOnClickListener {
            Intercom.client().presentContent(IntercomContent.Survey(getString(R.string.intercom_survey_id)))
        }

        //Custom (Event Button)
        val buttonEvent = findViewById<Button>(R.id.buttonEvent)
        buttonEvent.setOnClickListener {

            //Formatting Meta Data
            val currentDate = DateTimeFormatter
                .ofPattern("yyyy-MM-dd")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            val currentTime = DateTimeFormatter
                .ofPattern("HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            val triggerId = (1000..9999).random()

            //Creating event with Metadata
            val eventData : Map<String, *> = mapOf(
                "trigger_date" to currentDate,
                "trigger_time" to currentTime,
                "event_id" to triggerId
            )
            //Sending Event
            Intercom.client().logEvent("mobile_demo_event", eventData)
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