#include <jni.h>
#include <stdio.h>

#include "../include/uk_ac_hud_jnvi_api_JNVIAPI.h"
#include "../include/jnvi.h"

//----------------------
// Java Native Vectorisation Interface (JNVI)
// Java Native Interface (JNI) Implementation
//
// Author: Jaspreet Singh Dhanjan
// The University of Huddersfield
// ----------------------

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeInit(JNIEnv* env, jclass clazz) {
    return jnvi_is_supported();
}

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_getVersion0(JNIEnv* env, jclass clazz) {
    return JNVI_API_VERSION;
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_add(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_add_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_add_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_add_i(av, bv, cv, len);
    } else {
        (*env)->ThrowNew(env, (*env)->FindClass(env, "java/lang/IllegalArgumentException"), "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_add(jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_add_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_add_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_add_i(av, bv, cv, len);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_sub(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_sub_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_sub_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_sub_i(av, bv, cv, len);
    } else {
        (*env)->ThrowNew(env, (*env)->FindClass(env, "java/lang/IllegalArgumentException"), "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_sub(jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_sub_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_sub_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_sub_i(av, bv, cv, len);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_mul(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_mul_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_mul_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_mul_i(av, bv, cv, len);
    } else {
        (*env)->ThrowNew(env, (*env)->FindClass(env, "java/lang/IllegalArgumentException"), "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_mul(jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_mul_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_mul_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_mul_i(av, bv, cv, len);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_div(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_div_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_div_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_div_i(av, bv, cv, len);
    } else {
        (*env)->ThrowNew(env, (*env)->FindClass(env, "java/lang/IllegalArgumentException"), "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_div(jbyte type, jlong srcA, jlong srcB, jlong dest, jint len) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_div_d(av, bv, cv, len);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_div_f(av, bv, cv, len);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_div_i(av, bv, cv, len);
    } else {
    }
}

/*
JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_multiply___3J_3J_3J(JNIEnv *env, jclass clazz, jlongArray a, jlongArray b, jlongArray c) {
    jsize len = (*env)->GetArrayLength(env, a);

    jlong *aref = (*env)->GetLongArrayElements(env, a, 0);
    jlong *bref = (*env)->GetLongArrayElements(env, b, 0);
    jlong *cref = (*env)->GetLongArrayElements(env, c, 0);

    for(int i = 0; i < len; i++) {
        float *av = (void*) aref[i];
        float *bv = (void*) bref[i];
        float *cv = (void*) cref[i];

        mul_store_floats(av, bv, cv);
    }

    (*env)->ReleaseLongArrayElements(env, a, aref, 0);
    (*env)->ReleaseLongArrayElements(env, b, bref, 0);
    (*env)->ReleaseLongArrayElements(env, c, cref, 0);
}*/