package com.example.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow
import java.text.DecimalFormat
import kotlin.math.cos
import kotlin.math.sin

enum class SimulatorTab(val title: String) {
    CIRCUIT("Circuit Simulator"),
    TRUSS_BRIDGE("Truss Bridge Load"),
    GEAR_RATIO("Gear Ratio & Torque")
}

@Composable
fun DiagramsScreen(modifier: Modifier = Modifier) {
    var activeTab by remember { mutableStateOf(SimulatorTab.CIRCUIT) }

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
                    title = "Interactive Simulators",
                    subtitle = "Visual mathematical physics, electronics & structural load models",
                    icon = Icons.Default.Visibility,
                    badgeText = "Real-Time Physics",
                    badgeColor = PurpleAccent
                )
            }

            // Tab Selector
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SimulatorTab.values().forEach { tab ->
                        val isSelected = activeTab == tab
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSelected) PurpleAccent else SurfaceVariantDark)
                                .border(1.dp, if (isSelected) PurpleAccent else BorderDark, RoundedCornerShape(10.dp))
                                .clickable { activeTab = tab }
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = tab.title,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) DeepNavy else TextPrimary
                            )
                        }
                    }
                }
            }

            // Active Simulator
            item {
                when (activeTab) {
                    SimulatorTab.CIRCUIT -> CircuitSimulatorView()
                    SimulatorTab.TRUSS_BRIDGE -> TrussBridgeSimulatorView()
                    SimulatorTab.GEAR_RATIO -> GearRatioSimulatorView()
                }
            }
        }
    }
}

// 1. Interactive Circuit Simulator
@Composable
fun CircuitSimulatorView() {
    var isSeries by remember { mutableStateOf(true) }
    var voltage by remember { mutableStateOf(12f) }
    var r1 by remember { mutableStateOf(10f) }
    var r2 by remember { mutableStateOf(20f) }

    val df = DecimalFormat("#.###")

    val req = if (isSeries) r1 + r2 else (r1 * r2) / (r1 + r2)
    val totalCurrent = voltage / req
    val i1 = if (isSeries) totalCurrent else voltage / r1
    val i2 = if (isSeries) totalCurrent else voltage / r2
    val v1 = if (isSeries) totalCurrent * r1 else voltage
    val v2 = if (isSeries) totalCurrent * r2 else voltage

    EngineeringCard(
        borderColor = TechCyan.copy(alpha = 0.5f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Circuit Analysis Engine",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                TechBadge(text = if (isSeries) "Series Circuit" else "Parallel Circuit", color = TechCyan)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Topology Switcher
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { isSeries = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSeries) TechCyan else SurfaceVariantDark
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Series (R_eq = R1 + R2)", color = if (isSeries) DeepNavy else TextPrimary, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = { isSeries = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isSeries) TechCyan else SurfaceVariantDark
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Parallel (1/R_eq)", color = if (!isSeries) DeepNavy else TextPrimary, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Circuit Schematic Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DeepNavy)
                    .border(1.dp, TechCyan.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    // Main outer loop
                    drawRect(
                        color = TechCyan,
                        topLeft = Offset(w * 0.15f, h * 0.2f),
                        size = androidx.compose.ui.geometry.Size(w * 0.7f, h * 0.6f),
                        style = Stroke(width = 3f)
                    )

                    // Voltage source badge on left
                    drawCircle(color = DeepNavy, radius = 20f, center = Offset(w * 0.15f, h * 0.5f))
                    drawCircle(color = WarningYellow, radius = 20f, center = Offset(w * 0.15f, h * 0.5f), style = Stroke(width = 2f))

                    // Resistors
                    if (isSeries) {
                        // R1 on top
                        drawRect(color = ElectricBlue, topLeft = Offset(w * 0.35f, h * 0.15f), size = androidx.compose.ui.geometry.Size(w * 0.12f, h * 0.1f))
                        // R2 on top right
                        drawRect(color = SuccessGreen, topLeft = Offset(w * 0.55f, h * 0.15f), size = androidx.compose.ui.geometry.Size(w * 0.12f, h * 0.1f))
                    } else {
                        // Parallel branch middle wire
                        drawLine(TechCyan, Offset(w * 0.5f, h * 0.2f), Offset(w * 0.5f, h * 0.8f), strokeWidth = 3f)
                        drawRect(color = ElectricBlue, topLeft = Offset(w * 0.45f, h * 0.45f), size = androidx.compose.ui.geometry.Size(w * 0.1f, h * 0.1f))
                        drawRect(color = SuccessGreen, topLeft = Offset(w * 0.80f, h * 0.45f), size = androidx.compose.ui.geometry.Size(w * 0.1f, h * 0.1f))
                    }
                }

                Column(modifier = Modifier.padding(10.dp)) {
                    Text("DC Source: ${df.format(voltage)} V", style = MaterialTheme.typography.labelSmall, color = WarningYellow, fontWeight = FontWeight.Bold)
                    Text("Total Current I_tot: ${df.format(totalCurrent)} A", style = MaterialTheme.typography.labelSmall, color = TechCyan, fontWeight = FontWeight.Bold)
                    Text("Req: ${df.format(req)} Ω", style = MaterialTheme.typography.labelSmall, color = SuccessGreen)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Sliders for Voltage, R1, R2
            Text("Voltage Source (V): ${df.format(voltage)} V", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = voltage,
                onValueChange = { voltage = it },
                valueRange = 1f..48f,
                colors = SliderDefaults.colors(thumbColor = TechCyan, activeTrackColor = TechCyan)
            )

            Text("Resistor 1 (R₁): ${df.format(r1)} Ω", style = MaterialTheme.typography.labelMedium, color = ElectricBlue)
            Slider(
                value = r1,
                onValueChange = { r1 = it },
                valueRange = 1f..100f,
                colors = SliderDefaults.colors(thumbColor = ElectricBlue, activeTrackColor = ElectricBlue)
            )

            Text("Resistor 2 (R₂): ${df.format(r2)} Ω", style = MaterialTheme.typography.labelMedium, color = SuccessGreen)
            Slider(
                value = r2,
                onValueChange = { r2 = it },
                valueRange = 1f..100f,
                colors = SliderDefaults.colors(thumbColor = SuccessGreen, activeTrackColor = SuccessGreen)
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Real-time Multimeter Readout Table
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SurfaceElevated)
                    .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Live Telemetry & Component Drops", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Component R₁ (Drop & Current):", style = MaterialTheme.typography.bodySmall, color = TextSecondary)
                        Text("${df.format(v1)} V  |  ${df.format(i1)} A", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = ElectricBlue)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Component R₂ (Drop & Current):", style = MaterialTheme.typography.bodySmall, color = TextSecondary)
                        Text("${df.format(v2)} V  |  ${df.format(i2)} A", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = SuccessGreen)
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total Power Dissipated (P = VI):", style = MaterialTheme.typography.bodySmall, color = TextSecondary)
                        Text("${df.format(voltage * totalCurrent)} W", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = WarningYellow)
                    }
                }
            }
        }
    }
}

// 2. Interactive Truss Bridge Load Simulator
@Composable
fun TrussBridgeSimulatorView() {
    var loadKn by remember { mutableStateOf(150f) }
    var loadPositionRatio by remember { mutableStateOf(0.5f) } // 0.2 to 0.8

    val df = DecimalFormat("#.##")
    val leftReaction = loadKn * (1f - loadPositionRatio)
    val rightReaction = loadKn * loadPositionRatio

    // Approximate internal bar forces (Tension vs Compression)
    val topChordCompression = loadKn * 0.85f
    val bottomChordTension = loadKn * 0.75f
    val diagonalShear = loadKn * 0.6f

    EngineeringCard(
        borderColor = EngineeringOrange.copy(alpha = 0.5f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Truss Bridge Load Distribution",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                TechBadge(text = "Warren Truss", color = EngineeringOrange)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Canvas Bridge schematic
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DeepNavy)
                    .border(1.dp, EngineeringOrange.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    val yBottom = h * 0.75f
                    val yTop = h * 0.25f

                    val p0 = Offset(w * 0.1f, yBottom)
                    val p1 = Offset(w * 0.3f, yBottom)
                    val p2 = Offset(w * 0.5f, yBottom)
                    val p3 = Offset(w * 0.7f, yBottom)
                    val p4 = Offset(w * 0.9f, yBottom)

                    val t1 = Offset(w * 0.2f, yTop)
                    val t2 = Offset(w * 0.4f, yTop)
                    val t3 = Offset(w * 0.6f, yTop)
                    val t4 = Offset(w * 0.8f, yTop)

                    // Draw bottom chord (Tension = Cyan)
                    drawLine(TechCyan, p0, p4, strokeWidth = 5f)

                    // Draw top chord (Compression = Orange/Red)
                    drawLine(EngineeringOrange, t1, t4, strokeWidth = 5f)

                    // Diagonals & verticals
                    drawLine(SuccessGreen, p0, t1, strokeWidth = 3f)
                    drawLine(EngineeringOrange, t1, p1, strokeWidth = 3f)
                    drawLine(SuccessGreen, p1, t2, strokeWidth = 3f)
                    drawLine(EngineeringOrange, t2, p2, strokeWidth = 3f)
                    drawLine(SuccessGreen, p2, t3, strokeWidth = 3f)
                    drawLine(EngineeringOrange, t3, p3, strokeWidth = 3f)
                    drawLine(SuccessGreen, p3, t4, strokeWidth = 3f)
                    drawLine(EngineeringOrange, t4, p4, strokeWidth = 3f)

                    // Draw Applied Load Vector Arrow
                    val loadX = w * (0.1f + loadPositionRatio * 0.8f)
                    drawLine(ErrorRed, Offset(loadX, yBottom - 40f), Offset(loadX, yBottom), strokeWidth = 5f)
                    drawCircle(ErrorRed, radius = 6f, center = Offset(loadX, yBottom))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Left Pier R_A: ${df.format(leftReaction)} kN", style = MaterialTheme.typography.labelSmall, color = TechCyan)
                    Text("Right Pier R_B: ${df.format(rightReaction)} kN", style = MaterialTheme.typography.labelSmall, color = TechCyan)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text("Applied Vehicle / Live Load: ${df.format(loadKn)} kN", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = loadKn,
                onValueChange = { loadKn = it },
                valueRange = 10f..500f,
                colors = SliderDefaults.colors(thumbColor = EngineeringOrange, activeTrackColor = EngineeringOrange)
            )

            Text("Load Position Along Span: ${df.format(loadPositionRatio * 100)}%", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = loadPositionRatio,
                onValueChange = { loadPositionRatio = it },
                valueRange = 0.1f..0.9f,
                colors = SliderDefaults.colors(thumbColor = TechCyan, activeTrackColor = TechCyan)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Member force breakdown
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(EngineeringOrange.copy(alpha = 0.15f))
                        .border(1.dp, EngineeringOrange.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Column {
                        Text("Top Compression", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = EngineeringOrange)
                        Text("${df.format(topChordCompression)} kN", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = TextPrimary)
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(TechCyan.copy(alpha = 0.15f))
                        .border(1.dp, TechCyan.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Column {
                        Text("Bottom Tension", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                        Text("${df.format(bottomChordTension)} kN", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = TextPrimary)
                    }
                }
            }
        }
    }
}

// 3. Interactive Gear Ratio & Torque Multiplier Simulator
@Composable
fun GearRatioSimulatorView() {
    var driverTeeth by remember { mutableStateOf(12f) }
    var drivenTeeth by remember { mutableStateOf(36f) }
    var inputRpm by remember { mutableStateOf(1800f) }

    val df = DecimalFormat("#.##")
    val gearRatio = drivenTeeth / driverTeeth
    val outputRpm = inputRpm / gearRatio
    val torqueMultiplier = gearRatio

    val infiniteTransition = rememberInfiniteTransition(label = "gearRotation")
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "gearAngle"
    )

    EngineeringCard(
        borderColor = PurpleAccent.copy(alpha = 0.5f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Gear Train & Torque Multiplier",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                TechBadge(text = "Mechanical Advantage", color = PurpleAccent)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Animated Gear Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DeepNavy)
                    .border(1.dp, PurpleAccent.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    val centerA = Offset(w * 0.35f, h * 0.5f)
                    val radiusA = 35f
                    val centerB = Offset(w * 0.65f, h * 0.5f)
                    val radiusB = 55f

                    // Draw Driver Gear (Clockwise)
                    drawCircle(PurpleAccent, radius = radiusA, center = centerA, style = Stroke(width = 4f))
                    for (i in 0 until driverTeeth.toInt()) {
                        val angle = Math.toRadians((i * (360.0 / driverTeeth) + rotationAngle).toDouble())
                        val toothX = centerA.x + (radiusA + 6f) * cos(angle).toFloat()
                        val toothY = centerA.y + (radiusA + 6f) * sin(angle).toFloat()
                        drawCircle(TechCyan, radius = 3f, center = Offset(toothX, toothY))
                    }

                    // Draw Driven Gear (Counter-Clockwise)
                    drawCircle(SuccessGreen, radius = radiusB, center = centerB, style = Stroke(width = 5f))
                    for (i in 0 until drivenTeeth.toInt()) {
                        val angle = Math.toRadians((i * (360.0 / drivenTeeth) - (rotationAngle / gearRatio)).toDouble())
                        val toothX = centerB.x + (radiusB + 8f) * cos(angle).toFloat()
                        val toothY = centerB.y + (radiusB + 8f) * sin(angle).toFloat()
                        drawCircle(WarningYellow, radius = 4f, center = Offset(toothX, toothY))
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Driver (Pinion): ${driverTeeth.toInt()}T", style = MaterialTheme.typography.labelSmall, color = TechCyan)
                    Text("Driven (Bull Gear): ${drivenTeeth.toInt()}T", style = MaterialTheme.typography.labelSmall, color = SuccessGreen)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text("Driver Gear Teeth (N_in): ${driverTeeth.toInt()} Teeth", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = driverTeeth,
                onValueChange = { driverTeeth = it },
                valueRange = 8f..48f,
                steps = 40,
                colors = SliderDefaults.colors(thumbColor = TechCyan, activeTrackColor = TechCyan)
            )

            Text("Driven Gear Teeth (N_out): ${drivenTeeth.toInt()} Teeth", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = drivenTeeth,
                onValueChange = { drivenTeeth = it },
                valueRange = 8f..72f,
                steps = 64,
                colors = SliderDefaults.colors(thumbColor = SuccessGreen, activeTrackColor = SuccessGreen)
            )

            Text("Input Motor Speed: ${inputRpm.toInt()} RPM", style = MaterialTheme.typography.labelMedium, color = TextPrimary)
            Slider(
                value = inputRpm,
                onValueChange = { inputRpm = it },
                valueRange = 100f..3600f,
                colors = SliderDefaults.colors(thumbColor = PurpleAccent, activeTrackColor = PurpleAccent)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Output Calculations Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SurfaceElevated)
                    .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Gear Transmission Calculations", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = PurpleAccent)
                    Text("• Gear Ratio: GR = N_out / N_in = ${df.format(gearRatio)} : 1", fontFamily = FontFamily.Monospace, style = MaterialTheme.typography.bodyMedium, color = TextPrimary)
                    Text("• Output Shaft Speed: ${df.format(outputRpm)} RPM", fontFamily = FontFamily.Monospace, style = MaterialTheme.typography.bodyMedium, color = TechCyan)
                    Text("• Output Torque Multiplier: ×${df.format(torqueMultiplier)} (Ideal)", fontFamily = FontFamily.Monospace, style = MaterialTheme.typography.bodyMedium, color = SuccessGreen)
                }
            }
        }
    }
}
