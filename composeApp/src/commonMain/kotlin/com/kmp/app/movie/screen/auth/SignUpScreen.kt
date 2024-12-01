package com.kmp.app.movie.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.app.movie.common.DarkGray
import com.kmp.app.movie.common.Gray
import com.kmp.app.movie.common.Teal
import com.kmp.app.movie.extension.isEmailValid
import com.kmp.app.movie.extension.isPasswordValid
import com.kmp.app.shared.viewmodel.auth.SignUpViewModel
import mymovie.composeapp.generated.resources.Res
import mymovie.composeapp.generated.resources.app_name
import mymovie.composeapp.generated.resources.create_your_account
import mymovie.composeapp.generated.resources.email
import mymovie.composeapp.generated.resources.email_icon
import mymovie.composeapp.generated.resources.have_an_account
import mymovie.composeapp.generated.resources.ic_hide_password
import mymovie.composeapp.generated.resources.ic_outline_movie
import mymovie.composeapp.generated.resources.ic_show_password
import mymovie.composeapp.generated.resources.lock_icon
import mymovie.composeapp.generated.resources.password
import mymovie.composeapp.generated.resources.sign_in
import mymovie.composeapp.generated.resources.sign_up
import mymovie.composeapp.generated.resources.urbanist_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel()
) {
    val email by viewModel.email
    val password by viewModel.password
    val shouldShowPassword by viewModel.shouldShowPassword
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.2f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(Res.drawable.ic_outline_movie),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Teal)
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = stringResource(Res.string.app_name),
                    color = Teal,
                    fontSize = 60.sp,
                    fontFamily = FontFamily(Font(Res.font.urbanist_bold)),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.create_your_account),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = DarkGray,
                fontFamily = FontFamily(Font(Res.font.urbanist_bold)),
                fontWeight = FontWeight.Bold
            )
        }
        item {
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = DarkGray, unfocusedTextColor = DarkGray
                ),
                value = email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                ),
                onValueChange = { viewModel.setEmail(it) },
                label = {
                    Text(text = stringResource(Res.string.email))
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(Res.drawable.email_icon),
                        contentDescription = "Email",
                        colorFilter = ColorFilter.tint(DarkGray)
                    )
                },
                supportingText = {
                    if (email.isNotEmpty() && !email.isEmailValid()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Invalid email",
                            color = Color.Red
                        )
                    }
                },
                trailingIcon = {
                    if (email.isNotEmpty() && !email.isEmailValid()) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            contentDescription = "Error",
                            tint = Color.Red
                        )
                    }
                })
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = DarkGray, unfocusedTextColor = DarkGray
                ),
                value = password,
                visualTransformation = if (shouldShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
                ),
                onValueChange = { viewModel.setPassword(it) },
                label = {
                    Text(text = stringResource(Res.string.password))
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(Res.drawable.lock_icon),
                        contentDescription = "Password",
                        colorFilter = ColorFilter.tint(DarkGray)
                    )
                },
                trailingIcon = {
                    Image(
                        modifier = Modifier.clickable { viewModel.setShouldShowPassword() },
                        painter = if (!shouldShowPassword) painterResource(Res.drawable.ic_hide_password) else painterResource(
                            Res.drawable.ic_show_password
                        ),
                        contentDescription = "Show password",
                        colorFilter = ColorFilter.tint(DarkGray)
                    )
                },
                supportingText = {
                    if (password.isNotEmpty() && !password.isPasswordValid()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Password must be greater than 6 characters and lower than 20 characters, at least has 1 number and 1 uppercase word!",
                            color = Color.Red
                        )
                    }
                })
        }
        item {
            Box(
                modifier = Modifier.fillMaxWidth().height(60.dp)
                    .border(width = 1.dp, shape = RoundedCornerShape(16.dp), color = DarkGray)
                    .clip(RoundedCornerShape(16.dp)).clickable {
                        if (email.isEmailValid() && password.isPasswordValid()) {
                            viewModel.registerWithEmailAndPassword()
                        }
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(Res.string.sign_up),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(Res.font.urbanist_bold)),
                    color = Gray
                )
            }
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(Res.string.have_an_account), color = DarkGray
                )
                Text(
                    modifier = Modifier.clickable {
                        viewModel.navigateBack()
                    },
                    text = stringResource(Res.string.sign_in),
                    fontWeight = FontWeight.Bold,
                    color = Gray
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}