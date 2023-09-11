package com.toast.customtoast

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

object CustomToast {
    fun showToast(context: Context, type: ToastType, message: String, length: Int) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customToastLayout = inflater.inflate(R.layout.custom_toast_layout, null)

        val toastImageView = customToastLayout.findViewById<ImageView>(R.id.toast_image)
        val toastMessageView = customToastLayout.findViewById<TextView>(R.id.toast_message)

        // Set the image and message based on the provided type and message
        toastImageView.setImageResource(type.iconResId)
        toastMessageView.text = message

        val toast = Toast(context)
        toast.view = customToastLayout
        toast.duration = length
        toast.show()
    }
}

enum class ToastType(val iconResId: Int) {
    SUCCESS(R.drawable.ic_success), ERROR(R.drawable.ic_error), INFO(R.drawable.ic_info), WARNING(R.drawable.ic_warning)
}