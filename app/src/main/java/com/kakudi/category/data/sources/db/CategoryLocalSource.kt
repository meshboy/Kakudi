package com.kakudi.category.data.sources.db

import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryLocalSource(private val categoryDao: CategoryDao) : CategoryRepository {
    override fun insert(data: Category): Observable<Unit> {
       return Observable.fromCallable{
           categoryDao.insertCategory(data)
       }
    }

    override fun getAllCategories(userId: String): Observable<List<Category>> {
        return categoryDao.getCategoriesById(userId)
    }

    override fun deleteCategory(name: String) {
    }

    override fun deleteAll() {

    }
}