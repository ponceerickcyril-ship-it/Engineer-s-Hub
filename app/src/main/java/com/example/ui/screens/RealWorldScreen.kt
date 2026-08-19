package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.EngineeringData
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun RealWorldScreen(modifier: Modifier = Modifier) {
    var selectedSystemId by remember { mutableStateOf(EngineeringData.realWorldSystems.first().id) }
    val currentSystem = EngineeringData.realWorldSystems.firstOrNull { it.id == selectedSystemId } ?: EngineeringData.realWorldSystems.first()
    var selectedHotspotIndex by remember { mutableStateOf(0) }

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
                    title = "Real-World Engineering Systems",
                    subtitle = "Interactive blueprint breakdowns of iconic modern engineering marvels",
                    icon = Icons.Default.Public,
                    badgeText = "${EngineeringData.realWorldSystems.size} Systems",
                    badgeColor = EngineeringOrange
                )
            }

            // System Selector Carousel
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(EngineeringData.realWorldSystems) { sys ->
                        val isSelected = sys.id == selectedSystemId
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSelected) EngineeringOrange else SurfaceVariantDark)
                                .border(1.dp, if (isSelected) EngineeringOrange else BorderDark, RoundedCornerShape(10.dp))
                                .clickable {
                                    selectedSystemId = sys.id
                                    selectedHotspotIndex = 0
                                }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .testTag("sys_tab_${sys.id}")
                        ) {
                            Column {
                                Text(
                                    text = sys.title,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) DeepNavy else TextPrimary
                                )
                                Text(
                                    text = sys.engineeringFields.firstOrNull() ?: "Engineering",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontSize = 10.sp,
                                    color = if (isSelected) DeepNavy else TechCyan
                                )
                            }
                        }
                    }
                }
            }

            // Interactive Blueprint Visualizer Card
            item {
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
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = currentSystem.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                                Text(
                                    text = currentSystem.subtitle,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = EngineeringOrange
                                )
                            }
                            TechBadge(text = currentSystem.iconCategory, color = TechCyan)
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Interactive Blueprint Schematics Canvas
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(DeepNavy)
                                .border(1.dp, TechCyan.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        ) {
                            // Canvas Blueprint drawing
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val w = size.width
                                val h = size.height

                                // Draw schematic lines
                                drawLine(TechCyan.copy(alpha = 0.3f), Offset(w * 0.1f, h * 0.8f), Offset(w * 0.9f, h * 0.8f), strokeWidth = 3f)
                                drawLine(TechCyan.copy(alpha = 0.3f), Offset(w * 0.5f, h * 0.2f), Offset(w * 0.5f, h * 0.8f), strokeWidth = 3f)
                                drawLine(TechCyan.copy(alpha = 0.2f), Offset(w * 0.5f, h * 0.2f), Offset(w * 0.2f, h * 0.8f), strokeWidth = 1.5f)
                                drawLine(TechCyan.copy(alpha = 0.2f), Offset(w * 0.5f, h * 0.2f), Offset(w * 0.35f, h * 0.8f), strokeWidth = 1.5f)
                                drawLine(TechCyan.copy(alpha = 0.2f), Offset(w * 0.5f, h * 0.2f), Offset(w * 0.65f, h * 0.8f), strokeWidth = 1.5f)
                                drawLine(TechCyan.copy(alpha = 0.2f), Offset(w * 0.5f, h * 0.2f), Offset(w * 0.8f, h * 0.8f), strokeWidth = 1.5f)
                            }

                            // Interactive Hotspot Nodes
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "📐 TAP HOTSPOT NODES TO INSPECT SUBSYSTEMS",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = TechCyan,
                                    fontWeight = FontWeight.Bold
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    currentSystem.hotspots.forEachIndexed { index, hotspot ->
                                        val isSelected = selectedHotspotIndex == index
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(if (isSelected) EngineeringOrange else SurfaceElevated)
                                                .border(1.2.dp, if (isSelected) EngineeringOrange else TechCyan, RoundedCornerShape(8.dp))
                                                .clickable { selectedHotspotIndex = index }
                                                .padding(horizontal = 8.dp, vertical = 6.dp)
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(8.dp)
                                                        .clip(CircleShape)
                                                        .background(if (isSelected) DeepNavy else TechCyan)
                                                )
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = hotspot.title,
                                                    style = MaterialTheme.typography.labelSmall,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (isSelected) DeepNavy else TextPrimary
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Active Hotspot Explanation Box
                        if (currentSystem.hotspots.isNotEmpty()) {
                            val safeIdx = selectedHotspotIndex.coerceIn(0, currentSystem.hotspots.size - 1)
                            val activeHotspot = currentSystem.hotspots[safeIdx]
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(SurfaceElevated)
                                    .border(1.dp, EngineeringOrange.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                                    .padding(12.dp)
                            ) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.Info,
                                            contentDescription = null,
                                            tint = EngineeringOrange,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "Subsystem Detail: ${activeHotspot.title}",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = EngineeringOrange
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = activeHotspot.description,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = TextPrimary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // How it Works & What Engineers Do
                        Text(
                            text = "What Engineers Design & Maintain",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentSystem.whatEngineersDo,
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextPrimary,
                            lineHeight = 20.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Why It Matters & Key Metric",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TechCyan
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${currentSystem.whyItMatters} (${currentSystem.keyMetric})",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextPrimary,
                            lineHeight = 20.sp
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Disciplines Involved
                        Text(
                            text = "Interdisciplinary Collaboration",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = TextSecondary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            currentSystem.engineeringFields.forEach { disc ->
                                TechBadge(text = disc, color = PurpleAccent)
                            }
                        }
                    }
                }
            }
        }
    }
}
