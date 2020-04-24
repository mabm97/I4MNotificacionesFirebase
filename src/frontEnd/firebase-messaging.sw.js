importScripts('https://www.gstatic.com/firebasejs/7.2.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/7.2.1/firebase-messaging.js');

var config = {
  apiKey: "AIzaSyDE_VMW737KrSPxssSdywLfondzpsGNZ6I",
  authDomain: "notificacionjava.firebaseapp.com",
  databaseURL: "https://notificacionjava.firebaseio.com",
  projectId: "notificacionjava",
  storageBucket: "notificacionjava.appspot.com",
  messagingSenderId: "204782437491",
  appId: "1:204782437491:web:c0657657104c040df2d606"
};
firebase.initializeApp(config);

// Retrieve Firebase Messaging object.
const messaging = firebase.messaging();

messaging.setBackgroundMessageHandler(function (payload) {
  console.log('===========  BACKGROUND  ===========');
  console.log(payload);
  console.log('======================');
  var title = payload.data.title;
  var options = {
    body: payload.data.body,
    icon: payload.data.icon,
    image: payload.data.image,
    data: {
      time: new Date(Date.now()).toString(),
      click_action: payload.notification.click_action
    }
  };
  return self.registration.showNotification(title, options);
});

/*
self.addEventListener('notificationclick', function (event) {
  var action_click = event.notification.data.click_action;
  event.notification.close();
  event.waitUntil(
    clients.openWindow(action_click)
  );
});
*/



