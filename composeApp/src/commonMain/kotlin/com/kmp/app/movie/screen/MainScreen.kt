package com.kmp.app.movie.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kmp.app.movie.common.Dark
import com.kmp.app.movie.common.Gold
import com.kmp.app.movie.common.LightGray
import com.kmp.app.movie.common.VeryLightGray
import com.kmp.app.movie.model.getListBottomBar
import com.kmp.app.movie.model.isBottomBarVisible
import com.kmp.app.movie.navigation.MainNavGraph
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationIntent
import com.kmp.app.navigation.Navigator
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    navigator: Navigator = koinInject()
) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()

    NavigationEffects(
        navigationFlow = navigator.navigationFlow,
        navHostController = navController
    )

    Scaffold(
        containerColor = VeryLightGray,
        topBar = {

        },
        bottomBar = {
            if (isBottomBarVisible(currentDestination?.destination?.parent?.route))
            BottomAppBar(modifier = Modifier.fillMaxWidth(), containerColor = Dark) {
                BottomNavigationBar(backStackEntry = currentDestination) {
                    scope.launch {
                        navigator.navigateTo(it)
                    }
                }
            }
        }
    ) {
        MainNavGraph(navController = navController, paddingValues = it)
    }
}

@Composable
private fun NavigationEffects(
    navigationFlow: SharedFlow<NavigationIntent>,
    navHostController: NavHostController
) {
    LaunchedEffect(navHostController, navigationFlow) {
        navigationFlow.collect { intent ->
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    intent.route?.let {
                        navHostController.popBackStack(
                            route = it,
                            inclusive = intent.inclusive
                        )
                    } ?: run {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.BottomNavigationBar(
    backStackEntry: NavBackStackEntry?,
    onClick: (Destination) -> Unit
) {
    val currentRoute = backStackEntry?.destination?.route
    getListBottomBar().forEach {
        val isSelected = currentRoute == it.destination.toString()
        Column(
            modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                .clickable { onClick(it.destination) },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(it.drawable),
                colorFilter = ColorFilter.tint(if (isSelected) Gold else LightGray),
                contentDescription = null
            )
            Text(
                text = stringResource(it.label),
                color = if (isSelected) Gold else LightGray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

