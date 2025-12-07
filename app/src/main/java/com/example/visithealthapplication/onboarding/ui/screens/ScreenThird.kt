/**
 * ---------------------------------------------------------------
 * File: ScreenThird.kt
 * Author: Kartik Waghmare
 * Created: 11 Feb 2025
 *
 * Purpose:
 *  Third and final screen of the onboarding flow.
 *  Displays animated radial glow, decorative stars, shared gift-box
 *  transition (handled at host level), motivational text,
 *  and a glossy “Let’s Go” image button.
 *
 * UI Includes:
 *  - Back button
 *  - Title image
 *  - Animated background (PNG + Lottie)
 *  - Decorative stars
 *  - Shared animated gift (not drawn here)
 *  - Motivational subtitle text
 *  - Dots indicator (page = 2)
 *  - Glossy "Let's Go" button image
 *
 * ---------------------------------------------------------------
 */

package com.example.visithealthapplication.onboarding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.visithealthapplication.R
import com.example.visithealthapplication.onboarding.ui.components.DotsIndicator

@Composable
fun ScreenThird(
    onNextClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFF6A84),  // pink top
                        Color(0xFFF84348)   // red bottom
                    )
                )
            )
    ) {

        // ---------------------------------------------------------------
        // BACK BUTTON
        // ---------------------------------------------------------------
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 24.dp)
                .size(60.dp)   // Larger touch area
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = stringResource(R.string.back),
                modifier = Modifier.size(28.dp)
            )
        }

        // ---------------------------------------------------------------
        // TITLE IMAGE
        // ---------------------------------------------------------------
        Image(
            painter = painterResource(id = R.drawable.text),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp)
                .width(230.dp)
        )

        // ---------------------------------------------------------------
        // ANIMATED BACKGROUND (PNG + Lottie motion)
        // ---------------------------------------------------------------
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.challenges_star)
        )
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            speed = 1.2f
        )

        Image(
            painter = painterResource(id = R.drawable.challenges_star_bg),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(450.dp)
                .graphicsLayer {
                    rotationZ = progress * 25f
                    scaleX = 0.9f + progress * 0.1f
                    scaleY = 0.9f + progress * 0.1f
                    alpha = 0.55f + progress * 0.20f
                }
        )

        // ---------------------------------------------------------------
        // STAR DECORATIONS
        // ---------------------------------------------------------------
        Image(
            painter = painterResource(id = R.drawable.stars),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(y = (-130).dp)
                .size(70.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.stars),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(y = (140).dp)
                .size(70.dp)
        )

        // ---------------------------------------------------------------
        // TEXT (Montserrat fonts)
        // ---------------------------------------------------------------
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val montSemiFont = FontFamily(
                Font(R.font.montserrat_semibold, FontWeight.SemiBold)
            )

            Text(
                stringResource(R.string.score_big),
                style = TextStyle(
                    fontFamily = montSemiFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(Modifier.height(6.dp))

            val montMedium = FontFamily(
                Font(R.font.montserrat_medium, FontWeight.Medium)
            )

            Text(
                text = stringResource(R.string.victory_unlocks_spectacular_vouchers) +
                        stringResource(R.string.cashbacks_and_beyond),
                style = TextStyle(
                    fontFamily = montMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    color = Color.White.copy(0.85f),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // ---------------------------------------------------------------
        // DOTS (page = 2)
        // ---------------------------------------------------------------
        DotsIndicator(
            totalDots = 3,
            selectedIndex = 2,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 110.dp)
        )

        // ---------------------------------------------------------------
        // "LET'S GO" BUTTON (image-based)
        // ---------------------------------------------------------------
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
                .fillMaxWidth()
                .height(55.dp)
                .clickable { onNextClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_lets_go),
                contentDescription = "Next Button",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenThirdPreview() {
    ScreenThird()
}
