package com.example.grade12

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel

class MainActivity: FlutterActivity() {
    var eventSink: EventChannel.EventSink? = null

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        EventChannel(flutterEngine.dartExecutor.binaryMessenger, "toastResult")
            .setStreamHandler(object : EventChannel.StreamHandler {
                override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
                eventSink = events
                }
                override fun onCancel(arguments: Any?) {
                eventSink = null
                }
        })

        super.configureFlutterEngine(flutterEngine)
            flutterEngine
                    .platformViewsController
                    .registry
                    .registerViewFactory("<platform-view-type>", 
                                        NativeViewFactory(::passResult))
     }



    fun passResult(time: String) {
        eventSink?.success(time)
    }
}
