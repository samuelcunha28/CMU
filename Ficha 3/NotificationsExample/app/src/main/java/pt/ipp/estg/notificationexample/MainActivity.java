package pt.ipp.estg.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static String CHANNEL_ID = "CHANNEL_1";
    public NotificationManagerCompat notificationManager;
    public Button notifyButton;
    public Button cancelButton;
    public Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.createNotificationChannel();
        notificationManager = NotificationManagerCompat.from(this);

        notifyButton = findViewById(R.id.button1);
        cancelButton = findViewById(R.id.button2);
        updateButton = findViewById(R.id.button3);

        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNotification();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotification();
            }
        });
    }

    // metodo para criar a notificação
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // thew NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel";
            String description = "description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behavior after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    // metodo para enviar a notificação
    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("Foi notificado")
                .setContentText("Este é o texto da notificação")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Este é o texto da notificação"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        notificationManager.notify(1, builder.build());
    }

    // metodo para cancelar a notificação
    private void cancelNotification() {
        notificationManager.cancel(1);
    }

    // metodo para alterar a notificação
    private void updateNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("Notificação alterada")
                .setContentText("Alterada com sucesso")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("A notificação foi alterada com sucesso!"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        notificationManager.notify(1, builder.build());
    }
}