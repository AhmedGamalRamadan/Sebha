package com.ag.projects.sebha.presentation.ui.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.provideContent
import com.ag.projects.sebha.domain.respository.AzkarRepository
import com.ag.projects.sebha.presentation.ui.components.widget.AzkarWidgetItem
import org.koin.core.context.GlobalContext

class AzkarWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        val repository: AzkarRepository = GlobalContext.get().get()
        val azkarList = repository.getAzkar()

        provideContent {

            LazyColumn {
                items(azkarList) { item ->
                    AzkarWidgetItem(
                        azkar = item
                    )
                }
            }
        }
    }
}

class AzkarWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget
        get() = AzkarWidget()
}