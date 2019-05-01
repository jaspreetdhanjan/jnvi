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

jclass global_iae_class;

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_nativeInit(JNIEnv* env, jclass clazz) {
	// Cache a reference to the IllegalArgumentException. This will need to be disposed.

	jclass local_iae_class = (*env)->FindClass(env, "java/lang/IllegalArgumentException");
	global_iae_class = (jclass) ((*env)->NewGlobalRef(env, local_iae_class));

    return jnvi_is_supported();
}

JNIEXPORT jint JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_getVersion0(JNIEnv* env, jclass clazz) {
    return JNVI_API_VERSION;
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_add(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_add_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_add_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_add_i(av, bv, cv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_add(jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_add_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_add_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_add_i(av, bv, cv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_sub(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_sub_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_sub_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_sub_i(av, bv, cv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_sub(jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_sub_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_sub_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_sub_i(av, bv, cv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_mul(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_mul_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_mul_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_mul_i(av, bv, cv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_mul(jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_mul_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_mul_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_mul_i(av, bv, cv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_div(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_div_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_div_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_div_i(av, bv, cv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_div(jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_div_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_div_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_div_i(av, bv, cv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_dot(JNIEnv *env, jclass clazz, jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_dot_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_dot_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_dot_i(av, bv, cv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_dot(jbyte type, jlong srcA, jlong srcB, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) srcA;
        double *bv = (void*) srcB;
        double *cv = (void*) dest;

        jnvi_dot_d(av, bv, cv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) srcA;
        float *bv = (void*) srcB;
        float *cv = (void*) dest;

        jnvi_dot_f(av, bv, cv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) srcA;
        int *bv = (void*) srcB;
        int *cv = (void*) dest;

        jnvi_dot_i(av, bv, cv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_sum(JNIEnv *env, jclass clazz, jbyte type, jlong src, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) src;
        double *bv = (void*) dest;

        jnvi_sum_d(av, bv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) src;
        float *bv = (void*) dest;

        jnvi_sum_f(av, bv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) src;
        int *bv = (void*) dest;

        jnvi_sum_i(av, bv, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_sum(jbyte type, jlong src, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *av = (void*) src;
        double *bv = (void*) dest;

        jnvi_sum_d(av, bv, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *av = (void*) src;
        float *bv = (void*) dest;

        jnvi_sum_f(av, bv, n);
    } else if(type == JNVI_TYPE_INT) {
        int *av = (void*) src;
        int *bv = (void*) dest;

        jnvi_sum_i(av, bv, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_sqrt(JNIEnv *env, jclass clazz, jbyte type, jlong src, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *val = (void*) src;
        double *res = (void*) dest;

        jnvi_sqrt_d(val, res, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *val = (void*) src;
        float *res = (void*) dest;

        jnvi_sqrt_f(val, res, n);
    } else {
        (*env)->ThrowNew(env, global_iae_class, "Input type is unrecognised.");
    }
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_sqrt(jbyte type, jlong src, jlong dest, jint n) {
    if(type == JNVI_TYPE_DOUBLE) {
        double *val = (void*) src;
        double *res = (void*) dest;

        jnvi_sqrt_d(val, res, n);
    } else if(type == JNVI_TYPE_FLOAT) {
        float *val = (void*) src;
        float *res = (void*) dest;

        jnvi_sqrt_f(val, res, n);
    } else {
    }
}

JNIEXPORT void JNICALL
Java_uk_ac_hud_jnvi_api_JNVIAPI_rsqrt(JNIEnv *env, jclass clazz, jlong src, jlong dest, jint n) {
	float *val = (void*) src;
	float *res = (void*) dest;

	jnvi_rsqrt_f(val, res, n);
}

JNIEXPORT void JNICALL
JavaCritical_uk_ac_hud_jnvi_api_JNVIAPI_rsqrt(jlong src, jlong dest, jint n) {
	float *val = (void*) src;
	float *res = (void*) dest;

	jnvi_rsqrt_f(val, res, n);
}