LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := python2.6
LOCAL_SRC_FILES := libpython2.6.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := splatoid
LOCAL_SRC_FILES := splatoid.c
LOCAL_C_INCLUDES += $(LOCAL_PATH)/Include
LOCAL_SHARED_LIBRARIES := python2.6
include $(BUILD_SHARED_LIBRARY)
