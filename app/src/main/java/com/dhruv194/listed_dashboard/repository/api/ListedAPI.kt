package com.dhruv194.listed_dashboard.repository.api

import com.dhruv194.listed_dashboard.data.DashboardDataClass
import retrofit2.Response
import retrofit2.http.GET

interface ListedAPI {

    @GET("dashboardNew")
    suspend fun getDashboard() : Response<DashboardDataClass>
}