package com.transcendence.core.utils.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.transcendence.core.utils.json.GsonUtils
import com.transcendence.core.utils.json.GsonUtils.ListOfSomething
import java.lang.Exception
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.ArrayList

/**
 * @Author Joephone on 2020/4/17 0:09
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc Gson转换工具类
 * @Edition 1.0
 * @EditionHistory
 */
object GsonUtils {
    var instance: GsonUtils? = null
        get() {
            if (field == null) {
                field = GsonUtils
            }
            return field
        }
        private set

    /**
     * @param jsonString   json字符串
     * @param cls  要转换的类
     * @param <T>  返回要转换的类
     * @return
    </T> */
    fun <T> json2Cls(jsonString: String?, cls: Class<T>?): T? {
        var t: T? = null
        try {
            val gson = Gson()
            t = gson.fromJson(jsonString, cls)
        } catch (e: Exception) {
            // TODO: handle exception
        }
        return t
    }

    fun cls2Json(`object`: Any?): String {
        var json = ""
        try {
            val gson = Gson()
            json = gson.toJson(`object`)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return json
    }

    /**
     * @param jsonString json字符串
     * @param cls 要转换的类
     * @param <T> 返回List
     * @return
    </T> */
    fun <T> json2List(jsonString: String?, cls: Class<T>): List<T> {
        var list: List<T> = ArrayList()
        try {
            val gson = Gson()
            list = gson.fromJson(jsonString, ListOfSomething(cls))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }



    class ListOfSomething<T>(wrapped: Class<T>) : ParameterizedType {
        private val wrapped: Class<*>
        override fun getActualTypeArguments(): Array<Type> {
            return arrayOf(wrapped)
        }

        override fun getRawType(): Type {
            return MutableList::class.java
        }

        override fun getOwnerType(): Type? {
            return null
        }

        init {
            this.wrapped = wrapped
        }
    }

}