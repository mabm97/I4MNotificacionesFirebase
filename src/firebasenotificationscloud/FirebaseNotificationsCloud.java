/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firebasenotificationscloud;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.SendResponse;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MarcoThinkpad
 */
public class FirebaseNotificationsCloud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FirebaseNotificationsCloud fnc = new FirebaseNotificationsCloud();
        try {
            fnc.senToken();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void senToken() throws FirebaseMessagingException, IOException {
        // <editor-fold defaultstate="collapsed" desc="Se obtiene las Claves Privadas del Proyecto">
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\MarcoThinkpad\\Documents\\NetBeansProjects\\FirebaseNotificationTestMaven\\src\\main"
                + "\\java\\com\\mycompany\\firebasenotificationtestmaven\\config\\notificacionjava-firebase-adminsdk-taj5y-c801350b26.json");
        // </editor-fold>        

        // <editor-fold defaultstate="collapsed" desc="Se Inicializa el servicio de Firebase">
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                //                .setDatabaseUrl("https://notificacionestest06042020.firebaseio.com/") //opcional para cuando se usan notificaciones.
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(options);
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Se obtienen los Tokens a Enviar">
        ArrayList<String> tokens = new ArrayList();
        tokens.add("ch9sNiExLRAJMu9LOUB2pN:APA91bEwYFA2Pv_8Er7d4F9GtjRZBlyov7xEeYqw91deLNlhtUVAjO9r9QyZ1iuYMTqAGD4TWhL4JK6BtQkxF3ASSXTLYciYoueOPEGjYFQNiqNUIHkeaNM30vs22RWhgy9tB6DbypnD"); // Firefox
//        tokens.add("clSrrvObP-D8K8ZGCEcCna:APA91bHqzCl1jB34xU_iLx4bTeDyBGByfBhiHnYtGkUD4CaZItVPJNX9itTJj4dZ5Wc2lb7cBQTi_awNURBBpNQU6sNsmdslFsyp_p_JaDobCtoi_3H0ISEjQL7f4r3zQBVYZpKChKaw"); // Chrome
        tokens.add("egeNLx2j3QHoCWI7kbQABR:APA91bHKDO6odq4oLpl-Ulq6YZyQZPswUyVVXRDFYWxdA3fKUkBjD6itEDzcngYg4-cJwydAc6YCKY2AME_mdmjCcTWtJb-ae5M687_w2jjsU9ZZt1i5zqP1MzpzdeRE40gMQCmJpgQd"); // Chrome Android
//        tokens.add("ccpx8NUcbPZPSSq3RGQ_Qn:APA91bG3F8xV_Btd62MTw9Px7AxSoSM7IBNV40laxGVERE4Q0Z9NZtiJdbnAv5cg5f92rIgM_gegM4uiwO5CIXjvhwXDhu5kTt6klRJqeTASBCc8IZjuQqmUE1oOgWPVYLXld6ECAVbQ"); // Chrome Android - Pedro
//        tokens.add("c4k3aT5yzaOnZbpPFJqFFs:APA91bH4JW_clgMytjwJq7MNIP1GiEcFbe31Ck6vUPwVBP9Nw5UCqhWvqkRONMOlUElms73q678AQA_I-ogWrUdAC5QQ4_zGigaU5GwUoA8nMyXgdGsVUOiHCb7CXUqgjXUcQ4xdBtjO"); // Chrome Android - Pedro Lap
//        tokens.add("eFhdHLUekv5gWcJaN5VuDa:APA91bFKW55JRZl8-xE9GZ_nN8A2_oV-wD5Iz52AXp3ILimGlcaFJVnZLxOjar2O8gMU4yRHwQiQLtzHgMZ9NQWVXd682s9e1nLIo9VwwElNdux6Dr9B2BeTk7TMVMMG-hhkU-zc8-gI"); // FIREFOX - Popoca
//        tokens.add("d5joeCa4Asig9ddDQ-pYXU:APA91bEGJ1_hZsmlZrrvnEVximC_LGsbTaaRjl5Lx0IvSlGmgTlk0J_W0De497LqOwgdJyHXCp-T4akVcofObuh6lzd6efCLygKF1svXt3uP23dVDn4HBEyX3vwb5wJX1wpjOS8O_rCJ"); // CHROME - Popoca
//        tokens.add("eA7cFoNgzhe5dMfdhJ7zUq:APA91bESn4vnZVtGd43FICsXuJMCFoYdJio801DGDOa-mDxltKunBZY7KMflzVcPRX-O2b6s_9CMyk_uQNYjBh5kQqfW7ewq9X9fkrqPkzMDrjSfFA03nh8YVrdWlAphvX2lsOmVRVic"); // Chrome - Roberto
//        tokens.add("dCrkTzO7V71YSyeduBHKfP:APA91bHG_IgEu4SU4AuPfpzj5l2gRMaO5ewoiaQ2Ubg-y-tE09LBYltj4l3ZsMnGqDUqfdOk3z_3jMyCOnE6iIjtRecVrX3kE6GxG4meqhBGG4qO2oKhUM4y_GNqRi3vsuXimde7y2dy"); // Aux Fer
        tokens.add("cYt7PhiwRaCpbX4kv0wQSq:APA91bHuBsuv4I6SUpXJCYJU6vthQjpTfRSTe8LlVXtSEJv7Hi0SXsR-3ldnnMJG--IDPAXRQF8zbNdbaEh1-cIus3xJhrLnL2IO4nOEPd3Fj3nKwAXX_hYb-I93bkqtGCKIeXraPNIw"); // Fer Chrome
        tokens.add("dCrkTzO7V71YSyeduBHKfP:APA91bFeOxmh6apOXOZAtWMfzktMtvs5DATAH4xYuql7sUIEnVDVyi6ao8JuZJ-g-ZoZfaSq48ca35q6Jhyhju4HtJqZilqSHoXu5Nllqd7rED4Xi0ZS6jTGwkreraM_Mne6BAus8llq"); // Fer Explorer Edge
        tokens.add("dBS_3NEYaY4:APA91bH3aGsKGdPHfN2P_Rip2-gCo0SdEKAZFMdmE1qT4mWi73P1k5LjBz0sK8yL_l26aWJxGUflOo21U1kahNUf1_wHE5_shW0dkAZ9ILOFVABOmavhzamq6VNvAW00lZClFrQ6pYX4"); // AndroidAPP - Marco
//        tokens.add("f5gIPb8qfsI:APA91bEcDvDtbYmmxekSuvwQeW-6aoG04FVodrS2Hu4YldjWG3tYXZ8n2zr9UxdFWTc3Ayu232pYsZPxtOEROrZt1nKZVinO7GJnslfExxjjnKNMvUgVN5Sb0nTNcBDbyrTaX4y-RttY"); // AndroidAPP - David
        tokens.add("c-fFclkx6xs:APA91bF7JciNWmQCyY8uUrplwFPw46JhriKKCaNJWLYC9gOYBE1Lrrlh0anWgnNh17vyCfnnY6y4cBXsaNyL-UcRLEsdTuGEr-IkIOtlUKwybK1nv5oExK-wQxgnUVSqPQ2vGnjLu1ri"); // AndroidAPP - Jefa
//        tokens.add("eBCO1A3vi7k:APA91bF_OyMdTfaRgsk-DX3uE6Rzx4VHIYZJX_ku9DLTmhe1aDv_WGwYf51XhyvVZxED0UXcSPcADRWgdrv3fapSQa3ZNusutKwD5rZrWzuSprLuQlrQDhZ7fCPtPB8EggfgIbh_Zno1"); // AndroidAPP - FER
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Elabrar la notificación">
        ArrayList<Message> listaNotificaciones = new ArrayList<>();
        for (String token : tokens) {
            // <editor-fold defaultstate="collapsed" desc="Se Elaboran las notificaciones">
//            Message message = Message.builder()
//                    .setWebpushConfig(WebpushConfig.builder()
//                            .setNotification(new WebpushNotification(
//                                    "i4m. Notificación con nuevo TOKEN",
//                                    "i4m. "+token.substring(0, 10) + " Cuerpor de la notificación .",
//                                    "https://lh3.googleusercontent.com/proxy/JBQKC_MjhOk9GE4XMkB26DjNQ4IylVWXQlse0sufJSYjvxraiFeSJhZqD3U9QAEddB60KOFw93GhnmEecpE7QkDhRmYgMVRIj580ljK-sNfoUuZ4BrNP3-pG0f1QvNLcZA")
//                            )
//                            .build())
//                    .setToken(token)
//                    .build();
            String titulo = "i4m. Notificación con nuevo TOKEN";
            String cuerpo = "i4m. " + token.substring(0, 10) + " Cuerpo de la notificación .";
            String icon = "https://lh3.googleusercontent.com/proxy/JBQKC_MjhOk9GE4XMkB26DjNQ4IylVWXQlse0sufJSYjvxraiFeSJhZqD3U9QAEddB60KOFw93GhnmEecpE7QkDhRmYgMVRIj580ljK-sNfoUuZ4BrNP3-pG0f1QvNLcZA";
            Map<String, String> mapAndroid = new HashMap<String, String>();
            mapAndroid.put("title", titulo);
            mapAndroid.put("body", cuerpo);
            mapAndroid.put("icon", icon);
            Message message = Message.builder()
                    .setWebpushConfig(WebpushConfig.builder()
                            .setNotification(new WebpushNotification(
                                    titulo,
                                    cuerpo,
                                    icon)
                            )
                            .build())
                    .setAndroidConfig(AndroidConfig.builder()
                            .setTtl(3600 * 1000) // 1 hour in milliseconds
                            .setPriority(AndroidConfig.Priority.NORMAL)
//                            .setNotification(AndroidNotification.builder()
//                                    .setTitle("i4m. Notificación con nuevo TOKEN")
//                                    .setBody("i4m. " + token.substring(0, 10) + " Cuerpo de la notificación .")
//                                    //                                    .setIcon("stock_ticker_update")
//                                    .setColor("#f45342")
//                                    .build())
                            .putAllData(mapAndroid)
                            .build())
                    //                    .setTopic("industry-tech")
                    .setToken(token)
                    .build();

            listaNotificaciones.add(message);
            // </editor-fold>
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Envio de las notificaciones y trato de errores">
        BatchResponse response = FirebaseMessaging.getInstance().sendAll(listaNotificaciones);
        if (response.getFailureCount() > 0) {
            List<SendResponse> responses = response.getResponses();
            List<String> failedTokens = new ArrayList<>();
            for (int i = 0; i < responses.size(); i++) {
                if (!responses.get(i).isSuccessful()) {
                    // The order of responses corresponds to the order of the registration tokens.
                    failedTokens.add(tokens.get(i));
                    System.out.println(responses.get(i).getException());
                    System.out.println(responses.get(i).getMessageId());

                }
            }

            System.out.println("List of tokens that caused failures: " + failedTokens);
        }
        // </editor-fold>

    }

    public Message webpushMessage() {
        // [START webpush_message]
        Message message = Message.builder()
                .setWebpushConfig(WebpushConfig.builder()
                        .setNotification(new WebpushNotification(
                                "$GOOG up 1.43% on the day",
                                "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.",
                                "https://my-server/icon.png"))
                        //                        .setFcmOptions(WebpushFcmOptions.withLink("https://my-server/page-to-open-on-click"))
                        .build()).setToken("clSrrvObP-D8K8ZGCEcCna:APA91bHqzCl1jB34xU_iLx4bTeDyBGByfBhiHnYtGkUD4CaZItVPJNX9itTJj4dZ5Wc2lb7cBQTi_awNURBBpNQU6sNsmdslFsyp_p_JaDobCtoi_3H0ISEjQL7f4r3zQBVYZpKChKaw")
                //                .setTopic("industry-tech")
                .build();
        // [END webpush_message]
        return message;
    }

    public Message allPlatformsMessage() {
        // [START multi_platforms_message]
        Message message = Message.builder()
                .setNotification(new Notification(
                        "$GOOG up 1.43% on the day",
                        "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000)
                        .setNotification(AndroidNotification.builder()
                                .setIcon("stock_ticker_update")
                                .setColor("#f45342")
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("industry-tech")
                .build();
        // [END multi_platforms_message]
        return message;
    }

}
