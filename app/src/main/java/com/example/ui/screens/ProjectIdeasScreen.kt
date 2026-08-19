package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Lightbulb
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.EngineeringData
import com.example.data.ProjectIdea
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.StepSolutionBox
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.WarningYellow

@Composable
fun ProjectIdeasScreen(modifier: Modifier = Modifier) {
    var expandedProjectId by remember { mutableStateOf<String?>(null) }

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
                    title = "Student Project Ideas",
                    subtitle = "Safe, hands-on engineering builds with principles, steps & real-world links",
                    icon = Icons.Default.Lightbulb,
                    badgeText = "${EngineeringData.projectIdeas.size} Builds",
                    badgeColor = WarningYellow
                )
            }

            // Projects List
            items(EngineeringData.projectIdeas.size) { index ->
                val project = EngineeringData.projectIdeas[index]
                val isExpanded = expandedProjectId == project.id

                ProjectCard(
                    project = project,
                    isExpanded = isExpanded,
                    onToggle = {
                        expandedProjectId = if (isExpanded) null else project.id
                    }
                )
            }
        }
    }
}

@Composable
fun ProjectCard(
    project: ProjectIdea,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    val diffColor = if (project.difficulty.contains("Easy", ignoreCase = true)) {
        SuccessGreen
    } else if (project.difficulty.contains("Medium", ignoreCase = true)) {
        TechCyan
    } else {
        EngineeringOrange
    }

    EngineeringCard(
        borderColor = if (isExpanded) WarningYellow.copy(alpha = 0.5f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = onToggle,
        modifier = Modifier.testTag("project_card_${project.id}")
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TechBadge(text = project.difficulty, color = diffColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    TechBadge(text = project.field, color = ElectricBlue)
                }
                Text(
                    text = "⏱ ${project.estimatedTime}",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextSecondary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = project.objective,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 14.dp)) {
                    // Materials Required
                    Text("Required Materials", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(SurfaceElevated)
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            project.basicMaterials.forEach { mat ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.Build, contentDescription = null, tint = TechCyan, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = mat, style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Step-by-Step Instructions
                    StepSolutionBox(
                        title = "Build & Test Instructions",
                        steps = project.steps,
                        accentColor = SuccessGreen
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Engineering Principle Learned
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(PurpleAccent.copy(alpha = 0.1f))
                            .border(1.dp, PurpleAccent.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Text("🔬 Core Engineering Principle", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = PurpleAccent)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = project.scientificPrinciple, style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Real-World Connection
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(WarningYellow.copy(alpha = 0.1f))
                            .border(1.dp, WarningYellow.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Text("🌐 Real-World Application", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = WarningYellow)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = project.realWorldConnection, style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                        }
                    }
                }
            }
        }
    }
}
