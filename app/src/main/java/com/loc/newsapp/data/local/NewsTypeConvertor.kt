package com.loc.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.loc.newsapp.domain.model.Source


//This is only necessary when you have an object in your entity e.g my entity Article has
//an object source: Source. Room only supports primitive data types


@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source) : String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source {
        return source.split(",").let {sourceArray ->
            Source(sourceArray[0],sourceArray[1])
        }
    }
}