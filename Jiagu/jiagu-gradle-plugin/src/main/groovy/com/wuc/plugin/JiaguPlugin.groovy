package com.wuc.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.builder.model.SigningConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

class JiaguPlugin implements Plugin<Project> {
  @Override
  void apply(Project project) {
    def jiagu = project.extensions.create("jiagu", JiaguExtension)
    // 回调, 在gradle配置完成之后回调，在解析完build.gradle之后回调
    project.afterEvaluate {
      AppExtension android = project.extensions.android
      android.applicationVariants.each { ApplicationVariant variant ->
        //对应变体(debug/release)的签名配置
        SigningConfig signingConfig = variant.signingConfig
        variant.outputs.each { BaseVariantOutput output ->
          //输出的apk文件
          File apk = output.outputFile
          //创建加固任务  jiag  Debug
          JiaguTask jiaguTask = project.tasks.create("jiagu${variant.baseName.capitalize()}", JiaguTask)
          jiaguTask.jiagu = jiagu
          jiaguTask.signingConfig = signingConfig
          jiaguTask.apk = apk
        }
      }
    }
  }
}