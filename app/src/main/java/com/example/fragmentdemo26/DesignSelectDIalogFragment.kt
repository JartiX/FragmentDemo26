package com.example.fragmentdemo26

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DesignSelectDialogFragment : DialogFragment() {

    interface OnDesignSelectedListener {
        fun onDesignSelected(designIndex: Int)
    }

    private var listener: OnDesignSelectedListener? = null

    fun setOnDesignSelectedListener(listener: OnDesignSelectedListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val designs = arrayOf(
            "🌤  Светлая тема",
            "🌙  Тёмная тема",
            "🎨  Цветная тема"
        )

        return AlertDialog.Builder(requireContext())
            .setTitle("Выберите стиль оформления")
            .setItems(designs) { dialog, which ->
                listener?.onDesignSelected(which)
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.cancel()
            }
            .create()
    }
}