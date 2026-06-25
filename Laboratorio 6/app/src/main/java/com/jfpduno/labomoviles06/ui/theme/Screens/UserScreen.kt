package com.jfpduno.labomoviles06.ui.theme.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.jfpduno.labomoviles06.model.Meal
import com.jfpduno.labomoviles06.ui.theme.LaboMoviles06Theme
import com.jfpduno.labomoviles06.viewmodel.UserViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    UserScreenContent(
        users = viewModel.users,
        isLoading = viewModel.isLoading,
        errorMessage = viewModel.errorMessage
    )
}

@Composable
fun UserScreenContent(
    users: List<Meal>,
    isLoading: Boolean,
    errorMessage: String?
) {
    when {
        isLoading -> {

            CircularProgressIndicator()
        }

        errorMessage != null -> {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(16.dp)
            )
        }

        else -> {

            LazyColumn {

                items(users) { meal ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = meal.strMeal
                            )

                            Text(
                                text = meal.strCategory
                            )
                            Text(
                                text = meal.strArea ?: "Origen desconocido"
                            )

                            AsyncImage(
                                model = meal.strMealThumb,
                                contentDescription = meal.strMeal,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserScreenPreview() {
    LaboMoviles06Theme {
        UserScreenContent(
            users = listOf(
                Meal(
                    idMeal = "52772",
                    strMeal = "Pupusas",
                    strCategory = "Tipical food",
                    strArea = "Salvadorean",
                    strMealThumb = "https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg"
                ),
                Meal(
                    idMeal = "52819",
                    strMeal = "Tacos",
                    strCategory = "Tipical food",
                    strArea = "Mexican",
                    strMealThumb = "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"
                )
            ),
            isLoading = false,
            errorMessage = null
        )
    }
}
