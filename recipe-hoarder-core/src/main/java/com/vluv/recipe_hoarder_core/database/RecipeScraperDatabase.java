package com.vluv.recipe_hoarder_core.database;

import com.aper_lab.scraperlib.api.DatabaseConnection;
import com.aper_lab.scraperlib.api.IHasID;
import com.aper_lab.scraperlib.data.Recipe;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RecipeScraperDatabase implements DatabaseConnection{

    @Override
    public void storeData(@NotNull String path, @NotNull IHasID data) { //not in use
    }

    @Nullable
    @Override
    public Object getRecipeByURL(@NotNull String url, @NotNull Continuation<? super Recipe> $completion) {  //not in use
        return null;
    }

    @Nullable
    @Override
    public Object getRecipeByID(@NotNull String id, @NotNull Continuation<? super Recipe> $completion) {    //not in use
        return null;
    }

    @Override
    public void updateRecipe(@NotNull Recipe recipe) {  //it could update itself, even if i dont have an update function

    }

    @Override
    public void storeRecipe(@NotNull Recipe recipe) {   //we could use this

    }
}
