package com.transcendence.core.utils

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.transcendence.core.base.app.CoreApp

/**
 * @author joephone
 * @date 2023/9/24
 * @desc
 */
object AppInfoUtils {

    fun getAppName(): String? {
        var appName = ""
        try {
            val packageInfo: PackageInfo =
                CoreApp.appContext!!.getPackageManager()
                    .getPackageInfo(CoreApp.appContext?.getPackageName(), 0)
            appName = CoreApp.appContext!!.getString(packageInfo.applicationInfo.labelRes)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return appName
    }

    /**
     * 获取本地软件版本号code
     */
    fun getVersionCode(): Int {
        var localVersion = 0
        try {
            val packageInfo: PackageInfo = CoreApp.appContext!!.getPackageManager()
                .getPackageInfo(CoreApp.appContext!!.getPackageName(), 0)
            localVersion = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return localVersion
    }

    /**
     * 获取本地软件版本号name
     */
    fun getVersionName(): String? {
        var versionName = ""
        try {
            val packageInfo: PackageInfo =
                CoreApp.appContext!!.getPackageManager()
                    .getPackageInfo(CoreApp.appContext!!.getPackageName(), 0)
            versionName = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionName
    }


}