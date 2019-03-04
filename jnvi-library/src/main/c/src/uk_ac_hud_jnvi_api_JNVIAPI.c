#include <jni.h>
#include <stdio.h>

#include "../include/uk_ac_hud_jnvi_api_JNVIAPI.h"
#include "../include/jnvi.h"

#define JNVI_API_VERSION 1;

JNIEXPORT jboolean JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeInit(JNIEnv* env, jclass clazz) {
    printf("\n----------------------------------\nInitialising JNVI API\n----------------------------------\n");
    return is_supported();
}

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_getVersion(JNIEnv* env, jclass clazz) {
    return JNVI_API_VERSION;
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeMultiply(JNIEnv *env, jclass clazz, jlong a, jlong b, jlong c) {
    float *av = (void*) a;
    float *bv = (void*) b;
    float *cv = (void*) c;

    mul_store_floats(av, bv, cv);
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_nativeMultiply(jlong a, jlong b, jlong c) {
    float *av = (void*) a;
    float *bv = (void*) b;
    float *cv = (void*) c;

    mul_store_floats(av, bv, cv);
}