# Intercom Android Demo

The Demo currently has the following capabilities:
- Switch to hide and display the **Launcher**
- Button to display the **Messenger**
- Button to display a **Carousel**
- Connection through Google Firebase for **Push Notifications**

## Installation Instructions:

1. Download and install [Android Studio](https://developer.android.com/studio?gclid=CjwKCAiA78aNBhAlEiwA7B76p97HhkXEnGh8mDJkFR2lDxHQfSnS_Oj_kZznH3-jW31mv7gYRRnK1hoCseMQAvD_BwE&gclsrc=aw.ds).
2. Start Android Studio and select "Get from VCS" under Projects. Keep Version control set to Git and stay on the Repository URL, you do not need to set up GitHub in Android Studio.
3. Copy and Paste the GitHub Project URL `https://github.com/PhilippMS/Intercom-Android-Demo/` into the URL field.
4. *(Optional) You may want to change Directory. The default might be a different location to the default directory of your locally creatated projects.*
5. Select Clone.

## Configuration Instructions:

There are two parts to be configured. Firstly you need to set up Firebase, secondly you need to configure a file locally in Android Studio to link the App to your personal Intercom Workspace.

Lets start with...

### Firebase:

Here is the [Official Setup Guide](https://developers.intercom.com/installing-intercom/docs/android-fcm-push-notifications) from Intercom for FCM based Push Notifications.
(*You can use it to understand the setup better.*)

Because I have installed Firebase already, all you have to do is Sign Up / Login to Firebase, create a project, export and replace the json file within the Android App and you are ready to go.

#### Follow These Steps to set up Firebase:

1. Go to [Firebase](https://firebase.google.com/) and Login with your Intercom Google Account.
2. Select "[Go to Console](https://console.firebase.google.com/)" at the top of the page.
3. From here you should be able to set up a new project. It does not matter what you call the project, mine is called `Intercom Demo Philipp`.
4. After you set up the new project you will automatically be redirected to the project page. You are greeted with a message telling you to add firebase to your App. Select Android.
5. You are now on the configuration page:
    1. You have to use the following Android package name `com.example.philippintercomdemo`, if you do not want to refactor the application.
    2. The App Nickname is only used within Firebase, you can use whatever name will help you know which application you are using this for. I was not very creative and called mine `Intercom Demo Philipp` for example.
    3. Ignore the Debugging SHA-1 certificate and click next.
6. You will now be able to download **your** `google-services.json` file which you will need to replace mine.
7. Follow the instructions on screen and open Android Studio, switch from App to Project view. 
8. Open finder/file explorer and drag & drop the json file on top of the one you aready see in Android Studio. 
9. Select to replace the existing one.

Congratulations, Firebase is now set up for you.

Next we need to change some settings in the App itself to link it to your own Intercom Workspace

### Link App to your Workspace

1. You need to open (double click the file name) the **strings.xml** file: `app/src/main/res/values/strings.xml` 
2. Under the Comment (`<!-- Intercom Workspace Setup !Change values with your own! -->`) you can find 4 different strings.
3. Go to your [Intercom Workspace](https://app.intercom.com/) and find the API Key and App ID under `Settings/Installation/Android`.
4. Replace the API Key and App ID respectively.
5. If you have already created a Mobile Carousel, fantastic, Otherwise go to Outbound and create a Mobile Carousel.
    - After creating your Carousel you can find the Carousel ID at the "Trigger your carousel from code" section.
6. Replace the Carousel ID with yours.
7. Lastly my app uses a test user with the Email address of `john.doe@example.com`. You can either keep that and use it for your demo, or replace the email address with whichever one you want to use for your own demo.

## Testing and demo set up

Now all that is left is testing and setting everything up for a demo.
- At the very top of the screen in Android Studio you should find a dropdown menu saying "No Devices". It is to the left of a green play button and to the right of a dropdown with a little Android Icon saying app.
- Select the No Devices dropdown and click on AVD Manager to Create a Virtual Device. 
- Now you can select any of the preconfigured phones. I would recommend something a bit newer, like Pixel 4 or 5. 
- Download one of the recommended releases, again I would recommend one of the newer ones, and hit next and finish the setup.
- Close the Android Virtual Device Manager.
- The dropdown should now display the device that you have created.
- Press the green play icon to run the app in the emulator. *(This will take a while the first time you start the device, so give it time)*
 
- Some setting changes I recommend for the Emulator:
    - Press the three buttons next to the phone to open the Extended Controls. 
    - go to Settings in the Extended Controls window.
    - Select "Show window frame around device" (*This can help if you have a multi monitor setup and you have problems moving the emulator between screens*)
    - Another helpful setting for demos is "Emulator always on top" which does what it says on the tin.


