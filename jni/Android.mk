LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := splatoid
LOCAL_SRC_FILES := splatoid.c
include $(BUILD_SHARED_LIBRARY)
