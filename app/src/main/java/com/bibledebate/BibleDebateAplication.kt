package com.bibledebate

import android.app.Application
import android.content.Context
import com.bibledebate.data.repository.BibleRepository
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.conf.ConfigurableKodein
import com.github.salomonbrys.kodein.singleton


class BibleDebateAplication : Application(), KodeinAware {
    override val kodein = ConfigurableKodein(mutable = true)
    var overrideModule: Kodein.Module? = null

    override fun onCreate() {
        super.onCreate()
        resetInjection()
    }

    fun addModule(activityModules: Kodein.Module) {
        kodein.addImport(activityModules, true)
        if (overrideModule != null) {
            kodein.addImport(overrideModule!!, true)
        }
    }

    fun resetInjection() {
        kodein.clear()
        kodein.addImport(appDependencies(), true)
    }

    private fun appDependencies(): Kodein.Module {
        return Kodein.Module(allowSilentOverride = true) {
            bind<BibleRepository>() with singleton {
                BibleRepository()
            }
        }
    }
}

fun Context.asApp() = this.applicationContext as BibleDebateAplication