package com.example.grade12

import java.util.*
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.Toast 
import io.flutter.plugin.platform.PlatformView



internal class NativeView(context: Context, id: Int, creationParams: Map<String?, Any?>?, callback: (time: String) -> Unit) : PlatformView {
    private val button: Button

    override fun getView(): View {
        return button
    }

    override fun dispose() {}

    init {
        var toast = Toast.makeText(context, "Pass closing time", Toast.LENGTH_LONG)
        toast.addCallback(object: Toast.Callback() {
            override fun onToastHidden() {
                val time = Calendar.getInstance().time.toString()
                callback(time)
                super.onToastHidden()
            }
        })
        

        button = Button(context)
        button.text = "${creationParams!!["value"]}"
        button.setOnClickListener {
            toast.show()
        }
    }
} 