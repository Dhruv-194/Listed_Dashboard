package com.dhruv194.listed_dashboard.repository

import com.dhruv194.listed_dashboard.data.DashboardDataClass
import com.dhruv194.listed_dashboard.repository.api.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getDashboardData() :Response<DashboardDataClass>{
        return RetrofitInstance.api.getDashboard()
    }
}