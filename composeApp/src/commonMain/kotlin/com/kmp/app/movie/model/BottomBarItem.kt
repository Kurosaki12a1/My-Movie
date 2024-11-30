package com.kmp.app.movie.model

import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationGraph
import mymovie.composeapp.generated.resources.Res
import mymovie.composeapp.generated.resources.bottom_nav_explore
import mymovie.composeapp.generated.resources.bottom_nav_home
import mymovie.composeapp.generated.resources.bottom_nav_my_list
import mymovie.composeapp.generated.resources.bottom_nav_settings
import mymovie.composeapp.generated.resources.bottom_nav_upcoming
import mymovie.composeapp.generated.resources.ic_bookmark
import mymovie.composeapp.generated.resources.ic_explore
import mymovie.composeapp.generated.resources.ic_home
import mymovie.composeapp.generated.resources.ic_settings
import mymovie.composeapp.generated.resources.ic_up_coming
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class BottomBarItem(
    val destination: Destination, val drawable: DrawableResource, val label: StringResource
)

fun getListBottomBar(): List<BottomBarItem> {
    return listOf(
        BottomBarItem(
            destination = Destination.Home,
            drawable = Res.drawable.ic_home,
            label = Res.string.bottom_nav_home
        ), BottomBarItem(
            destination = Destination.Explore,
            drawable = Res.drawable.ic_explore,
            label = Res.string.bottom_nav_explore
        ), BottomBarItem(
            destination = Destination.UpComing,
            drawable = Res.drawable.ic_up_coming,
            label = Res.string.bottom_nav_upcoming
        ), BottomBarItem(
            destination = Destination.Bookmark,
            drawable = Res.drawable.ic_bookmark,
            label = Res.string.bottom_nav_my_list
        ), BottomBarItem(
            destination = Destination.Settings,
            drawable = Res.drawable.ic_settings,
            label = Res.string.bottom_nav_settings
        )
    )
}

fun isBottomBarVisible(graphRoute: String?): Boolean =
    graphRoute != null && (NavigationGraph.HomeGraph.toString() == graphRoute || NavigationGraph.ExploreGraph.toString() == graphRoute || NavigationGraph.UpComingGraph.toString() == graphRoute || NavigationGraph.BookmarkGraph.toString() == graphRoute || NavigationGraph.SettingsGraph.toString() == graphRoute)