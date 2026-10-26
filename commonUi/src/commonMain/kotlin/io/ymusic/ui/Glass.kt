package io.ymusic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val GlassPanelFill: Color
    @Composable @ReadOnlyComposable
    get() = if (DesignColors.isDark) Color.White.copy(alpha = 0.08f) else Color.White.copy(alpha = 0.62f)

val GlassPanelBorder: Color
    @Composable @ReadOnlyComposable
    get() = if (DesignColors.isDark) Color.White.copy(alpha = 0.16f) else Color.Black.copy(alpha = 0.10f)

val GlassBarFill: Color
    @Composable @ReadOnlyComposable
    get() = if (DesignColors.isDark) Color.Black.copy(alpha = 0.72f) else Color.White.copy(alpha = 0.72f)

@Composable
fun GlassSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    content: @Composable BoxScope.() -> Unit,
) {
    val fill = GlassPanelFill
    val border = GlassPanelBorder
    val highlight = if (DesignColors.isDark) Color.White.copy(alpha = 0.18f) else Color.White.copy(alpha = 0.85f)
    Box(
        modifier
            .clip(shape)
            .background(Brush.verticalGradient(listOf(highlight, fill, fill)), shape)
            .border(1.dp, border, shape),
        content = content,
    )
}
