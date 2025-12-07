package com.example.visithealthapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.visithealthapplication.onboarding.ui.OnboardingFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    OnboardingFlow(
                        onFinished = {
                            Toast.makeText(this,
                                getString(R.string.onboarding_finished), Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
