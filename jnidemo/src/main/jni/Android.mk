#此文件是在 一键工具 .c -> .so 时使用
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
#生成so文件
LOCAL_MODULE    := manydemo
#c文件
LOCAL_SRC_FILES := tools.c
#生成类型:shared(动态库)
include $(BUILD_SHARED_LIBRARY)