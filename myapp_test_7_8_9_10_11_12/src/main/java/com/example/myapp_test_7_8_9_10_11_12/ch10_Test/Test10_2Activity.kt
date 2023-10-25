package com.example.myapp_test_7_8_9_10_11_12.ch10_Test

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.myapp_test_7_8_9_10_11_12.databinding.ActivityTest102Binding

class Test10_2Activity : AppCompatActivity() {
    //추가
    lateinit var activityTest102Binding: ActivityTest102Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //추가
        activityTest102Binding = ActivityTest102Binding.inflate(layoutInflater)
        // 변경
        setContentView(activityTest102Binding.root)

        // 버튼의 요소를 선택해서, 알림을 보내는 로직을 추가할 예정.
        activityTest102Binding.notiBtn.setOnClickListener {
            // 알림 추가 설정.
            // getSystemService(NOTIFICATION_SERVICE) 결과 형이 object 이어서,
            // as NotificationManager -> 형 변환.
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            // sdk 버전에 따라서, 분기, 기능의 패키지명 또는 구현 형식을 달라져서.
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //채널 설정
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel (
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                // 채널의 정보 및 부가 옵션 설정.
                channel.description = "My Channel One 설명"
                // 알림의 갯수를 아이콘 표시
                channel.setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                channel.setSound(uri,audioAttributes)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                // 진동의 간격마다, 세기 주기설정.
                channel.vibrationPattern = longArrayOf(100,200,100,200)

                // Notification Manager에 채널 등록 하기.
                manager.createNotificationChannel(channel)

                builder = NotificationCompat.Builder(this@Test10_2Activity, channelId)
            } else {
                // 26 버전 이하 버전시 사용하는 형식.
                builder = NotificationCompat.Builder(this@Test10_2Activity)
            }

            //아이콘, 테마, 툴바, 액션바 overlay 단어가 보이면 투명지, 뒤에 부분이 보인다.
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("알림 제목")
            builder.setContentText("알림의 메세지 내용")

            // 알림 메세지 창 클릭시, 페이지 이동. 기존에 사용했던 , 인텐트 방식과 비슷.
            val intent = Intent(this@Test10_2Activity,Test10_1Activity::class.java )
            val pendingIntent = PendingIntent.getActivity(this@Test10_2Activity,10,intent,
                PendingIntent.FLAG_IMMUTABLE)
            builder.setContentIntent(pendingIntent)

            //알림 발생 시키기
            manager.notify(11,builder.build())
        }


    }
}