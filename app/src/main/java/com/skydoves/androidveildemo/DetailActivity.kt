/*
 * Copyright (C) 2018 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.androidveildemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import kotlinx.android.synthetic.main.activity_detail.detail_toolbar
import kotlinx.android.synthetic.main.activity_detail.detail_veilLayout_body
import kotlinx.android.synthetic.main.activity_detail.detail_veilLayout_header

/**
 * Developed by skydoves on 2018-10-30.
 * Copyright (c) 2018 skydoves rights reserved.
 */

@SuppressLint("CheckResult")
class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    applyToolbarMargin(detail_toolbar)

    detail_veilLayout_header.shimmer = ShimmerUtils.getGrayShimmer(this)
    detail_veilLayout_body.shimmer = ShimmerUtils.getGrayShimmer(this)

    // delay-auto-unveil
    Observable.just(0).delay(3000, TimeUnit.MILLISECONDS)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe {
        detail_veilLayout_header.unVeil()
        detail_veilLayout_body.unVeil()
      }
  }
}
