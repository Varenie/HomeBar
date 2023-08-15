package com.varenie.homebar.view.navigation

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String): Destination(route) {
        operator fun invoke(): String = route
    }

    object BarScreen: NoArgumentsDestination("bar")
    object MenuScreen: NoArgumentsDestination("menu")
    object CartScreen: NoArgumentsDestination("cart")
}

internal fun String.appendParams(vararg params: Pair<String, Any>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}
