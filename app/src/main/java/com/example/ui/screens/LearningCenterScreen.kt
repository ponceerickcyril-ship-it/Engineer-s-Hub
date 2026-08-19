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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.EngineeringData
import com.example.data.LearningLesson
import com.example.data.WorkedProblem
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.StepSolutionBox
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
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

enum class LearningTab(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    QUIZ("Interactive Quiz", Icons.Default.Quiz),
    LESSONS("Mini Lessons", Icons.Default.School),
    WORKED_PROBLEMS("Worked Problems", Icons.Default.MenuBook),
    GLOSSARY("Glossary (A-Z)", Icons.Default.Book)
}

@Composable
fun LearningCenterScreen(modifier: Modifier = Modifier) {
    var activeTab by remember { mutableStateOf(LearningTab.QUIZ) }

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
                    title = "Learning Center",
                    subtitle = "Test your knowledge, review lessons & explore technical vocabulary",
                    icon = Icons.Default.School,
                    badgeText = "Student Hub",
                    badgeColor = PurpleAccent
                )
            }

            // Tab Selector
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(LearningTab.values()) { tab ->
                        val isSelected = activeTab == tab
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSelected) PurpleAccent else SurfaceVariantDark)
                                .border(1.dp, if (isSelected) PurpleAccent else BorderDark, RoundedCornerShape(10.dp))
                                .clickable { activeTab = tab }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .testTag("learn_tab_${tab.name}")
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = null,
                                    tint = if (isSelected) DeepNavy else TechCyan,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
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
            }

            // Active Tab Content
            when (activeTab) {
                LearningTab.QUIZ -> item { QuizView() }
                LearningTab.LESSONS -> {
                    items(EngineeringData.lessons) { lesson ->
                        LessonCard(lesson = lesson)
                    }
                }
                LearningTab.WORKED_PROBLEMS -> {
                    items(EngineeringData.workedProblems) { problem ->
                        WorkedProblemCard(problem = problem)
                    }
                }
                LearningTab.GLOSSARY -> item { GlossaryView() }
            }
        }
    }
}

// 1. Interactive Multiple-Choice Quiz
@Composable
fun QuizView() {
    val questions = EngineeringData.quizzes
    var currentIndex by remember { mutableStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var quizCompleted by remember { mutableStateOf(false) }

    val currentQuestion = questions[currentIndex]

    EngineeringCard(
        borderColor = PurpleAccent.copy(alpha = 0.5f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            if (quizCompleted) {
                // Completed View
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Quiz Completed!",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = TechCyan
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Your Score: $score / ${questions.size}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = if (score >= questions.size * 0.7) SuccessGreen else WarningYellow
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (score >= 8) "Outstanding engineering intuition!" else "Great effort! Review the lessons and try again to reinforce key concepts.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            currentIndex = 0
                            selectedOptionIndex = null
                            isSubmitted = false
                            score = 0
                            quizCompleted = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = TechCyan),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null, tint = DeepNavy)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Restart Quiz", color = DeepNavy, fontWeight = FontWeight.Bold)
                    }
                }
            } else {
                // Active Question View
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TechBadge(text = "Question ${currentIndex + 1} of ${questions.size}", color = PurpleAccent)
                    TechBadge(text = currentQuestion.field, color = TechCyan)
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Options List
                currentQuestion.options.forEachIndexed { idx, option ->
                    val isSelected = selectedOptionIndex == idx
                    val isCorrect = idx == currentQuestion.correctIndex

                    val optionBgColor = when {
                        isSubmitted && isCorrect -> SuccessGreen.copy(alpha = 0.2f)
                        isSubmitted && isSelected && !isCorrect -> ErrorRed.copy(alpha = 0.2f)
                        isSelected -> TechCyan.copy(alpha = 0.15f)
                        else -> SurfaceElevated
                    }

                    val optionBorderColor = when {
                        isSubmitted && isCorrect -> SuccessGreen
                        isSubmitted && isSelected && !isCorrect -> ErrorRed
                        isSelected -> TechCyan
                        else -> BorderDark
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(optionBgColor)
                            .border(1.dp, optionBorderColor, RoundedCornerShape(10.dp))
                            .clickable(enabled = !isSubmitted) { selectedOptionIndex = idx }
                            .padding(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary,
                                modifier = Modifier.weight(1f)
                            )
                            if (isSubmitted) {
                                if (isCorrect) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = SuccessGreen)
                                } else if (isSelected) {
                                    Icon(Icons.Default.Close, contentDescription = null, tint = ErrorRed)
                                }
                            }
                        }
                    }
                }

                // Explanation Box if submitted
                if (isSubmitted) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(SurfaceElevated)
                            .border(1.dp, TechCyan.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                text = "💡 Explanation:",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = TechCyan
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = currentQuestion.explanation,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Submit / Next Button
                if (!isSubmitted) {
                    Button(
                        onClick = {
                            if (selectedOptionIndex != null) {
                                isSubmitted = true
                                if (selectedOptionIndex == currentQuestion.correctIndex) {
                                    score += 1
                                }
                            }
                        },
                        enabled = selectedOptionIndex != null,
                        colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Submit Answer", fontWeight = FontWeight.Bold, color = DeepNavy)
                    }
                } else {
                    Button(
                        onClick = {
                            if (currentIndex + 1 < questions.size) {
                                currentIndex += 1
                                selectedOptionIndex = null
                                isSubmitted = false
                            } else {
                                quizCompleted = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = TechCyan),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (currentIndex + 1 < questions.size) "Next Question →" else "View Final Results", fontWeight = FontWeight.Bold, color = DeepNavy)
                    }
                }
            }
        }
    }
}

// 2. Mini Lessons Card
@Composable
fun LessonCard(lesson: LearningLesson) {
    var isExpanded by remember { mutableStateOf(false) }

    EngineeringCard(
        borderColor = if (isExpanded) TechCyan.copy(alpha = 0.5f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = { isExpanded = !isExpanded }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TechBadge(text = lesson.category, color = ElectricBlue)
                Text(
                    text = lesson.readTime,
                    style = MaterialTheme.typography.labelSmall,
                    color = TextTertiary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = lesson.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = lesson.summary,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                lineHeight = 20.sp,
                maxLines = if (isExpanded) Int.MAX_VALUE else 3
            )

            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    lesson.sections.forEach { sec ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(sec.heading, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(sec.body, style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(TechCyan.copy(alpha = 0.1f))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "💡 Key Takeaway: ${lesson.keyTakeaway}",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Bold,
                            color = TechCyan
                        )
                    }
                }
            }
        }
    }
}

// 3. Worked Problems Card
@Composable
fun WorkedProblemCard(problem: WorkedProblem) {
    EngineeringCard(
        borderColor = SuccessGreen.copy(alpha = 0.4f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = problem.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                TechBadge(text = problem.topic, color = SuccessGreen)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(SurfaceElevated)
                    .padding(10.dp)
            ) {
                Text(
                    text = problem.problemStatement,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            StepSolutionBox(steps = problem.steps, accentColor = SuccessGreen)
        }
    }
}

// 4. Searchable 50-Term Glossary
@Composable
fun GlossaryView() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredGlossary = EngineeringData.glossaryTerms.filter {
        it.term.contains(searchQuery, ignoreCase = true) ||
                it.definition.contains(searchQuery, ignoreCase = true) ||
                it.category.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search 50+ engineering terms (e.g. Torque, Kinematics)...", color = TextTertiary) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("glossary_search_input"),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = TechCyan,
                unfocusedBorderColor = BorderDark,
                focusedContainerColor = SurfaceVariantDark,
                unfocusedContainerColor = SurfaceVariantDark,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        filteredGlossary.forEach { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(CardBackground)
                    .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.term,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TechCyan
                        )
                        TechBadge(text = item.category, color = ElectricBlue)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.definition,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextPrimary
                    )
                }
            }
        }
    }
}
