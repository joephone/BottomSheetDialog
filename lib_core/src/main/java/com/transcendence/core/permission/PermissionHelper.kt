package com.transcendence.core.permission

import android.Manifest
import android.app.Activity
import com.hjq.permissions.XXPermissions
import com.hjq.permissions.OnPermissionCallback
import com.transcendence.core.utils.log.LogUtils

/**
 * @author joephone
 * @date 2023/6/10
 * @desc
 */
class PermissionHelper(private val mActivity: Activity) {

    interface PermissionCallback {
        fun onPermissionComplete(isGranted: Boolean?)
    }

    fun requestAllPermissions(permissions: Array<String>, permissionCallback: PermissionCallback) {
        XXPermissions.with(mActivity) // 申请单个权限
            // 申请多个权限
            .permission(permissions) // 设置权限请求拦截器（局部设置）
            //.interceptor(new PermissionInterceptor())
            // 设置不触发错误检测机制（局部设置）
            //.unchecked()
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: List<String>, allGranted: Boolean) {
                    LogUtils.d("onGranted")
                    permissionCallback.onPermissionComplete(allGranted)
                }

                override fun onDenied(permissions: List<String>, doNotAskAgain: Boolean) {
                    LogUtils.d("onDenied doNotAskAgain--$doNotAskAgain")
                    if (doNotAskAgain) {
//                                // 如果是被永久拒绝就跳转到应用权限系统设置页面
                        XXPermissions.startPermissionActivity(mActivity, permissions)
                    } else {
                        permissionCallback.onPermissionComplete(false)
                    }
                }
            })
    }

    /**
     * 申请播放视频权限
     * Manifest.permission.WRITE_EXTERNAL_STORAGE,
     * Manifest.permission.READ_EXTERNAL_STORAGE,
     *
     * @param permissionCallback 权限处理完毕的回调
     */
    fun requestStoragePermissions(permissionCallback: PermissionCallback) {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        requestAllPermissions(permissions, permissionCallback)
    }

    /**
     * 申请相机权限
     *
     * @param permissionCallback 权限处理完毕的回调
     */
    fun requestCameraPermissions(permissionCallback: PermissionCallback) {
        val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        requestAllPermissions(permissions, permissionCallback)
    }

    /**
     * 申请打电话权限
     *
     * @param permissionCallback 权限处理完毕的回调
     */
    fun requestDialCallPermissions(permissionCallback: PermissionCallback) {
        val permissions = arrayOf(
            Manifest.permission.CALL_PHONE
        )
        requestAllPermissions(permissions, permissionCallback)
    }

    /**
     * 申请打电话权限
     *
     * @param permissionCallback 权限处理完毕的回调
     */
    fun requestLocationPermissions(permissionCallback: PermissionCallback) {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        requestAllPermissions(permissions, permissionCallback)
    }
}