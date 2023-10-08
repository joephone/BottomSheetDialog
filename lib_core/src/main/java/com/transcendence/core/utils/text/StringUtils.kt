package com.transcendence.core.utils.text

import android.content.Context
import android.text.TextUtils
import java.util.ArrayList
import java.util.regex.Pattern

/**
 * @author joephone
 * @date 2023/9/19
 * @desc
 */
class StringUtils private constructor() {

    companion object {
        fun removeAllBank(str: String?): String? {
            var s = ""
            if (str != null) {
                val p = Pattern.compile("\\s*|\t|\r|\n")
                val m = p.matcher(str)
                s = m.replaceAll("")
            }
            return s
        }

        fun removeAllBank(str: String?, count: Int): String? {
            var s = ""
            if (str != null) {
                val p = Pattern.compile("\\s{$count,}|\t|\r|\n")
                val m = p.matcher(str)
                s = m.replaceAll(" ")
            }
            return s
        }

        fun formatChapterName(vararg names: String?): String? {
            val format = StringBuilder()
            for (name in names) {
                if (!TextUtils.isEmpty(name)) {
                    if (format.length > 0) {
                        format.append("·")
                    }
                    format.append(name)
                }
            }
            return format.toString()
        }

        fun getStringList(context: Context, name: Int): List<String>? {
            val list: MutableList<String> = ArrayList()
            val array = context.resources.getStringArray(name)
            for (i in array.indices) {
                list.add(array[i])
            }
            return list
        }
    }
}