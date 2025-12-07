/**
 * ---------------------------------------------------------------
 * File: DotsIndicator.kt
 * Author: Kartik Waghmare
 * Created: 10 Feb 2025
 *
 * Purpose:
 *  This composable displays a dot-based pagination indicator
 *  commonly used in onboarding screens. It visually represents
 *  the current page position among multiple pages.
 *
 * Usage:
 *  DotsIndicator(
 *      totalDots = 3,
 *      selectedIndex = currentPageIndex
 *  )
 *
 * ---------------------------------------------------------------
 */

package com.example.visithealthapplication.onboarding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A horizontal row of dots representing pagination.
 *
 * @param totalDots Total number of pages.
 * @param selectedIndex The currently active page index.
 * @param modifier Modifier to customize layout behavior.
 */
@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalDots) { index ->

            // Single small dot
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(
                        if (index == selectedIndex) 10.dp else 8.dp // selected dot is bigger
                    )
                    .background(
                        color = if (index == selectedIndex)
                            Color.White                   // active dot color
                        else
                            Color.White.copy(alpha = 0.4f), // inactive dot (faded)
                        shape = CircleShape
                    )
            )
        }
    }
}
