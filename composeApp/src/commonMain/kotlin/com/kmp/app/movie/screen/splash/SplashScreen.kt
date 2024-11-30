package com.kmp.app.movie.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.app.movie.common.Dark
import com.kmp.app.movie.common.Gold
import com.kmp.app.shared.viewmodel.splash.SplashViewModel
import mymovie.composeapp.generated.resources.Res
import mymovie.composeapp.generated.resources.app_name
import mymovie.composeapp.generated.resources.ic_outline_movie
import mymovie.composeapp.generated.resources.urbanist_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Dark),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(Res.drawable.ic_outline_movie),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Gold)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(Res.string.app_name),
                color = Gold,
                fontSize = 60.sp,
                fontFamily = FontFamily(Font(Res.font.urbanist_bold)),
                fontWeight = FontWeight.Bold
            )
        }
    }
}