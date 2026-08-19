package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        BlueprintGridBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            item {
                SectionHeader(
                    title = "Engineering Handbook & About",
                    subtitle = "Design methodology, professional ethics & standards",
                    icon = Icons.Default.Info,
                    badgeText = "Guide",
                    badgeColor = TechCyan
                )
            }

            // 1. The Engineering Design Process
            item {
                EngineeringCard(
                    borderColor = TechCyan.copy(alpha = 0.4f),
                    backgroundColor = CardBackground
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "The Engineering Design Process",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = TechCyan
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "A systematic, iterative method engineers use to create effective solutions to complex human problems.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        val designSteps = listOf(
                            Pair("1. Define the Problem", "Identify constraints, operational requirements, stakeholders, and success criteria."),
                            Pair("2. Background Research", "Examine prior art, existing physics constraints, standards, and material availability."),
                            Pair("3. Brainstorm & Ideate", "Explore multiple divergent concepts without premature optimization."),
                            Pair("4. Detailed Engineering", "Perform calculations, 3D CAD modeling, simulations, and stress analysis."),
                            Pair("5. Prototype & Test", "Fabricate proof-of-concept models and test against boundary conditions."),
                            Pair("6. Iterate & Optimize", "Analyze failures, redesign weak points, and refine tolerances."),
                            Pair("7. Final Implementation", "Document specifications, prepare manufacturing tooling, and deploy.")
                        )

                        designSteps.forEachIndexed { idx, (stepName, desc) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(TechCyan.copy(alpha = 0.2f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = TechCyan
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = stepName,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    Text(
                                        text = desc,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = TextSecondary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 2. Engineering Ethics & Public Safety
            item {
                EngineeringCard(
                    borderColor = EngineeringOrange.copy(alpha = 0.4f),
                    backgroundColor = CardBackground
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Security, contentDescription = null, tint = EngineeringOrange)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Code of Professional Ethics",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        val canons = listOf(
                            "1. Hold paramount the safety, health, and welfare of the public.",
                            "2. Perform services only in areas of their professional competence.",
                            "3. Issue public statements only in an objective and truthful manner.",
                            "4. Act for each employer or client as faithful agents or trustees.",
                            "5. Avoid deceptive acts and uphold the dignity and integrity of the profession."
                        )
                        canons.forEach { canon ->
                            Text(
                                text = "• $canon",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary,
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // 3. SI Fundamental Base Units Table
            item {
                EngineeringCard(
                    borderColor = SuccessGreen.copy(alpha = 0.4f),
                    backgroundColor = CardBackground
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "SI Fundamental Base Units (BIPM)",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        val baseUnits = listOf(
                            Triple("Length", "Meter", "m"),
                            Triple("Mass", "Kilogram", "kg"),
                            Triple("Time", "Second", "s"),
                            Triple("Electric Current", "Ampere", "A"),
                            Triple("Thermodynamic Temp.", "Kelvin", "K"),
                            Triple("Amount of Substance", "Mole", "mol"),
                            Triple("Luminous Intensity", "Candela", "cd")
                        )

                        baseUnits.forEach { (qty, name, sym) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = qty, style = MaterialTheme.typography.bodyMedium, color = TextPrimary, modifier = Modifier.weight(1.5f))
                                Text(text = name, style = MaterialTheme.typography.bodyMedium, color = TechCyan, modifier = Modifier.weight(1.2f))
                                Text(text = sym, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium, color = SuccessGreen, modifier = Modifier.weight(0.5f))
                            }
                        }
                    }
                }
            }

            // 4. Educational Notice
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(SurfaceVariantDark)
                        .padding(14.dp)
                ) {
                    Column {
                        Text(
                            text = "Educational & Academic Utility Notice",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = WarningYellow
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "ENGINEERING HUB is built as an interactive learning, calculation, and conceptual exploration platform for engineering students, educators, and technology enthusiasts. Real-world physical structural and safety-critical engineering designs must be independently calculated, modeled, and certified by licensed Professional Engineers (PE / Chartered Engineers) in compliance with local statutory building codes.",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}
