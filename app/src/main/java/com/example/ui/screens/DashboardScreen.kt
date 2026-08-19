package com.example.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CalculatorType
import com.example.data.EngineeringData
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.navigation.AppScreen
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBackgroundSubtle
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.RoseAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SuccessGreenDark
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TechCyanDark
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow

@Composable
fun DashboardScreen(
    onNavigate: (AppScreen) -> Unit,
    onOpenCalculator: (CalculatorType) -> Unit,
    onOpenField: (String) -> Unit,
    onOpenSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Live Dashboard Ohm's Law State
    var currentInput by remember { mutableStateOf("2.5") }
    var resistanceInput by remember { mutableStateOf("47.0") }
    var calculatedVoltage by remember { mutableStateOf("117.5") }

    fun recalculateLiveOhm() {
        val i = currentInput.toDoubleOrNull() ?: 0.0
        val r = resistanceInput.toDoubleOrNull() ?: 0.0
        val v = i * r
        calculatedVoltage = String.format("%.2f", v)
    }

    Box(modifier = modifier.fillMaxSize()) {
        BlueprintGridBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. High Density 3-Column Stats Grid
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Fields Stat
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CardBackgroundSubtle)
                            .border(1.dp, BorderSubtle, RoundedCornerShape(12.dp))
                            .clickable { onNavigate(AppScreen.FIELDS) }
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    ) {
                        Column {
                            Text(
                                text = "FIELDS",
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondary,
                                fontSize = 9.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "10",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = TechCyan
                            )
                        }
                    }

                    // Formulas Stat
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CardBackgroundSubtle)
                            .border(1.dp, BorderSubtle, RoundedCornerShape(12.dp))
                            .clickable { onNavigate(AppScreen.FORMULAS) }
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    ) {
                        Column {
                            Text(
                                text = "FORMULAS",
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondary,
                                fontSize = 9.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "85+",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = WarningYellow
                            )
                        }
                    }

                    // Active Tools Stat
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CardBackgroundSubtle)
                            .border(1.dp, BorderSubtle, RoundedCornerShape(12.dp))
                            .clickable { onNavigate(AppScreen.CALCULATORS) }
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    ) {
                        Column {
                            Text(
                                text = "ACTIVE",
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondary,
                                fontSize = 9.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "14",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = SuccessGreen
                            )
                        }
                    }
                }
            }

            // 2. High Density Live Interactive Calculator: Ohm's Law
            item {
                val infiniteTransition = rememberInfiniteTransition(label = "pulse")
                val pulseAlpha by infiniteTransition.animateFloat(
                    initialValue = 0.4f,
                    targetValue = 1.0f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(800),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "pulseAlpha"
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(CardBackground)
                        .border(1.dp, BorderDark, RoundedCornerShape(16.dp))
                        .padding(14.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Header
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(width = 0.dp, color = Color.Transparent),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .clip(CircleShape)
                                        .background(SuccessGreen)
                                        .alpha(pulseAlpha)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "LIVE CALCULATOR: OHM'S LAW",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = TextSecondary,
                                    letterSpacing = 1.2.sp
                                )
                            }
                            Text(
                                text = "V = I × R",
                                fontFamily = FontFamily.Monospace,
                                style = MaterialTheme.typography.labelSmall,
                                color = TextTertiary
                            )
                        }

                        // Input Grid
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Current Input
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "CURRENT (I)",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextTertiary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(DeepNavy)
                                        .border(1.dp, BorderDark, RoundedCornerShape(8.dp))
                                        .padding(horizontal = 8.dp, vertical = 6.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedTextField(
                                        value = currentInput,
                                        onValueChange = {
                                            currentInput = it
                                            recalculateLiveOhm()
                                        },
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.Transparent,
                                            unfocusedBorderColor = Color.Transparent,
                                            focusedContainerColor = Color.Transparent,
                                            unfocusedContainerColor = Color.Transparent,
                                            focusedTextColor = TechCyan,
                                            unfocusedTextColor = TechCyan
                                        ),
                                        textStyle = MaterialTheme.typography.bodyMedium.copy(
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.Bold
                                        ),
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(38.dp)
                                            .testTag("dashboard_current_input")
                                    )
                                    Text(
                                        text = "Amps",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontSize = 10.sp,
                                        color = TextTertiary
                                    )
                                }
                            }

                            // Resistance Input
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "RESISTANCE (R)",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextTertiary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(DeepNavy)
                                        .border(1.dp, BorderDark, RoundedCornerShape(8.dp))
                                        .padding(horizontal = 8.dp, vertical = 6.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedTextField(
                                        value = resistanceInput,
                                        onValueChange = {
                                            resistanceInput = it
                                            recalculateLiveOhm()
                                        },
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.Transparent,
                                            unfocusedBorderColor = Color.Transparent,
                                            focusedContainerColor = Color.Transparent,
                                            unfocusedContainerColor = Color.Transparent,
                                            focusedTextColor = TechCyan,
                                            unfocusedTextColor = TechCyan
                                        ),
                                        textStyle = MaterialTheme.typography.bodyMedium.copy(
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.Bold
                                        ),
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(38.dp)
                                            .testTag("dashboard_resistance_input")
                                    )
                                    Text(
                                        text = "Ω",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontSize = 10.sp,
                                        color = TextTertiary
                                    )
                                }
                            }
                        }

                        // Result Action Banner
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(SuccessGreen.copy(alpha = 0.1f))
                                .border(1.dp, SuccessGreen.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "VOLTAGE OUTPUT",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = SuccessGreen
                                    )
                                    Text(
                                        text = "$calculatedVoltage V",
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        color = SuccessGreen
                                    )
                                }

                                Button(
                                    onClick = {
                                        recalculateLiveOhm()
                                        onOpenCalculator(CalculatorType.OHMS_LAW)
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                                    shape = RoundedCornerShape(8.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                                    modifier = Modifier.testTag("dashboard_calculate_button")
                                ) {
                                    Text(
                                        text = "FULL CALC",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = DeepNavy,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 3. High Density 2x2 Engineering Fields Grid
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Engineering Fields",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = "View All (${EngineeringData.fields.size})",
                            style = MaterialTheme.typography.labelSmall,
                            color = TechCyan,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable { onNavigate(AppScreen.FIELDS) }
                        )
                    }

                    // Row 1: Civil & Mechanical
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        HighDensityFieldCard(
                            title = "Civil",
                            desc = "Structures, infrastructure, and urban systems.",
                            icon = Icons.Default.Architecture,
                            badgeColor = ElectricBlue,
                            onClick = { onOpenField("civil") },
                            modifier = Modifier.weight(1f)
                        )
                        HighDensityFieldCard(
                            title = "Mechanical",
                            desc = "Dynamics, thermodynamics, and robotics.",
                            icon = Icons.Default.Settings,
                            badgeColor = EngineeringOrange,
                            onClick = { onOpenField("mechanical") },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Row 2: Computer & Chemical
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        HighDensityFieldCard(
                            title = "Computer",
                            desc = "Embedded systems and hardware design.",
                            icon = Icons.Default.Memory,
                            badgeColor = PurpleAccent,
                            onClick = { onOpenField("computer") },
                            modifier = Modifier.weight(1f)
                        )
                        HighDensityFieldCard(
                            title = "Chemical",
                            desc = "Process engineering and material science.",
                            icon = Icons.Default.Science,
                            badgeColor = RoseAccent,
                            onClick = { onOpenField("chemical") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // 4. Quick Utility Tools Strip
            item {
                SectionHeader(
                    title = "Quick Utility Tools",
                    badgeText = "Fast Access",
                    badgeColor = TechCyan
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    QuickToolDenseChip(
                        title = "Unit Converter",
                        icon = Icons.Default.SwapHoriz,
                        color = TechCyan,
                        onClick = { onNavigate(AppScreen.CONVERTER) },
                        modifier = Modifier.weight(1f)
                    )
                    QuickToolDenseChip(
                        title = "Simulators",
                        icon = Icons.Default.Visibility,
                        color = PurpleAccent,
                        onClick = { onNavigate(AppScreen.DIAGRAMS) },
                        modifier = Modifier.weight(1f)
                    )
                    QuickToolDenseChip(
                        title = "Materials DB",
                        icon = Icons.Default.Science,
                        color = SuccessGreen,
                        onClick = { onNavigate(AppScreen.MATERIALS) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // 5. Featured Formula Card
            item {
                val featured = EngineeringData.formulas.first()
                EngineeringCard(
                    borderColor = TechCyan.copy(alpha = 0.35f),
                    backgroundColor = CardBackground
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TechBadge(text = "FEATURED FORMULA", color = TechCyan)
                            Text(
                                text = "Formula Library →",
                                style = MaterialTheme.typography.labelSmall,
                                color = TechCyan,
                                modifier = Modifier.clickable { onNavigate(AppScreen.FORMULAS) }
                            )
                        }

                        Text(
                            text = featured.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        MathEquationBox(equation = featured.equation, accentColor = TechCyan)

                        Text(
                            text = featured.whenUsed,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "SI Unit: ${featured.siUnits}",
                                style = MaterialTheme.typography.labelSmall,
                                color = WarningYellow
                            )
                            if (featured.calculatorType != null) {
                                Button(
                                    onClick = { onOpenCalculator(featured.calculatorType) },
                                    colors = ButtonDefaults.buttonColors(containerColor = TechCyanDark),
                                    shape = RoundedCornerShape(6.dp),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                    modifier = Modifier.testTag("featured_formula_button")
                                ) {
                                    Text(
                                        text = "Open Calculator",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 6. Real-World Engineering Blueprint Preview
            item {
                val system = EngineeringData.realWorldSystems.first()
                EngineeringCard(
                    borderColor = EngineeringOrange.copy(alpha = 0.35f),
                    backgroundColor = CardBackground,
                    onClick = { onNavigate(AppScreen.REAL_WORLD) }
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TechBadge(text = "REAL-WORLD SYSTEM", color = EngineeringOrange)
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = EngineeringOrange,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Text(
                            text = system.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = system.subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = EngineeringOrange
                        )
                        Text(
                            text = system.whatEngineersDo,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // 7. Knowledge Check Teaser
            item {
                EngineeringCard(
                    borderColor = PurpleAccent.copy(alpha = 0.35f),
                    backgroundColor = CardBackground,
                    onClick = { onNavigate(AppScreen.LEARNING) }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            TechBadge(text = "KNOWLEDGE CHECK", color = PurpleAccent)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Test Your Engineering Skills",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "Interactive quizzes, step-by-step lessons & 50+ glossary terms.",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondary
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(PurpleAccent.copy(alpha = 0.2f))
                                .border(1.dp, PurpleAccent, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = null,
                                tint = PurpleAccent,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HighDensityFieldCard(
    title: String,
    desc: String,
    icon: ImageVector,
    badgeColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(CardBackgroundSubtle)
            .border(1.dp, BorderDark, RoundedCornerShape(14.dp))
            .clickable(onClick = onClick)
            .padding(12.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(badgeColor.copy(alpha = 0.2f))
                    .border(1.dp, badgeColor.copy(alpha = 0.35f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = badgeColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 10.sp,
                color = TextSecondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun QuickToolDenseChip(
    title: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(SurfaceVariantDark)
            .border(1.dp, color.copy(alpha = 0.25f), RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
