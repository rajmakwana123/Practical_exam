package com.example.eventease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventease.ui.theme.EventEaseTheme
import com.example.vivajetpack.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventEaseTheme {
                EventDetailsScreen()
            }
        }
    }
}



@Composable
fun EventDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        EventHeader()
        Spacer(modifier = Modifier.height(16.dp))

        // Event Info
        EventInfo()

        Spacer(modifier = Modifier.height(16.dp))

        // Event Schedule
        EventSchedule()

        Spacer(modifier = Modifier.height(16.dp))

        // Reviews Section
        ReviewsSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        ActionButtons()
    }
}

@Composable
fun EventHeader() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.event), // Replace with your image resource
            contentDescription = "Event Header Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = "EventEase",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
    }
}

@Composable
fun EventInfo() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Tech Conference 2024",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Mehsana, Gujarat | 2.5 km away",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This is a detailed description of the event...",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun EventSchedule() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Event Schedule",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(3) { index ->
                EventCard(
                    time = if (index == 0) "10:00 AM" else if (index == 1) "11:30 AM" else "01:00 PM",
                    title = if (index == 0) "Keynote Speech" else if (index == 1) "Networking Session" else "Closing Ceremony",
                    description = if (index == 0) "Keynote by our esteemed guest" else "Meet and connect with others"
                )
            }
        }
    }
}

@Composable
fun EventCard(time: String, title: String, description: String) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .width(200.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = time, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ReviewsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Reviews",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        repeat(3) {
            ReviewCard(
                reviewer = if (it == 0) "Alice Johnson" else if (it == 1) "Bob Smith" else "Charlie Davis",
                rating = 4,
                review = if (it == 0) "Great event! Well-organized and informative." else if (it == 1) "Really enjoyed the keynote speaker. Would recommend!" else "Good event overall, but some sessions were too short."
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ReviewCard(reviewer: String, rating: Int, review: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = reviewer, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "⭐".repeat(rating),
                    fontSize = 14.sp,
                    color = Color.Yellow
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = review, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /* Buy Tickets Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Buy Tickets", color = Color.White)
        }
        Button(
            onClick = { /* Add to Calendar Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
        ) {
            Text(text = "Add to Calendar", color = Color.Blue)
        }
    }
}
