/*
 * Copyright (C) 2020 The exTHmUI Open Source Project
 * Copyright (C) 2021 AOSP-Krypton Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.exthmui.game.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

import org.exthmui.game.controller.FloatingViewController
import org.exthmui.game.controller.NotificationOverlayController
import org.exthmui.game.qs.*

class QuickSettingsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private lateinit var notificationOverlayController: NotificationOverlayController
    private lateinit var floatingViewController: FloatingViewController

    fun setNotificationOverlayController(controller: NotificationOverlayController) {
        notificationOverlayController = controller
    }

    fun setFloatingViewController(controller: FloatingViewController) {
        floatingViewController = controller
    }

    fun addTiles() {
        addView(ScreenCaptureTile(context).also {
            it.setViewController(floatingViewController)
        })
        addView(NotificationOverlayTile(context).also {
            it.setController(notificationOverlayController)
        })
        addView(RingerModeTile(context))
        addView(LockGestureTile(context))
        addView(AutoBrightnessTile(context))
    }
}