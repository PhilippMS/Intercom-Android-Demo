# Intercom Android Demo

The Demo currently has the following capabilities:
- Switch to hide and display the **Launcher**
- Button to display the **Messenger**
- **Unread Conversation Counter** (Next the the "Open Messenger" Button)
- Button to display a **Carousel**
- Button to display a **Survey**
- Button to trigger **Event** which can be used as trigger for Push Notifications
- Connection through Google Firebase for **Push Notifications**

## Installation Instructions:

1. Download and install [Android Studio](https://developer.android.com/studio?gclid=CjwKCAiA78aNBhAlEiwA7B76p97HhkXEnGh8mDJkFR2lDxHQfSnS_Oj_kZznH3-jW31mv7gYRRnK1hoCseMQAvD_BwE&gclsrc=aw.ds).
2. Start Android Studio and select "Get from VCS" under Projects. Keep Version control set to Git and stay on the Repository URL, you do not need to set up GitHub in Android Studio.
3. Copy and Paste the GitHub Project URL `https://github.com/PhilippMS/Intercom-Android-Demo/` into the URL field.
4. *(Optional) You may want to change Directory. The default might be a different location to the default directory of your locally created projects.*
5. Select Clone.

## Configuration Instructions:

There are two parts to be configured. Firstly you need to set up Firebase, secondly you need to configure a file locally in Android Studio to link the App to your personal Intercom Workspace.

Lets start with...

### Firebase:

https://developers.intercom.com/installing-intercom/docs/push-notifications-android

### Link App to your Intercom Workspace

1. You need to open (double click the file name) the **strings.xml** file: `app/src/main/res/values/strings.xml`
2. Under the Comment `<!-- Intercom Workspace Setup !Change values with your own! -->` you can find different strings.
3. Go to your [Intercom Workspace](https://app.intercom.com/) and find the API Key and App ID under `Settings/Installation/Android`.
4. Replace the API Key and App ID respectively.
5. If you have already created a Mobile Carousel, fantastic, Otherwise go to Outbound and create a Mobile Carousel.
    - After creating your Carousel you can find the Carousel ID at the "Trigger your carousel from code" section.
6. Replace the Carousel ID with yours.
7. Repeat Steps 5 & 6 for surveys
8. *(Optional) Lastly my app uses a test user with the Email address of `john.doe@example.com`. You can either keep that and use it for your demo, or replace the email address with whichever one you want to use for your own demo. You can see that I have both Email & User ID set up here, the MainActivity.kt file has a set up to either use Email or User ID. You can set in here what you want to use default now is User ID (1234567)*

## Set up Emulator

Now all that is left is testing and setting everything up for a demo.
1. At the very top of the screen in Android Studio you should find a dropdown menu saying "No Devices". It is to the left of a green play button and to the right of a dropdown with a little Android Icon saying app.
2. Select the "No Devices" dropdown and click on AVD Manager to Create a Virtual Device.
3. Now you can select any of the preconfigured phones. I would recommend something a bit newer.
4. Download one of the recommended releases, again I would recommend one of the newer ones (Like API 33, and hit next and finish the setup.
5. Close the Android Virtual Device Manager.
6. The dropdown should now display the device that you have created.
7. Press the green play icon to run the app in the emulator. *(This will take a while the first time you start the device, so give it time)*
8. After the Emulator is running and the app is installed you will have to manually allow Notifications for it. Find the app in the App Drawer and Longpress on it, select "App Info" and activate Notifications. Otherwise Push will not work!

### Recommended emulator settings:
1. Press the three buttons next to the phone to open the Extended Controls.
2. go to Settings in the Extended Controls window.
- Select "Show window frame around device" *(This can help if you have a multi monitor setup and you have problems moving the emulator between screens)*
- Another helpful setting for demos is "Emulator always on top" which does what it says on the tin.
