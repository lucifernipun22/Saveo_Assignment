<h1 align="center">Saveo Movie App</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">  
This is a Movie Review android project based on modern Android application tech-stacks and MVVM architecture. In this app user can see the reviews of the movies. Fetch the API:
 https://api.tvmaze.com/ and also save the data into Room database.
</p>

## Download
Go to the [Releases](https://github.com/lucifernipun22/Saveo_Assignment/blob/main/Saveo_Assignment/app/release/) to download the latest APK.

<img src="https://github.com/lucifernipun22/Saveo_Assignment/blob/main/app.gif" align="right" width="32%"/>

## Libraries & Tech Used
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous handling.
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - observing data when lifecycle state changes.
  - ViewModel - lifecycle aware UI related data holder.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model) 
- [Glide](https://github.com/bumptech/glide) - loading images.
- [Gson](https://github.com/google/gson/) - A JSON library for parsing network response.
- [Retrofit](https://github.com/square/retrofit) - for REST APIs and network data.
- [Room] - for Save the data into local database
## Architecture
Saveo Movie app based on MVVM architecture.
- ![architecture](https://raw.githubusercontent.com/lucifernipun22/Saveo_Assignment/main/architecture.png?token=AN2ZZLLOO7MFGXC3XFLO7EDA7XMN2)


