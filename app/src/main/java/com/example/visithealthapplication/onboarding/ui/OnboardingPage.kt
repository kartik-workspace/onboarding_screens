/**
 * -------------------------------------------------------------------------------
 * File: OnboardingFlow.kt
 * Project: VisitHealthApplication
 * Created: 12 Feb 2026
 * Author: Kartik Waghmare
 *
 * Purpose:
 *  This file manages the entire Onboarding Flow for the application using
 *  Jetpack Compose. It handles:
 *
 *  1. Page navigation between Screen 1 → Screen 2 → Screen 3.
 *  2. Shared element transitions:
 *       - Trophy animation between Screen 1 and Screen 2.
 *       - Gift animation between Screen 2 and Screen 3.
 *  3. Robot fade animation (visible only on Screen 1).
 *  4. Smooth scale, alpha, and position transitions using updateTransition().
 *
 *  This provides a professional, polished onboarding experience with rich motion.
 * -------------------------------------------------------------------------------
 */

package com.example.visithealthapplication.onboarding.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visithealthapplication.R
import com.example.visithealthapplication.onboarding.ui.screens.ScreenFirst
import com.example.visithealthapplication.onboarding.ui.screens.ScreenSecond
import com.example.visithealthapplication.onboarding.ui.screens.ScreenThird

/**
 * Enum representing pages of the onboarding UI.
 */
enum class OnboardingPage(val index: Int) {
    FIRST(0),
    SECOND(1),
    THIRD(2)
}

/**
 * Main onboarding host composable.
 * Controls:
 * - Navigation between screens
 * - Shared element transitions
 */
@Composable
fun OnboardingFlow(
    onFinished: () -> Unit = {}
) {
    var currentPage by remember { mutableStateOf(OnboardingPage.FIRST) }

    val transition = updateTransition(
        targetState = currentPage,
        label = stringResource(R.string.pagetransition)
    )

    // -----------------------------------------------------
    // Trophy Shared Element Animation (Screen 1 ↔ Screen 2)
    // -----------------------------------------------------

    val trophyOffsetX by transition.animateDp(
        transitionSpec = { tween(600, easing = FastOutSlowInEasing) },
        label = stringResource(R.string.trophyoffsetx)
    ) { state ->
        when (state) {
            OnboardingPage.FIRST -> 120.dp
            OnboardingPage.SECOND -> 0.dp
            else -> 120.dp
        }
    }

    val trophyOffsetY by transition.animateDp(
        transitionSpec = { tween(600) },
        label = stringResource(R.string.trophyoffsety)
    ) { state ->
        when (state) {
            OnboardingPage.FIRST -> (-220).dp
            OnboardingPage.SECOND -> 0.dp
            else -> (-220).dp
        }
    }

    // 60dp on Screen 1 → 60/300 = 0.20 scale
    val trophyScale by transition.animateFloat(
        transitionSpec = { tween(600, easing = FastOutSlowInEasing) },
        label = stringResource(R.string.trophyscale)
    ) { state ->
        when (state) {
            OnboardingPage.FIRST -> 0.20f
            OnboardingPage.SECOND -> 1f
            else -> 0f
        }
    }

    val trophyAlpha by transition.animateFloat(
        transitionSpec = { tween(600) },
        label = stringResource(R.string.trophyalpha)
    ) { state ->
        when (state) {
            OnboardingPage.FIRST, OnboardingPage.SECOND -> 1f
            else -> 0f
        }
    }

    // -----------------------------------------------------
    // Gift Shared Element Animation (Screen 2 ↔ Screen 3)
    // -----------------------------------------------------

    val giftOffsetX by transition.animateDp(
        transitionSpec = { tween(600) },
        label = "giftOffsetX"
    ) { state ->
        when (state) {
            OnboardingPage.SECOND -> 120.dp
            OnboardingPage.THIRD -> 0.dp
            else -> 120.dp
        }
    }

    val giftOffsetY by transition.animateDp(
        transitionSpec = { tween(600) },
        label = "giftOffsetY"
    ) { state ->
        when (state) {
            OnboardingPage.SECOND -> (-220).dp
            OnboardingPage.THIRD -> 0.dp
            else -> (-220).dp
        }
    }

    // 60dp on Screen 2 → scale = 0.20
    val giftScale by transition.animateFloat(
        transitionSpec = { tween(600) },
        label = "giftScale"
    ) { state ->
        when (state) {
            OnboardingPage.SECOND -> 0.20f
            OnboardingPage.THIRD -> 1f
            else -> 0f
        }
    }

    val giftAlpha by transition.animateFloat(
        transitionSpec = { tween(600) },
        label = "giftAlpha"
    ) { state ->
        when (state) {
            OnboardingPage.SECOND, OnboardingPage.THIRD -> 1f
            else -> 0f
        }
    }

    // -----------------------------------------------------
    // Robot fade animation (Screen 1 only)
    // -----------------------------------------------------
    val robotAlpha by transition.animateFloat(
        transitionSpec = { tween(600) },
        label = "robotAlpha"
    ) { state ->
        if (state == OnboardingPage.FIRST) 1f else 0f
    }

    // -----------------------------------------------------
    // Content layer
    // -----------------------------------------------------
    Box(modifier = Modifier.fillMaxSize()) {

        when (currentPage) {

            OnboardingPage.FIRST -> ScreenFirst(
                robotAlpha = robotAlpha,
                onNextClick = { currentPage = OnboardingPage.SECOND },
                onBackClick = { /* First screen → no back */ }
            )

            OnboardingPage.SECOND -> ScreenSecond(
                onNextClick = { currentPage = OnboardingPage.THIRD },
                onBackClick = { currentPage = OnboardingPage.FIRST }
            )

            OnboardingPage.THIRD -> ScreenThird(
                onNextClick = { onFinished() },
                onBackClick = { currentPage = OnboardingPage.SECOND }
            )
        }

        // -----------------------------------------------------
        // Trophy Layer
        // -----------------------------------------------------
        if (trophyScale > 0f && trophyAlpha > 0f) {
            Image(
                painter = painterResource(id = R.drawable.trophy),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(trophyOffsetX, trophyOffsetY)
                    .size((300 * trophyScale).dp)
                    .graphicsLayer { alpha = trophyAlpha }
            )
        }

        // -----------------------------------------------------
        // Gift Layer
        // -----------------------------------------------------
        if (giftScale > 0f && giftAlpha > 0f) {
            Image(
                painter = painterResource(id = R.drawable.gift_box),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(giftOffsetX, giftOffsetY)
                    .size((300 * giftScale).dp)
                    .graphicsLayer { alpha = giftAlpha }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingFlowPreview() {
    OnboardingFlow()
}
