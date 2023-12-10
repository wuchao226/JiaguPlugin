package com.wuc.plugin

class JiaguExtension {
  // 360账号
  String userName
  // 360密码
  String password
  // 加固工具路径
  String jiaguTools

  String getUserName() {
    return userName
  }

  void setUserName(String userName) {
    this.userName = userName
  }

  String getPassword() {
    return password
  }

  void setPassword(String password) {
    this.password = password
  }

  String getJiaguTools() {
    return jiaguTools
  }

  void setJiaguTools(String jiaguTools) {
    this.jiaguTools = jiaguTools
  }
}