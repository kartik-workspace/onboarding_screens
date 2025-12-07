/**
 * ---------------------------------------------------------------
 * File: ScreenFirst.kt
 * Author: Kartik Waghmare
 * Created: 11 Feb 2025
 *
 * Purpose:
 *  First screen of the onboarding flow.
 *  Shows robot, animated shared trophy transition (from host),
 *  title image, motivational text, and navigation controls.
// *
 * UI Includes:
 *  - Back button (disabled on screen 1)
 *  - Title curved text image
 *  - Left and right stars
 *  - Robot mascot (alpha animated by OnboardingFlow)
 *  - Dots indicator for pagination
 *  - Image-based glossy next button
 *
 * ---------------------------------------------------------------
 */

package com.example.visithealthapplication.onboarding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
import com.example.visithealthapplication.R
import com.example.visithealthapplication.onboarding.ui.components.DotsIndicator

@Composable
fun ScreenFirst(
    robotAlpha: Float = 1f,
    onNextClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3A1CC9)) // Purple background
    ) {

        // -----------------------------------------------------------------
        // BACK BUTTON (Not used in first screen, but kept for consistency)
        // -----------------------------------------------------------------
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 24.dp)
                .size(60.dp) // Recommended touch area
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = stringResource(R.string.back_),
                modifier = Modifier.size(28.dp)
            )
        }

        // -----------------------------------------------------------------
        // TITLE IMAGE (Step-a-thon curved text)
        // -----------------------------------------------------------------
        Image(
            painter = painterResource(id = R.drawable.text),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp)
                .width(230.dp)
        )

        // -----------------------------------------------------------------
        // STAR DECORATIONS (Left + Right)
        // -----------------------------------------------------------------
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

        // -----------------------------------------------------------------
        // ROBOT MASCOT (Alpha animated by OnboardingFlow shared element)
        // -----------------------------------------------------------------
        Image(
            painter = painterResource(id = R.drawable.robot),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(370.dp)
                .alpha(robotAlpha)
        )

        // -----------------------------------------------------------------
        // TEXT SECTION (Montserrat Fonts)
        // -----------------------------------------------------------------
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
                text = stringResource(R.string.step_up_and_score),
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
                text = stringResource(R.string.join_the_race_lace_up_and_embrace_health),
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

        // -----------------------------------------------------------------
        // DOTS INDICATOR (page = 0)
        // -----------------------------------------------------------------
        DotsIndicator(
            totalDots = 3,
            selectedIndex = 0,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 110.dp)
        )

        // -----------------------------------------------------------------
        // NEXT BUTTON (Image-based glossy button)
        // -----------------------------------------------------------------
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
                contentDescription = "Next Button",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenFirstPreview() {
    ScreenFirst()
}
