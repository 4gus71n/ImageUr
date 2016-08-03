# ImageUr

##About
This is a sample project to test a RxJava + Retrofit2 architecture. I also used Dagger to perform the dependency injection, Butterknife to avoid all the `findViewById` boilerplate code and Picasso to load the images.

##Features

Using RxJAva and Retrofit2 I achived a service layer architecture. The idea is that all the Services classes are provided by a service module, in this case the [ApplicationModule](https://github.com/4gus71n/ImageUr/blob/master/app/src/main/java/com/tradehelm/imageur/di/ApplicationModule.java). I'm shrinking the images that I'm displaying in the `RecyclerView` so we can save a little bit of memory. And I'm [cancelling](https://github.com/4gus71n/ImageUr/blob/master/app/src/main/java/com/tradehelm/imageur/ui/viewholder/ImageUrViewHolder.java#L61) every request that isn't displayed by the `ViewHolders`, this way if you scroll like crazy through the list, instead of stacking up 500 request, we end up sending only the request of the `ViewHolders` that we're seeing. I'm also doing some single permission validations, so if you want to check your geolocation position, tapping on the toolbar item, if you don't have permissions to use the GPS, the app will ask you to enable them, and if you don't have the GPS turned on, the app will also ask you to turn it on. Finally, I left several comments showing my point of view about some choices that I made.

##Documentation
  This articles were really useful while developing the app:
   * https://www.reddit.com/r/androiddev/comments/2ccetz/retrofit_volley_ion_comparison_between_the_3/
   * https://github.com/ruler88/GithubDemo
   * https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit

##APK

[Click here](https://github.com/4gus71n/ImageUr/blob/master/app-debug.apk) to download directly the debug apk to your phone.
