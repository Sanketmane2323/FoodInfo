package com.example.foodinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.foodinfo.model.FoodObject
import com.example.foodinfo.model.Recipes


@Composable
fun recipeItem(
    recipe: Recipes
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.padding(horizontal = 8.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Text(
                text = recipe.day,
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = recipe.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .sizeIn(150.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = painterResource(id = recipe.image),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = recipe.description, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun recipeList(
    recipes : List<Recipes>
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        itemsIndexed(recipes){index, recipe ->
            recipeItem(recipe = recipe)
        }
    }
}



@Preview
@Composable
fun previewFunction(){
    AppTheme( useDarkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AppTheme {

            recipeList(recipes = FoodObject.recipes)

            }
        }
    }
}
