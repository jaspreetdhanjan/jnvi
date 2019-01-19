#include <jni.h>
#include <immintrin.h>
#include <stdio.h>

#include "../include/uk_ac_hud_jnvi_api_JNVIAPI.h"

#define JNVI_API_VERSION 1;

unsigned int isInitialised = 0;

/**
    https://software.intel.com/sites/landingpage/IntrinsicsGuide/

    https://www.codeproject.com/Articles/874396/Crunching-Numbers-with-AVX-and-AVX
*/

JNIEXPORT jboolean JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeInit(JNIEnv* env, jclass clazz) {
    if(isInitialised == 1) {
        return 1;
    }

    printf("\n----------------------------------\nInitialising JNVI API\n----------------------------------\n");
    isInitialised = 1;

    // TODO: Check for SIMD support!
    return 1;
}

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_getVersion(JNIEnv* env, jclass clazz) {
    return JNVI_API_VERSION;
}

// HEAP MEMORY
/*
JNIEXPORT jfloatArray JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_multiply(JNIEnv *env, jclass clazz, jfloatArray a, jfloatArray b) {
    jsize len = (*env)->GetArrayLength(env, a);

    jfloatArray c = (*env)->NewFloatArray(env, len);

    jfloat *aBody = (*env)->GetFloatArrayElements(env, a, 0);
    jfloat *bBody = (*env)->GetFloatArrayElements(env, b, 0);
    jfloat *cBody = (*env)->GetFloatArrayElements(env, c, 0);

    for(int i=0; i<len; i++) {
        cBody[i] = aBody[i] * bBody[i];
    }

    (*env)->ReleaseFloatArrayElements(env, a, aBody, 0);
    (*env)->ReleaseFloatArrayElements(env, b, bBody, 0);
    (*env)->ReleaseFloatArrayElements(env, c, cBody, 0);

    return c;
}*/

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeMultiply(JNIEnv *env, jclass clazz, jlong a, jlong b, jlong c, jlong length) {
    size_t len = (size_t) length;
    if (len == 0) {
        return;
    }

    float *av = (void*) a;
    float *bv = (void*) b;
    float *cv = (void*) c;

    __m128 vector1 = _mm_setr_ps(av[0], av[1], av[2], av[3]);
    __m128 vector2 = _mm_setr_ps(bv[0], bv[1], bv[2], bv[3]);

    __m128 sum = _mm_mul_ps(vector1, vector2);

    cv[0] = sum[0];
    cv[1] = sum[1];
    cv[2] = sum[2];
    cv[3] = sum[3];
}

/**
* Critical implementation of above method. Referenced from: https://stackoverflow.com/questions/36298111/is-it-possible-to-use-sun-misc-unsafe-to-call-c-functions-without-jni
*/

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_nativeMultiply(jlong a, jlong b, jlong c, jlong length) {
    size_t len = (size_t) length;
    if (len == 0) {
        return;
    }

    float *av = (void*) a;
    float *bv = (void*) b;
    float *cv = (void*) c;

    __m128 vector1 = _mm_setr_ps(av[0], av[1], av[2], av[3]);
    __m128 vector2 = _mm_setr_ps(bv[0], bv[1], bv[2], bv[3]);

    __m128 sum = _mm_mul_ps(vector1, vector2);

    cv[3] = sum[0];
    cv[2] = sum[1];
    cv[1] = sum[2];
    cv[0] = sum[3];
}

//JNIEXPORT void JNICALL
//JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_nativeMultiply(jlong a, jlong b, jlong c, jlong length) {
//    size_t len = (size_t) length;
//    if (len == 0) {
//        return;
//    }
//
//    float *av = (void*) a;
//    float *bv = (void*) b;
//    float *cv = (void*) c;
//
//    for (int i=0; i<len; i++) {
//        cv[i] = av[i] * bv[i];
//    }
//}