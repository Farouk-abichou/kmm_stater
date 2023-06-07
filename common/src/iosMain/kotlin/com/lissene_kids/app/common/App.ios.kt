package com.lissene_kids.app.common

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}