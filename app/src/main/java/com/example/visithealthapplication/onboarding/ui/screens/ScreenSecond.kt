/**
 * ---------------------------------------------------------------
 * File: ScreenSecond.kt
 * Author: Kartik Waghmare
 * Created: 11 Feb 2025
 *
 * Purpose:
 *  This is the second screen in the onboarding flow.
 *  It displays an animated radial background using PNG + Lottie,
 *  star decorations, shared trophy transition (handled by host),
 *  title, motivational text, dot indicator, and next button.
 *
 * UI Includes:
 *  - Back button
 *  - Title curved text image
 *  - Animated moving glow background (PNG + Lottie)
 *  - Decorative stars
 *  - Shared trophy transition (not placed here)
 *  - Two lines of motivational text
 *  - Dots indicator (page = 1)
 *  - Image-based glossy next button
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
import androidx.compose.runtime.*
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
import com.airbnb.lottie.compose.*
import com.example.visithealthapplication.R
import com.example.visithealthapplication.onboarding.ui.components.DotsIndicator

@Composable
fun ScreenSecond(
    onNextClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF2BB2FF),  // Light blue
                        Color(0xFF1976D2)   // Deep blue
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
                .size(60.dp) // Big touch target
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = stringResource(R.string.back_),
                modifier = Modifier.size(28.dp)
            )
        }

        // ---------------------------------------------------------------
        // TITLE IMAGE (Step-a-thon)
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
        // RADIAL BACKGROUND (PNG + movement from Lottie)
        // ---------------------------------------------------------------
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.challenges_star)
        )

        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            speed = 1.2f
        )

        // Animated background rays
        Image(
            painter = painterResource(id = R.drawable.challenges_star_bg),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(600.dp)     // Bigger rays
                .graphicsLayer {
                    rotationZ = progress * 25f
                    scaleX = 0.9f + progress * 0.1f
                    scaleY = 0.9f + progress * 0.1f
                    alpha = 0.55f + progress * 0.25f
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
        // TEXT SECTION
        // ---------------------------------------------------------------
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Title font
            val montSemiFont = FontFamily(
                Font(R.font.montserrat_semibold, FontWeight.SemiBold)
            )

            Text(
                text = stringResource(R.string.claim_the_throne),
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

            // Subtitle font
            val montMedium = FontFamily(
                Font(R.font.montserrat_medium, FontWeight.Medium)
            )

            Text(
                text = stringResource(R.string.compete_with_your_colleagues_for_top_ranks),
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
        // DOTS (page = 1)
        // ---------------------------------------------------------------
        DotsIndicator(
            totalDots = 3,
            selectedIndex = 1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 110.dp)
        )

        // ---------------------------------------------------------------
        // NEXT BUTTON (glossy image)
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
                painter = painterResource(id = R.drawable.n),
                contentDescription = stringResource(R.string.next_button),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenSecondPreview() {
    ScreenSecond()
}
